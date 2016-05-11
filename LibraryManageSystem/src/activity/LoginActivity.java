package activity;

import javax.swing.*;
import sql.LoginCheck;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import static activity.SwingConsole.*;

public class LoginActivity extends JFrame {
	String administratorId;
	private JTextField userName = new JTextField(30);
	private JPasswordField passwd = new JPasswordField();
	// userName=new JTextField();
	private static JLabel userNameLabel = new JLabel("用户名", SwingConstants.CENTER),
			passwdLabel = new JLabel("密码", SwingConstants.CENTER);
	private JButton login = new JButton("登陆");
	private JTextField textField;
	class MyLogin implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name=userName.getText();
			String p=String.valueOf(passwd.getPassword());
			LoginCheck lc=new LoginCheck(name, p);
			try {
				if(lc.Isok()==true){
					textField.setText("login successfully");
					setVisible(false);
					administratorId=userName.getText();
					System.out.println("Login page administrator: "+administratorId);
					new WelcomeActivity(administratorId);
				}
				else {
					System.out.println(p);
					textField.setText("wrong userName or passWord");
				}
					
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
		}		
	}
	public LoginActivity() {
//		BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("src/background.jpg")).getImage());
//		bgp.setBounds(0, 0, 600, 400);
//		add(bgp);
		setTitle("\u767B\u9646\u754C\u9762");
		getContentPane().setLayout(null);
		JPanel northPanel = new JPanel();
		northPanel.setBounds(0, 0, 600, 72);
		northPanel.setLayout(new GridLayout(2, 2));
		northPanel.add(userNameLabel);
		northPanel.add(userName);
		northPanel.add(passwdLabel);
		northPanel.add(passwd);
	//	getContentPane().add(northPanel);
		login.setBounds(202, 291, 198, 23);
		login.addActionListener(new MyLogin());
		getContentPane().add(login);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(0, 82, 314010600, 121);
	//	getContentPane().add(textField);
		textField.setColumns(10);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 580, 400);
		getContentPane().add(layeredPane);
		JPanel jp;		
		ImageIcon image = new ImageIcon("src/background.jpg");// 随便找一张图就可以看到效果。
		// 创建背景的那些东西
		jp = new JPanel();
		jp.setBounds(0, 0, 600, 400);
		JLabel jl = new JLabel(image);
		jl.setBounds(0,0,600,400);
		jp.add(jl);
		layeredPane.add(jp, JLayeredPane.DEFAULT_LAYER);
		this.setLayeredPane(layeredPane);
		layeredPane.add(northPanel, JLayeredPane.MODAL_LAYER);
		layeredPane.add(textField, JLayeredPane.MODAL_LAYER);
		layeredPane.add(login, JLayeredPane.MODAL_LAYER);
		
		
		
		
		run(this, 600, 400, "登陆界面");
	}
	public static void main(String[] agrs) {
		new LoginActivity();
	}
}
