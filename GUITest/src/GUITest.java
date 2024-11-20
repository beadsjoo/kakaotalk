import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUITest {
	public static void main(String[] args) {
		JFrame f = new JFrame("Frame Test");
		f.setTitle("MyFrame");

		JButton button = new JButton("버튼1");

		Container cont = f.getContentPane(); // 컨텐트팬 알아내기
		cont.add(button); // 컨텐트팬에 버튼 부착

		f.setSize(300, 200);
		f.setLocation(400, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}