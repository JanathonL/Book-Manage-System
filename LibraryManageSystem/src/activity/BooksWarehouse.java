package activity;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

import sql.Insert;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;

import static activity.SwingConsole.*;

public class BooksWarehouse extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_bookNumber;
	private JTextField textField_bookCategory;
	private JTextField textField_bookName;
	private JTextField textField_bookPulisher;
	private JTextField textField_bookYear;
	private JTextField textField_bookPrice;
	private JTextField textField_bookCount;
	private JTextArea textField_15;
	private JTextField textField_Author;
	private JTextField textField_9;
	static String administratorId;
	class MyInsert implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().equals("InsertOne")){
				String a1=textField_bookNumber.getText();
				if(a1.equals("")){
					textField_15.setText("书号不能为空");
					return;
				}
				String a2=textField_bookCategory.getText();
				if(a2.equals("")){
					textField_15.setText("类别不能为空");
					return;
				}
				String a3=textField_bookName.getText();
				if(a3.equals("")){
					textField_15.setText("书名不能为空");
					return;
				}
				String a4=textField_bookPulisher.getText();
				if(a4.equals("")){
					textField_15.setText("出版社不能为空");
					return;
				}
				int a5;
				double a7;
				int a8;
				try{
					   a5=Integer.parseInt(textField_bookYear.getText());
				}
				catch (Exception e1){
					textField_15.setText("出版年份不能为空");
					return;
				}
				String a6=textField_Author.getText();
				if(a6.equals("")){
					textField_15.setText("作者不能为空");
					return;
				}
				try{
				       a7=Double.parseDouble(textField_bookPrice.getText());
				}
				catch (Exception e1){
					textField_15.setText("价格不能为空");
					return;
				}
				try{
					a8=Integer.parseInt(textField_bookCount.getText());
				}
				catch (Exception e1){
					textField_15.setText("数量不能为空\n");
					return;
				}
				int    a9=a8;
				try {
					new Insert(a1,a2,a3,a4,a5,a6,a7,a8,a9);
					textField_15.setText("插入成功！\n");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(e.getActionCommand().equals("InsertAll")){
				JFileChooser file = new JFileChooser(); // 查找文件
				file.showOpenDialog(null);
				File f=file.getSelectedFile();
				Scanner in=null;
				try {
					in = new Scanner(f);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				while (in.hasNextLine()) {
	                String sql = in.nextLine();
	                try {
						new Insert(sql);
						textField_15.append("执行 "+sql+" 成功！\n");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						textField_15.append("执行 "+sql+" 失败！！\n");
						e1.printStackTrace();
					}
	            }
	
			}
			
		}
		
	}
	public BooksWarehouse(String administratorId) {
		try { // 使用Windows的界面风格
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.administratorId=administratorId;
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
		setTitle("\u56FE\u4E66\u4ED3\u5E93");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 30, 518, 58);
	//	getContentPane().add(panel);
		panel.setLayout(new GridLayout(2,7));
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setText("\u4E66\u53F7");
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setText("\u7C7B\u522B");
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setText("\u4E66\u540D");
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setText("\u51FA\u7248\u793E");
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setText("\u5E74\u4EFD");
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setText("\u4F5C\u8005");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		panel.add(textField_9);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setText("\u4EF7\u683C");
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setEditable(false);
		textField_7.setText("\u6570\u91CF");
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		textField_bookNumber = new JTextField();
		textField_bookNumber.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_bookNumber);
		textField_bookNumber.setColumns(10);
		
		textField_bookCategory = new JTextField();
		textField_bookCategory.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_bookCategory);
		textField_bookCategory.setColumns(10);
		
		textField_bookName = new JTextField();
		textField_bookName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_bookName);
		textField_bookName.setColumns(10);
		
		textField_bookPulisher = new JTextField();
		textField_bookPulisher.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_bookPulisher);
		textField_bookPulisher.setColumns(10);
		
		textField_bookYear = new JTextField();
		textField_bookYear.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_bookYear);
		textField_bookYear.setColumns(10);
		
		textField_Author = new JTextField();
		textField_Author.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_Author);
		textField_Author.setColumns(10);
		
		textField_bookPrice = new JTextField();
		textField_bookPrice.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_bookPrice);
		textField_bookPrice.setColumns(10);
		
		textField_bookCount = new JTextField();
		textField_bookCount.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_bookCount);
		textField_bookCount.setColumns(10);
		
		JButton InsertOne = new JButton("\u5355\u672C\u5165\u5E93");
		InsertOne.setActionCommand("InsertOne");
		InsertOne.addActionListener(new MyInsert());
		InsertOne.setBounds(140, 315, 93, 23);
	//	getContentPane().add(InsertOne);
		
		JButton InsertAll = new JButton("\u6279\u91CF\u5165\u5E93");
		InsertAll.setBounds(342, 315, 93, 23);
		InsertAll.setActionCommand("InsertAll");
		InsertAll.addActionListener(new MyInsert());
	//	getContentPane().add(InsertAll);
		
		textField_15 = new JTextArea();
		textField_15.setEditable(false);
		textField_15.setBounds(29, 108, 518, 200);
	//	getContentPane().add(textField_15);
		textField_15.setColumns(10);
		
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 108, 518, 200);
		// getContentPane().add(scrollPane);

		//textField_15 = new JTextArea();
		scrollPane.setViewportView(textField_15);
		
		layeredPane.add(jp, JLayeredPane.DEFAULT_LAYER);
		this.setLayeredPane(layeredPane);
		layeredPane.add(panel, JLayeredPane.MODAL_LAYER);
		layeredPane.add(menuBar, JLayeredPane.MODAL_LAYER);
		layeredPane.add(InsertOne, JLayeredPane.MODAL_LAYER);
		layeredPane.add(InsertAll, JLayeredPane.MODAL_LAYER);
		layeredPane.add(scrollPane, JLayeredPane.MODAL_LAYER);
		run(this,600,400,"图书仓库");
	}
	public static void main(String[] args){
		new BooksWarehouse(administratorId);
		
	}
}
