package activity;

import javax.swing.*;
import static activity.SwingConsole.*;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.border.LineBorder;

import sql.Select;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.ComponentOrientation;

public class SearchActivity extends JFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField txtCategory;
	private JTextField textbookName;
	private JTextField textbookAuthor;
	private JTextField textbookPublisher;
	private JLabel label_2;
	private JLabel label_3;
	private JPanel panel_2;
	private JLabel label_4;
	private JTextField textField_startYear;
	private JLabel label_5;
	private JTextField textField_endYear;
	private JPanel panel_3;
	private JLabel label_6;
	private JTextField textField_minPrice;
	private JLabel label_7;
	private JTextField textField_maxPrice;
	private JButton button;
	private JTextArea textResults;
	private JTextField textField;
	static String administratorId;

	public SearchActivity(String administratorId) {
		this.administratorId = administratorId;
		class MySearch implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				textResults.setText("");
				// TODO Auto-generated method stub
				Select select = null;
				String a1 = txtCategory.getText();
				String a2 = textbookName.getText();
				String a3 = textbookPublisher.getText();
				String a4 = textbookAuthor.getText();
				String a5 = textField_startYear.getText();
				String a6 = textField_endYear.getText();
				String a7 = textField_minPrice.getText();
				String a8 = textField_maxPrice.getText();
				try {
					select = new Select(a1, a2, a3, a4, a5, a6, a7, a8);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					while (select.rs.next()) {
						String rsBookNumber = select.rs.getString(1);
						String rsBookCategory = select.rs.getString(2);
						String rsBookName = select.rs.getString(3);
						String rsBookPublisher = select.rs.getString(4);
						String rsBookYear = select.rs.getString(5);
						String rsBookAuthor = select.rs.getString(6);
						String rsBookPrice = select.rs.getString(7);
						String rsBookStorage = select.rs.getString(9);
						textResults.append(rsBookNumber + ",        " + rsBookCategory + ",        " + rsBookName
								+ ",        " + rsBookPublisher + ",        " + rsBookYear + ",        " + rsBookAuthor
								+ ",        " + rsBookPrice + ",        " + rsBookStorage + "\n");
						// textResults.append(String.format("%-16s",
						// rsBookNumber) + String.format("%-16s",
						// rsBookCategory) +String.format("%-16s", rsBookName)
						// + String.format("%-16s", rsBookPublisher )+
						// String.format("%-16s", rsBookYear) +
						// String.format("%-16s", rsBookAuthor)
						// +String.format("%-16s", rsBookPrice) +
						// String.format("%-16s", rsBookStorage) + "\n");
						// textResults.append(Fill.stringFill(rsBookNumber, 12,
						// ' ', false)
						// + Fill.stringFill(rsBookCategory, 12, ' ', true)
						// + Fill.stringFill(rsBookName, 20, ' ', true)
						// + Fill.stringFill(rsBookPublisher, 12, ' ', true)
						// + Fill.stringFill(rsBookYear, 12, ' ', true)
						// + Fill.stringFill(rsBookAuthor, 12, ' ', true)
						// + Fill.stringFill(rsBookPrice, 12, ' ', true)
						// + Fill.stringFill(rsBookStorage, 12, ' ', true) +
						// "\n");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(21, 30, 553, 42);
		// getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 8));

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

		textField = new JTextField();
		textField.setText("\u4F5C\u8005");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setColumns(10);
		panel.add(textField);

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

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(95, 198, 141, 93);
		// getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(4, 2));

		JLabel label = new JLabel("\u7C7B\u522B");
		label.setOpaque(true);
		label.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		txtCategory = new JTextField();
		panel_1.add(txtCategory);
		txtCategory.setToolTipText("category");
		txtCategory.setColumns(10);

		JLabel label_1 = new JLabel("\u4E66\u540D");
		label_1.setOpaque(true);
		label_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_1);

		textbookName = new JTextField();
		panel_1.add(textbookName);
		textbookName.setToolTipText("category");
		textbookName.setColumns(10);

		label_2 = new JLabel("\u51FA\u7248\u793E");
		label_2.setOpaque(true);
		label_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_2);

		textbookPublisher = new JTextField();
		textbookPublisher.setToolTipText("category");
		textbookPublisher.setColumns(10);
		panel_1.add(textbookPublisher);

		label_3 = new JLabel("\u4F5C\u8005");
		label_3.setOpaque(true);
		label_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_3);

		textbookAuthor = new JTextField();
		textbookAuthor.setToolTipText("category");
		textbookAuthor.setColumns(10);
		panel_1.add(textbookAuthor);

		panel_2 = new JPanel();
		panel_2.setBounds(310, 198, 164, 31);
		// getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		textField_startYear = new JTextField();
		textField_startYear.setText("0");
		textField_startYear.setPreferredSize(new Dimension(4, 21));
		panel_2.add(textField_startYear);
		textField_startYear.setColumns(6);

		label_5 = new JLabel("-");
		panel_2.add(label_5);

		textField_endYear = new JTextField();
		panel_2.add(textField_endYear);
		textField_endYear.setColumns(6);

		panel_3 = new JPanel();
		panel_3.setBounds(310, 239, 164, 31);
		// getContentPane().add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		textField_minPrice = new JTextField();
		textField_minPrice.setColumns(6);
		panel_3.add(textField_minPrice);

		label_7 = new JLabel("-");
		panel_3.add(label_7);

		textField_maxPrice = new JTextField();
		textField_maxPrice.setColumns(6);
		panel_3.add(textField_maxPrice);

		button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new MySearch());
		button.setBounds(226, 315, 93, 23);
		// getContentPane().add(button);

		label_4 = new JLabel("\u5E74\u4EFD");
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(246, 198, 55, 31);
		// getContentPane().add(label_4);
		label_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		label_6 = new JLabel("\u4EF7\u683C");
		label_6.setOpaque(true);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(246, 239, 54, 31);
		// getContentPane().add(label_6);
		label_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 82, 553, 106);
		// getContentPane().add(scrollPane);

		textResults = new JTextArea();
		scrollPane.setViewportView(textResults);
		textResults.setText("result is\n");
		textResults.setLineWrap(true);
		textResults.setEditable(false);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 10, 580, 400);
		// getContentPane().add(layeredPane);
		JPanel jp;
		ImageIcon image = new ImageIcon("src/background.jpg");// 随便找一张图就可以看到效果。
		// 创建背景的那些东西
		jp = new JPanel();
		jp.setBounds(0, 0, 600, 400);
		JLabel jl = new JLabel(image);
		jl.setBounds(0, 0, 600, 400);
		jp.add(jl);
		layeredPane.add(jp, JLayeredPane.DEFAULT_LAYER);
		this.setLayeredPane(layeredPane);
		layeredPane.add(panel, JLayeredPane.MODAL_LAYER);
		layeredPane.add(panel_1, JLayeredPane.MODAL_LAYER);
		layeredPane.add(panel_2, JLayeredPane.MODAL_LAYER);
		layeredPane.add(panel_3, JLayeredPane.MODAL_LAYER);
		layeredPane.add(button, JLayeredPane.MODAL_LAYER);
		// layeredPane.add(menuBar, JLayeredPane.MODAL_LAYER);
		layeredPane.add(label_4, JLayeredPane.MODAL_LAYER);
		layeredPane.add(label_6, JLayeredPane.MODAL_LAYER);
		layeredPane.add(scrollPane, JLayeredPane.MODAL_LAYER);

		// Point pt=new Point();
		// pt.x=getX();
		// pt.y=getY();
		// SwingUtilities.convertPointToScreen(pt, this.getContentPane());

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 584, 21);
		layeredPane.add(menuBar, JLayeredPane.MODAL_LAYER);

		JMenu menu = new JMenu("入库");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new BooksWarehouse(administratorId);
				// bw.setLocation(pt.x, pt.y);
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

		run(this, 600, 400, "查询界面");
	}

	public static void main(String[] args) {

		SearchActivity sa = new SearchActivity(administratorId);

	}
}
