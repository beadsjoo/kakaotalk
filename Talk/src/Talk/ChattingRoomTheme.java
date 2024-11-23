package Talk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

public class ChattingRoomTheme extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;


    public ChattingRoomTheme() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 443, 651);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        // 왼쪽 패널 설정 (친구 목록, 채팅방 목록 버튼)
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(60, 0));
        leftPanel.setBackground(new Color(227, 227, 227));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        // 이미지 버튼 설정 (크기 조정)
        ImageIcon friendIcon = new ImageIcon("C:/Talk/Talk/resource/friend.png");
        Image friendImage = friendIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JButton friendsButton = new JButton(new ImageIcon(friendImage));

        ImageIcon chatIcon = new ImageIcon("C:/Talk/Talk/resource/messageClicked.png");
        Image chatImage = chatIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JButton chatButton = new JButton(new ImageIcon(chatImage));

        // 버튼을 투명하게 설정
        friendsButton.setOpaque(false);
        friendsButton.setContentAreaFilled(false);
        friendsButton.setBorderPainted(false);

        chatButton.setOpaque(false);
        chatButton.setContentAreaFilled(false);
        chatButton.setBorderPainted(false);
        
        // chatButton 클릭 시 FriendListTheme으로 이동하는 이벤트 리스너 추가
        friendsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	FriendListTheme friendListFrame = new FriendListTheme();
            	friendListFrame.setVisible(true);
                dispose();  // 현재 창 닫기
            }
        });

        // 버튼을 패널에 추가
        leftPanel.add(friendsButton);
        leftPanel.add(chatButton);

        contentPane.add(leftPanel, BorderLayout.WEST);

     // 오른쪽 패널 설정
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        // 상단 패널: "친구" 텍스트와 친구 추가 아이콘
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(255, 255, 255));
        JLabel titleLabel = new JLabel("채팅");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        topPanel.add(titleLabel, BorderLayout.WEST);

        ImageIcon addIcon = new ImageIcon("C:/Talk/Talk/resource/addChatRoom.png");
        Image addImage = addIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JButton addFriendButton = new JButton(new ImageIcon(addImage));
        addFriendButton.setOpaque(false);
        addFriendButton.setContentAreaFilled(false);
        addFriendButton.setBorderPainted(false);
        topPanel.add(addFriendButton, BorderLayout.EAST);

        rightPanel.add(topPanel, BorderLayout.NORTH);

        // 하단 패널: 친구 목록 (스크롤 가능하게 설정)
        JPanel friendsListPanel = new JPanel();
        friendsListPanel.setBackground(new Color(255, 255, 255));
        friendsListPanel.setLayout(new BoxLayout(friendsListPanel, BoxLayout.Y_AXIS));

        // 샘플 채팅 추가
        for (int i = 1; i <= 10; i++) {
            JLabel friendLabel = new JLabel("채팅 " + i);
            friendLabel.setBorder(new EmptyBorder(5, 10, 5, 10));
            friendsListPanel.add(friendLabel);
        }

        JScrollPane scrollPane = new JScrollPane(friendsListPanel);
        scrollPane.setPreferredSize(new Dimension(0, 400)); // 스크롤 패널 크기 지정
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        contentPane.add(rightPanel, BorderLayout.CENTER);
    }
}
