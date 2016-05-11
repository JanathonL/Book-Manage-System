package activity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static activity.SwingConsole.*;

public class WelcomeActivity extends JFrame {
	
	static String administratorId;
	public WelcomeActivity(String administratorId) {
		this.administratorId=administratorId;
		System.out.println("Login page administrator: "+administratorId);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("入库");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				setVisible(false);
				new BooksWarehouse(administratorId);
			}
		});
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("查询");
		menu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				setVisible(false);
				new SearchActivity(administratorId);
			}
		});
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("借书");
		menu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				setVisible(false);
				new BorrowActivity(administratorId);
			}
		});
		menuBar.add(menu_2);
		
		JMenu menu_3 = new JMenu("还书");
		menu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				setVisible(false);
				new ReturnActivity(administratorId);
			}
		});
		menuBar.add(menu_3);
		
		JMenu menu_4 = new JMenu("借阅证管理");
		menu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				setVisible(false);
				new CardManageActivity(administratorId);
			}
		});
		menuBar.add(menu_4);
		
		JLabel lblLabel = new JLabel();
		ImageIcon icon = new ImageIcon("src/background.jpg");
//		Icon[] icon=new Icon[]{
//				new ImageIcon(getClass().getResource("Face0.gif"))
//		};
		lblLabel.setDisabledIcon(icon);
		lblLabel.setEnabled(false);
		getContentPane().add(lblLabel, BorderLayout.CENTER);
		run(this,600,400,"欢迎界面");
	}
	public static void main(String[] agrs){
		new WelcomeActivity(administratorId);
	}

}
