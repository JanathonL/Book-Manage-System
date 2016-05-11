package activity;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

import sql.CardManage;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import static activity.SwingConsole.*;

public class CardManageActivity extends JFrame {
	private JTextField textField_cardNumber;
	static String administratorId;
	private JTextField txtResult;
	JButton button, button_1;
	JTextField textField_userName = new JTextField(), textField_userDepartment = new JTextField(),
			textField_userCategory = new JTextField();
	String userName, userDepartment, userCategory,cardNumber;
	private MyDialog dlg = new MyDialog(null);

	public class MyCardManageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getActionCommand());
			cardNumber=textField_cardNumber.getText();
			if (e.getActionCommand().equals("add")) {
				dlg.setVisible(true);
				System.out.println("CardManageActivity add");
				CardManage cardManage=new CardManage(cardNumber, userName, userDepartment, userCategory);
				try {
					cardManage.addCard(txtResult);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					txtResult.setText("添加借书证失败");
					e1.printStackTrace();
				}
			}
			else if(e.getActionCommand().equals("delete")){
				CardManage cardManage=new CardManage(cardNumber, userName, userDepartment, userCategory);
				try {
					cardManage.deleteCard(txtResult);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					txtResult.setText("删除借书证失败");
					e1.printStackTrace();
				}
			}

		}

	}

	public CardManageActivity(String administratorId) {
		this.administratorId = administratorId;
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(95, 59, 391, 43);
	//	getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel label = new JLabel("\u501F\u9605\u8BC1\u53F7");
		panel.add(label);

		textField_cardNumber = new JTextField();
		panel.add(textField_cardNumber);
		textField_cardNumber.setColumns(10);

		button = new JButton("\u6DFB\u52A0");
		button.setBounds(139, 301, 93, 23);
		button.setActionCommand("add");
		button.addActionListener(new MyCardManageListener());
		// button.addMouseListener(new MyaddListener());
//		getContentPane().add(button);

		button_1 = new JButton("\u5220\u9664");
		button_1.setBounds(337, 301, 93, 23);
		button_1.setActionCommand("delete");
		button_1.addActionListener(new MyCardManageListener());
		// button_1.addMouseListener(new MyaddListener());
//		getContentPane().add(button_1);

		txtResult = new JTextField();
		txtResult.setText("result");
		txtResult.setBounds(95, 137, 391, 135);
//		getContentPane().add(txtResult);
		txtResult.setColumns(10);
		
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
		layeredPane.add(panel, JLayeredPane.MODAL_LAYER);
		layeredPane.add(button, JLayeredPane.MODAL_LAYER);
		layeredPane.add(button_1, JLayeredPane.MODAL_LAYER);
		layeredPane.add(txtResult, JLayeredPane.MODAL_LAYER);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 584, 21);
		layeredPane.add(menuBar, JLayeredPane.MODAL_LAYER);
		
				JMenu menu = new JMenu("入库");
				menu.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
						new BooksWarehouse(administratorId);
					}
				});
				menuBar.add(menu);
				
						JMenu menu_1 = new JMenu("查询");
						menu_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								setVisible(false);
								new SearchActivity(administratorId);
							}
						});
						menuBar.add(menu_1);
						
								JMenu menu_2 = new JMenu("借书");
								menu_2.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										setVisible(false);
										new BorrowActivity(administratorId);
									}
								});
								menuBar.add(menu_2);
								
										JMenu menu_3 = new JMenu("还书");
										menu_3.addMouseListener(new MouseAdapter() {
											@Override
											public void mouseClicked(MouseEvent e) {
												setVisible(false);
												new ReturnActivity(administratorId);
											}
										});
										menuBar.add(menu_3);
										
												JMenu menu_4 = new JMenu("借阅证管理");
												menu_4.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent e) {
														setVisible(false);
														new CardManageActivity(administratorId);
													}
												});
												menuBar.add(menu_4);
		
		run(this, 600, 400, "借阅证管理");
	}

	public static void main(String[] agrs) {
		new CardManageActivity(administratorId);
	}

	class MyDialog extends JDialog {

		public MyDialog(JFrame parent) {
			super(parent, "My dialog", true);
			JPanel jp=new JPanel();
			jp.setLayout(new GridLayout(3, 2));

			jp.add(new JLabel("用户姓名"));
			jp.add(textField_userName);
			jp.add(new JLabel("用户所属部门"));
			jp.add(textField_userDepartment);
			jp.add(new JLabel("用户类别（老师或学生）"));
			jp.add(textField_userCategory);
			add("Center",jp);
			JButton ok = new JButton("OK");
			ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					userName = textField_userName.getText();
					userDepartment = textField_userDepartment.getText();
					userCategory = textField_userCategory.getText();
					dispose(); // Closes the dialog
				}
			});
			add("South",ok);
			setSize(400, 200);
		}
	}
}
