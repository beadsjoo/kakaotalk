import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;

public class tomato_emojiPanel extends JPanel {
	JButton agreeBtn = new JButton();
	JButton alcoholBtn = new JButton();
	JButton babyBtn = new JButton();
	JButton batBtn = new JButton();
	JButton burpBtn = new JButton();
	JButton bdayBtn = new JButton();
	JButton carrotBtn = new JButton();
	JButton cheersBtn = new JButton();
	JButton driveBtn = new JButton();
	JButton ewkBtn = new JButton();
	JButton fireBtn = new JButton();
	JButton gentleBtn = new JButton();
	JButton GNBtn = new JButton();
	JButton heyBtn = new JButton();
	JButton hugBtn = new JButton();
	JButton kissBtn = new JButton();
	JButton goBtn = new JButton();
	JButton loveBtn = new JButton();
	JButton mirrorBtn = new JButton();
	JButton mondayBtn = new JButton();
	JButton noiseBtn = new JButton();
	JButton okBtn = new JButton();
	JButton punchBtn = new JButton();
	JButton resignBtn = new JButton();
	JButton sadBtn = new JButton();
	JButton shyBtn = new JButton();
	JButton strongBtn = new JButton();
	JButton studyBtn = new JButton();
	JButton sulkBtn = new JButton();
	JButton tadaBtn = new JButton();
	JButton thumbBtn = new JButton();
	JButton touchedBtn = new JButton();
	
	JButton[] emojis = { agreeBtn, alcoholBtn, babyBtn, batBtn, burpBtn, bdayBtn, carrotBtn, cheersBtn, driveBtn,
			ewkBtn, fireBtn, gentleBtn, GNBtn, heyBtn, hugBtn, kissBtn, goBtn, loveBtn, mirrorBtn, mondayBtn,
			noiseBtn, okBtn, punchBtn, resignBtn, sadBtn, shyBtn, strongBtn, studyBtn, sulkBtn, tadaBtn, thumbBtn,
			touchedBtn

	};
	
	ImageIcon[] emojiPath = {
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\agree.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\alcohol.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\baby.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\bat.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\bday.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\burp.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\carrot.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\cheers.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\drive.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\ewk.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\fire.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\gentle.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\GN.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\hey.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\hug.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\kiss.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\go.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\love.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\mirror.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\monday.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\noise.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\ok.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\punch.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\resign.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\sad.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\shy.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\strong.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\study.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\sulk.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\tada.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\thumb.png"),
			new ImageIcon("C:\\java\\GUITest\\emoji\\tomato\\touched.png"),
	};
	
	private ChatTheme chat;
	private JLabel emoji;
	public int emojiNum = 0;
	public String emojipath = null;
	
	public tomato_emojiPanel(ChatTheme chatTheme) {
		this.chat = chat;
		
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(255, 255, 255), 4, true));
		setLayout(new GridLayout(8, 4, 5, 5));

		for (int i = 0; i < emojis.length; i++) {
			emojis[i].setPreferredSize(new java.awt.Dimension(70, 70));
			emojis[i].setIcon(emojiPath[i]);
			emojis[i].setContentAreaFilled(false);
			emojis[i].setBorderPainted(false);
			emojis[i].setBackground(new Color(255, 255, 255));
			add(emojis[i]);
		}
		
		agreeBtn.addActionListener(new Myaction(this.chat));

	}
	
	class Myaction implements ActionListener {
		private ChatTheme chat;
		
		public Myaction(ChatTheme chat) {
	        this.chat = chat;
	    }
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("액션 리스너 호출");
			emojiNum = 1;
			emojipath = emojiPath[emojiNum - 1].toString();
			System.out.println(emojipath);
			chat.addEmoji(emojipath);
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
