package activity;



import javax.swing.*;

public class SwingConsole {
	public static void run(final JFrame f, final int width, final int height, final String s) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				f.setTitle(s);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(width, height);
				f.setVisible(true);
			}
		});
	}
} /// :~