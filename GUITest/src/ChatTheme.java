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

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.event.DocumentListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
	private static tomato_emojiPanel tomato;
	private JLabel emojiLabel;
	private JScrollPane chatScroll;
	private AlphaComposite alphaComposite;
	private static ChatTheme frame = new ChatTheme();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setFrame(ChatTheme frame) {
		this.frame = frame;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void setChatPanel(JPanel chatPanel) {
		this.ChatPanel = chatPanel;
	}

	public ChatTheme() {
		setTitle("KakaoTalk");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 450, 650);
		ChatPanel = new JPanel();
		ChatPanel.setBackground(new Color(237, 244, 255));
		ChatPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setUndecorated(true);
		
		// window의 AWT 사용해서 frame 투명도 설정
		// 투명도 지원 여부 출력
		if (!GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT)) {
            System.out.println("이 시스템은 투명도를 지원하지 않습니다.");
            return;
        }

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
		popupMenu.setBackground(new Color(255, 255, 255));
		popupMenu.setFont(new Font("프리젠테이션 5 Medium", Font.PLAIN, 15));
		popupMenu.setPopupSize(new Dimension(103, 60));
		popupMenu.setBorderPainted(false);
		addPopup(menuBtn, popupMenu);
		
		JButton noticeBtn = new JButton("채팅 공지");
		noticeBtn.setBackground(new Color(255, 255, 255));
		noticeBtn.setVerticalAlignment(SwingConstants.TOP);
		noticeBtn.setIcon(new ImageIcon("C:\\Users\\pamil\\git\\kakaotalk\\GUITest\\images\\announceIcon.png"));
		noticeBtn.setFont(new Font("프리젠테이션 5 Medium", Font.PLAIN, 15));
		noticeBtn.setFocusable(false);
		noticeBtn.setContentAreaFilled(false);
		popupMenu.add(noticeBtn);
		
		JButton voteBtn = new JButton("투표 기능");
		voteBtn.setVerticalAlignment(SwingConstants.TOP);
		voteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		voteBtn.setFocusable(false);
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
		sendBtn.setBounds(372, -5, 63, 39);
		panel.add(sendBtn);
		sendBtn.setFont(new Font("프리젠테이션 5 Medium", Font.PLAIN, 15));
		sendBtn.setBackground(new Color(255, 235, 0));
		sendBtn.setFocusPainted(false);
		sendBtn.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		sendBtn.addActionListener(new Myaction());
		visibleSlider.setValue(100);
		visibleSlider.setBounds(280, 8, 87, 21);
		visibleSlider.setBackground(new Color(255, 255, 255));
		visibleSlider.setMinimum(20);
		visibleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = visibleSlider.getValue(); // 슬라이더 값 가져오기
                getFrame().setOpacity(value*0.01f);
            }
        });
		panel.add(visibleSlider);
		

		JButton emojiBtn = new JButton("");
		emojiBtn.setBounds(0, 0, 37, 37);
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
		entryScroll.setBounds(5, 459, 428, 115);
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

		entryArea.setTabSize(0);
		entryScroll.setViewportView(entryArea);
		entryArea.setFont(new Font("프리젠테이션 5 Medium", Font.PLAIN, 15));
		entryArea.setBackground(new Color(255, 255, 255));
		entryArea.setLineWrap(true);
		
		JPanel bgPanel = new JPanel();
		bgPanel.setBorder(null);
		bgPanel.setBackground(new Color(255, 255, 255));
		bgPanel.setBounds(0, 459, 438, 119);
		ChatPanel.add(bgPanel);
		
		
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
