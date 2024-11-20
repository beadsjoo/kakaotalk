//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JTextField;
//import javax.swing.JLabel;
//import java.awt.Color;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.Font;
//
//public class LoginTheme extends JFrame {
//
//	private JPanel LoginPanel;
//	private JTextField IPField;
//	private JTextField nameField;
//	private JTextField portField;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginTheme frame = new LoginTheme();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public LoginTheme() {
//		setTitle("KakaoTalk");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 300, 425);
//		LoginPanel = new JPanel();
//		LoginPanel.setBackground(new Color(255, 235, 0));
//		LoginPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//
//		setContentPane(LoginPanel);
//		LoginPanel.setLayout(null);
//		
//		JLabel logoLabel = new JLabel("\"Kakao\r\nTalk\"");
//		logoLabel.setForeground(new Color(255, 255, 255));
//		logoLabel.setBounds(83, 67, 109, 20);
//		logoLabel.setFont(new Font("롯데리아 촵땡겨체", Font.PLAIN, 16));
//		LoginPanel.add(logoLabel);
//		
//		JLabel icon = new JLabel("");
//		icon.setBackground(new Color(0, 0, 0));
//		icon.setBounds(64, 32, 176, 118);
//		icon.setIcon(new ImageIcon("C:\\pamil\\git\\GUITest\\images\\msg_icon.png"));
//		LoginPanel.add(icon);
//		
//		JLabel IPLable = new JLabel("IP Address");
//		IPLable.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
//		IPLable.setBounds(111, 205, 62, 15);
//		LoginPanel.add(IPLable);
//		
//		JLabel nameLabel = new JLabel("Your name");
//		nameLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
//		nameLabel.setBounds(111, 149, 62, 15);
//		LoginPanel.add(nameLabel);
//		
//		JLabel portLabel = new JLabel("Port Number");
//		portLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
//		portLabel.setBounds(105, 260, 72, 15);
//		LoginPanel.add(portLabel);
//		
//		JButton btnNewButton = new JButton("Login");
//		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnNewButton.setBounds(59, 331, 163, 23);
//		LoginPanel.add(btnNewButton);
//		
//		IPField = new JTextField();
//		IPField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
//		IPField.setForeground(new Color(207, 207, 207));
//		IPField.setText("Enter Your IP Address");
//		IPField.setBounds(59, 229, 163, 21);
//		LoginPanel.add(IPField);
//		IPField.setColumns(10);
//		
//		nameField = new JTextField();
//		nameField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
//		nameField.setText("Enter Your Name");
//		nameField.setForeground(new Color(207, 207, 207));
//		nameField.setColumns(10);
//		nameField.setBounds(59, 174, 163, 21);
//		LoginPanel.add(nameField);
//		
//		portField = new JTextField();
//		portField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
//		portField.setText("Enter Your Port Number");
//		portField.setForeground(new Color(207, 207, 207));
//		portField.setColumns(10);
//		portField.setBounds(59, 285, 163, 21);
//		LoginPanel.add(portField);
//	}
//}
