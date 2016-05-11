package sql;

import java.sql.*;

public class Insert {
	public Insert(String bookNumber, String bookCategory, String bookName, String bookPublisher, int bookYear,
			String bookAuthor, double bookPrice, int total, int storage) throws SQLException {
		ConnectToLibrary connectToLibrary = new ConnectToLibrary();
		PreparedStatement statement = connectToLibrary.conn
				.prepareStatement("insert into book values(?,?,?,?,?,?,?,?,?)");
		statement.setString(1, bookNumber);
		statement.setString(2, bookCategory);
		statement.setString(3, bookName);
		statement.setString(4, bookPublisher);
		statement.setInt(5, bookYear);
		statement.setString(6, bookAuthor);
		statement.setDouble(7, bookPrice);
		statement.setInt(8, total);
		statement.setInt(9, storage);
		statement.executeUpdate();
		connectToLibrary.conn.close();
		statement.close();
	}
	public Insert(String sql) throws SQLException{
		ConnectToLibrary connectToLibrary = new ConnectToLibrary();
		Statement statement=connectToLibrary.conn.createStatement();
		statement.executeUpdate(sql);
		connectToLibrary.conn.close();
		statement.close();
	}
}
