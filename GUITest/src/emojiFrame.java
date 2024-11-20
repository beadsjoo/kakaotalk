import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class emojiFrame extends JFrame {

	private JPanel emojiPanel;
	private ChatTheme chatTheme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					emojiFrame frame = new emojiFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public emojiFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(850, 100, 330, 420);
		setTitle("emoticon");
		emojiPanel = new JPanel();
		emojiPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(emojiPanel);
		emojiPanel.setLayout(null);

		Panel selectPanel = new Panel();
		selectPanel.setBounds(0, 0, 318, 27);
		emojiPanel.add(selectPanel);
		selectPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 24, 318, 361);
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);

		emojiPanel.add(scrollPane);

		tomato_emojiPanel tomato = new tomato_emojiPanel(chatTheme);
		tomato.setBounds(0, 27, 280, 370);
		scrollPane.setViewportView(tomato);;
		
	}
}
