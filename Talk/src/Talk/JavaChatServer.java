package Talk;
import java.io.*;
import java.net.*;
import java.util.Vector;

public class JavaChatServer {

    private static final int PORT = 30000; // 기본 포트 번호
    private ServerSocket serverSocket;
    private Vector<UserService> userVector = new Vector<>(); // 연결된 사용자 저장

    public JavaChatServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Chat server running on port " + PORT);
            while (true) {
                System.out.println("Waiting for clients...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);
                UserService user = new UserService(clientSocket);
                userVector.add(user);
                user.start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    class UserService extends Thread {
        private Socket clientSocket;
        private DataInputStream dis;
        private DataOutputStream dos;
        private String userName;

        public UserService(Socket socket) {
            this.clientSocket = socket;
            try {
                dis = new DataInputStream(clientSocket.getInputStream());
                dos = new DataOutputStream(clientSocket.getOutputStream());
                userName = dis.readUTF().split(" ")[1]; // 첫 메시지로 "/login userName" 받음
                broadcastMessage("[" + userName + "] joined the chat!");
                System.out.println(userName + " has joined the chat.");
            } catch (IOException e) {
                System.err.println("Error initializing user service: " + e.getMessage());
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = dis.readUTF()) != null) {
                    System.out.println(userName + ": " + message);
                    broadcastMessage(userName + ": " + message);
                }
            } catch (IOException e) {
                System.err.println(userName + " disconnected.");
            } finally {
                disconnectUser();
            }
        }

        private void broadcastMessage(String message) {
            synchronized (userVector) {
                for (UserService user : userVector) {
                    try {
                        user.dos.writeUTF(message);
                    } catch (IOException e) {
                        System.err.println("Failed to send message to " + user.userName);
                    }
                }
            }
        }

        private void disconnectUser() {
            try {
                userVector.remove(this);
                broadcastMessage("[" + userName + "] left the chat.");
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error disconnecting user: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new JavaChatServer();
    }
}
