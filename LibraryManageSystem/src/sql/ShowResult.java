package sql;

import java.sql.*;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import activity.Fill;

public class ShowResult {
	public static void show(JTextArea t, ResultSet rs) throws SQLException {
		while (rs.next()) {
			String rsBookNumber = rs.getString(1);
			String rsBookCategory = rs.getString(2);
			String rsBookName = rs.getString(3);
			String rsBookPublisher = rs.getString(4);
			String rsBookYear = rs.getString(5);
			String rsBookAuthor = rs.getString(6);
			String rsBookPrice = rs.getString(7);
			String rsBookStorage = rs.getString(9);
			t.append(rsBookNumber + ",        " + rsBookCategory + ",        " + rsBookName
					+ ",        " + rsBookPublisher + ",        " + rsBookYear + ",        " + rsBookAuthor
					+ ",        " + rsBookPrice  + "\n");
		}
	}

	public ShowResult(JTextArea t, String cardNumber) throws SQLException {
		t.setText("结果是\n");
		t.append("书号"+",        " +
				"类别"+",        " +
				"书名"+",        "+
				"出版社"+",        "+
				"出版年份"+",        "+
				"作者"+",        "+
				"价格"+",        "+"\n");
		ConnectToLibrary connectToLibrary = new ConnectToLibrary();
		PreparedStatement statement = connectToLibrary.conn
				.prepareStatement("Select bookNumber from borrowRecord where cardNumber=? and returnDay is null");
		statement.setString(1, cardNumber);
		ResultSet rs = statement.executeQuery();
		PreparedStatement st = connectToLibrary.conn.prepareStatement("Select * from book where bookNumber=? ");
		while (rs.next()) {
			String bookNumber = rs.getString(1);
			st.setString(1, bookNumber);
			ResultSet rs2 = st.executeQuery();
			show(t, rs2);
		}

	}

}
