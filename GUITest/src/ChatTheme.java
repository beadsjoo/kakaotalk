import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.*;
import javax.swing.text.StyleConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import java.awt.Color;
import java.awt.Font;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;
import java.awt.Dimension;

public class ChatTheme<tomato_emojiaPanel> extends JFrame {

	private emojiFrame emoji;
	private JPanel ChatPanel;
	private final JSlider visibleSlider = new JSlider();
	private JButton sendBtn;
	private JTextArea entryArea;
	public JTextArea chatArea;
	private JScrollPane scrollPane;
	private tomato_emojiPanel tomato;
	private JLabel emojiLabel;
	private JScrollPane chatScroll;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatTheme frame = new ChatTheme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChatTheme() {		
		setTitle("KakaoTalk");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 450, 650);
		ChatPanel = new JPanel();
		ChatPanel.setBackground(new Color(237, 244, 255));
		ChatPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		tomato = new tomato_emojiPanel(this);

		setContentPane(ChatPanel);
		ChatPanel.setLayout(null);

		JButton menuBtn = new JButton("");
		menuBtn.setBackground(new Color(237, 244, 255));
		menuBtn.setBounds(410, 8, 20, 20);
		menuBtn.setIcon(new ImageIcon("C:\\Users\\pamil\\git\\kakaotalk\\GUITest\\images\\menu.png"));
		menuBtn.setFocusable(false);
		menuBtn.setBorderPainted(false);
		menuBtn.setContentAreaFilled(false);
		ChatPanel.add(menuBtn);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setFont(new Font("프리젠테이션 5 Medium", Font.PLAIN, 15));
		popupMenu.setPopupSize(new Dimension(103, 60));
		popupMenu.setBorderPainted(false);
		addPopup(menuBtn, popupMenu);
		
		JButton noticeBtn = new JButton("채팅 공지");
		noticeBtn.setVerticalAlignment(SwingConstants.TOP);
		noticeBtn.setIcon(new ImageIcon("C:\\Users\\pamil\\git\\kakaotalk\\GUITest\\images\\announceIcon.png"));
		noticeBtn.setFont(new Font("프리젠테이션 5 Medium", Font.PLAIN, 15));
		noticeBtn.setFocusable(false);
//		noticeBtn.setBorderPainted(false);
		noticeBtn.setContentAreaFilled(false);
		popupMenu.add(noticeBtn);
		
		JButton voteBtn = new JButton("투표 기능");
		voteBtn.setVerticalAlignment(SwingConstants.TOP);
		voteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		voteBtn.setFocusable(false);
//		noticeBtn.setBorderPainted(false);
		voteBtn.setContentAreaFilled(false);
		voteBtn.setIcon(new ImageIcon("C:\\Users\\pamil\\git\\kakaotalk\\GUITest\\images\\voteIcon.png"));
		voteBtn.setFont(new Font("프리젠테이션 5 Medium", Font.PLAIN, 15));
		popupMenu.add(voteBtn);

		JLabel userNumLabel = new JLabel("1");
		userNumLabel.setFont(new Font("프리젠테이션 5 Medium", Font.PLAIN, 14));
		userNumLabel.setBounds(95, 49, 32, 35);
		ChatPanel.add(userNumLabel);

		JLabel userImgLabel = new JLabel("");
		userImgLabel.setBounds(80, 50, 25, 30);
		userImgLabel.setIcon(new ImageIcon("C:\\Users\\pamil\\git\\kakaotalk\\GUITest\\images\\user1.png"));
		ChatPanel.add(userImgLabel);

		JLabel nameLabel = new JLabel("박민주");
		
		nameLabel.setBounds(80, 18, 306, 20);
		nameLabel.setFont(new Font("프리젠테이션 5 Medium", Font.PLAIN, 16));
		ChatPanel.add(nameLabel);

		JLabel profileLabel = new JLabel(new ImageIcon("C:\\Users\\pamil\\git\\kakaotalk\\GUITest\\images\\profile.png"));
		profileLabel.setForeground(new Color(255, 255, 255));
		profileLabel.setBackground(new Color(255, 255, 255));
		profileLabel.setBounds(10, 13, 66, 66);
		ChatPanel.add(profileLabel);
		
		chatScroll = new JScrollPane();
		chatScroll.setBounds(5, 85, 428, 373);
		ChatPanel.add(chatScroll);
		chatScroll.setFocusable(false);
		chatScroll.getVerticalScrollBar().setUnitIncrement(10);
		chatScroll.setBorder(null);

