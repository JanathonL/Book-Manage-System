package activity;

import javax.swing.JFrame;
import static activity.SwingConsole.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

import sql.Borrow;
import sql.ShowResult;
import sql.bookBorrow;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class ReturnActivity extends JFrame {
	private JTextField textField_cardNumber;
	private JTextField textField_bookNumber;
	JTextArea txtrResult_1;
	JTextArea textArea;
	static String administratorId;
	class MyReturnOk implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("cardConfirm")){
				Borrow borrow=new Borrow(textField_cardNumber.getText());
				try {
					if(borrow.Isok()==true){
						new ShowResult(txtrResult_1, textField_cardNumber.getText());
					}
					else{
						txtrResult_1.setText("借阅证号错误");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("not ok!");
				//	txtrResult_1.setText("借阅证号错误");
					e1.printStackTrace();
				}			
			}
			else if(e.getActionCommand().equals("bookConfirm")){
				String bookNumber=textField_bookNumber.getText();
				String cardNumber=textField_cardNumber.getText();
				bookBorrow bookborrow=new bookBorrow(textArea, bookNumber, cardNumber, administratorId);
				try {
					if(bookborrow.Isok()==true){
						bookborrow.returnTheBook(textArea);
					}
					else{
						textArea.setText("找不到书号");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("bookReturnIsok failed");
					e1.printStackTrace();
				}
			}
		}
		
	}
	public ReturnActivity(String administratorId) {	
		this.administratorId=administratorId;
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(66, 30, 447, 34);
	//	getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel label = new JLabel("\u501F\u9605\u8BC1\u53F7");
		panel.add(label);
		
		textField_cardNumber = new JTextField();
		panel.add(textField_cardNumber);
		textField_cardNumber.setColumns(10);
		
		JButton btnOk = new JButton("ok");		
		btnOk.setActionCommand("cardConfirm");
		btnOk.addActionListener(new MyReturnOk());
		panel.add(btnOk);
		
		JLabel label_1 = new JLabel("\u5DF2\u501F\u4E66\u7C4D");
		label_1.setBounds(66, 73, 54, 15);
	//	getContentPane().add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(66, 203, 447, 34);
	//	getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel label_2 = new JLabel("\u8F93\u5165\u4E66\u53F7");
		panel_1.add(label_2);
		
		textField_bookNumber = new JTextField();
		panel_1.add(textField_bookNumber);
		textField_bookNumber.setColumns(10);
		
		JButton btnOk_1 = new JButton("ok");
		btnOk_1.setActionCommand("bookConfirm");
		btnOk_1.addActionListener(new MyReturnOk());
		panel_1.add(btnOk_1);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("result");
		textArea.setBounds(66, 247, 447, 107);
	//	getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 98, 447, 95);
	//	getContentPane().add(scrollPane);
		
		txtrResult_1 = new JTextArea();
		scrollPane.setViewportView(txtrResult_1);
		txtrResult_1.setEditable(false);
		txtrResult_1.setText("result");
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 10, 580, 400);
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
//		layeredPane.add(menuBar, JLayeredPane.MODAL_LAYER);
		layeredPane.add(panel_1, JLayeredPane.MODAL_LAYER);
		layeredPane.add(textArea, JLayeredPane.MODAL_LAYER);
		layeredPane.add(scrollPane, JLayeredPane.MODAL_LAYER);
		layeredPane.add(label_1, JLayeredPane.MODAL_LAYER);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 584, 21);
		layeredPane.add(menuBar,JLayeredPane.MODAL_LAYER);
		
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
	//	menuBar.setBounds(0, 0, 584, 21);
	//	layeredPane.add(menuBar,JLayeredPane.MODAL_LAYER);
		
		
		run(this,600,400,"还书界面");
	}
	
}