		setChatArea(new JTextArea()); // 인스턴스 변수로 할당
		getChatArea().setTabSize(4);
		getChatArea().setBackground(new Color(237, 244, 255));
		getChatArea().setEditable(false);
		getChatArea().setDocument(new DefaultStyledDocument());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 578, 438, 37);
		ChatPanel.add(panel);
		panel.setLayout(null);

		sendBtn = new JButton("전송");
		sendBtn.setBounds(377, 0, 61, 37);
		panel.add(sendBtn);
		sendBtn.setFont(new Font("프리젠테이션 5 Medium", Font.PLAIN, 15));
		sendBtn.setBackground(new Color(255, 255, 255));
		sendBtn.setFocusPainted(false);
		sendBtn.addActionListener(new Myaction());
		visibleSlider.setBounds(285, 14, 87, 21);
		panel.add(visibleSlider);
		visibleSlider.setBackground(new Color(255, 255, 255));

		JButton emojiBtn = new JButton("");
		emojiBtn.setBounds(0, 0, 35, 37);
		panel.add(emojiBtn);
		emojiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emoji = new emojiFrame();
				emoji.setVisible(true);
			}
		});
		emojiBtn.setBackground(new Color(255, 255, 255));
		emojiBtn.setIcon(new ImageIcon("C:\\Users\\pamil\\git\\kakaotalk\\GUITest\\images\\emoji.png"));
		emojiBtn.setFocusPainted(false);
		emojiBtn.setBorderPainted(false);
		emojiBtn.setContentAreaFilled(false);

		JScrollPane entryScroll = new JScrollPane();
		entryScroll.setBounds(0, 459, 438, 119);
		entryScroll.setFocusable(false);
		entryScroll.getVerticalScrollBar().setUnitIncrement(10);
		entryScroll.setBorder(null);

		ChatPanel.add(entryScroll);

		// 메시지 입력창 수정: JTextArea로 변경
		entryArea = new JTextArea(); // 인스턴스 변수로 할당
		entryArea.setForeground(new Color(192, 192, 192));
		entryArea.setText("메시지 입력");
		entryArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				entryArea.setForeground(Color.black);
				entryArea.setText("");
			}
		});

		entryArea.setTabSize(4);
		entryScroll.setViewportView(entryArea);
		entryArea.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		entryArea.setBackground(new Color(255, 255, 255));
		entryArea.setLineWrap(true);
		
		chatArea.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				SwingUtilities.invokeLater(() -> {
					JScrollBar vertical = chatScroll.getVerticalScrollBar();
					vertical.setValue(vertical.getMaximum());
				});
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				SwingUtilities.invokeLater(() -> {
					JScrollBar vertical = chatScroll.getVerticalScrollBar();
					vertical.setValue(vertical.getMaximum());
				});
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		entryArea.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				SwingUtilities.invokeLater(() -> {
					JScrollBar vertical = entryScroll.getVerticalScrollBar();
					vertical.setValue(vertical.getMaximum());
				});
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				SwingUtilities.invokeLater(() -> {
					JScrollBar vertical = entryScroll.getVerticalScrollBar();
					vertical.setValue(vertical.getMaximum());
				});
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

	}

	public JTextArea getChatArea() {
		return chatArea;
	}

	public void setChatArea(JTextArea chatArea) {
		this.chatArea = chatArea;
		chatArea.setFont(new Font("프리젠테이션 5 Medium", Font.PLAIN, 15));
		chatScroll.setViewportView(chatArea);
	}
	
	public void addEmoji(String emojiPath) {
		emojiLabel = new JLabel(new ImageIcon(emojiPath));
		chatArea.add(emojiLabel);
	}

	class Myaction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Send button을 누르거나 메시지 입력하고 Enter key 치면
			System.out.println("액션 리스너 호출됨");
			String msg = null;
			msg = String.format("%s\n", entryArea.getText());
			System.out.println("msg:" + msg);
			
			if(!(msg.trim()).isEmpty()) {
				AppendText(msg);
				entryArea.setText(""); // 메시지를 보내고 나면 메시지 쓰는 창을 비운다.
				entryArea.requestFocus(); // 메시지를 보내고 커서를 다시 텍스트 필드로 위치시킨다
			}
		}

		// 화면에 출력
		public void AppendText(String msg) {
			getChatArea().append(msg);
			getChatArea().setCaretPosition(entryArea.getText().length());
			getChatArea().setAutoscrolls(true);
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
