package sql;

import java.sql.*;

public class Select {
	public ResultSet rs;
	public Select(String category, String bookName, String bookPublisher, String bookAuthor, String startYear,
			String endYear, String minPrice, String maxPrice) throws SQLException {
		ConnectToLibrary connectToLibrary = new ConnectToLibrary();
		StringBuffer sql=new StringBuffer("select * from book where ");
		PreparedStatement statement = connectToLibrary.conn.prepareStatement("Select * from book where ????????");
		int IsOnly = 1;

		if (category.equals("") != true) {
			statement.setString(1, "bookCategory=" + category);
			sql.append("bookCategory='" + category+"'");
			IsOnly = 0;
		} 
		else {
			statement.setString(1, "1=1");
			sql.append("1=1");
		}

		if (bookName.equals("") != true) {
			if (IsOnly == 1) {
				statement.setString(2, " and bookName='" + bookName+"'");
				sql.append(" and bookName='" + bookName+"'");
				IsOnly = 0;
			} 
			else {
				statement.setString(2, " and bookName=" + bookName);
				sql.append(" and bookName='" + bookName+"'");
			}
		} 
		else{
			statement.setString(2, " and 1=1");
			sql.append(" and 1=1");
		}
		if(bookPublisher.equals("")!=true){
			if (IsOnly == 1) {
				statement.setString(3, " and bookPublisher=" + bookPublisher);
				sql.append(" and bookPublisher='" + bookPublisher+"'");
				IsOnly = 0;
			} 
			else {
				statement.setString(3, " and bookPublisher=" + bookPublisher);
				sql.append(" and bookPublisher='" + bookPublisher+"'");
			}
		} 
		else{
			statement.setString(3, " and 1=1");
			sql.append(" and 1=1");
		}
		if(bookAuthor.equals("")!=true){
			if (IsOnly == 1) {
				statement.setString(4, " and bookPublisher=" + bookPublisher);
				sql.append(" and bookAuthor='" + bookAuthor+"'");
				IsOnly = 0;
			} 
			else {
				statement.setString(4, " and bookPublisher=" + bookPublisher);
				sql.append(" and bookAuthor'" + bookAuthor+"'");
			}
		}
		else{
			statement.setString(4, " and 1=1");
			sql.append(" and 1=1");
		}
		if(startYear.equals("")!=true){
			if (IsOnly == 1) {
				statement.setString(5, " and bookYear>" + startYear);
				sql.append(" and bookYear>" + startYear);
				IsOnly = 0;
			} 
			else {
				statement.setString(5, " and bookYear>" + startYear);
				sql.append(" and bookYear>" + startYear);
			}
		}
		else{
			statement.setString(5, " and 1=1");
			sql.append(" and 1=1");
		}
		if(endYear.equals("")!=true){
			if (IsOnly == 1) {
				statement.setString(6, " and bookYear<" + endYear);
				sql.append(" and bookYear<" + endYear);
				IsOnly = 0;
			} 
			else {
				statement.setString(6, " and bookYear<" + endYear);
				sql.append(" and bookYear<" + endYear);
			}
		}
		else{
			statement.setString(6, " and 1=1");
			sql.append(" and 1=1");
		}
		if(minPrice.equals("")!=true){
			if (IsOnly == 1) {
				statement.setString(7, " and bookPrice>" + minPrice);
				sql.append(" and bookPrice>" + minPrice);
				IsOnly = 0;
			} 
			else {
				statement.setString(7, " and bookPrice>" + minPrice);
				sql.append(" and bookPrice>" + minPrice);
			}
		}
		else{
			statement.setString(7, " and 1=1");
			sql.append(" and 1=1");
		}
		if(maxPrice.equals("")!=true){
			if (IsOnly == 1) {
				statement.setString(8, " and bookPrice<" + maxPrice);
				sql.append(" and bookPrice<" + maxPrice);
				IsOnly = 0;
			} 
			else {
				statement.setString(8, " and bookPrice<" + maxPrice);
				sql.append(" and bookPrice<" + maxPrice);
			}
		}
		else{
			statement.setString(8, " and 1=1");
			sql.append(" and 1=1");
		}
		//rs=statement.executeQuery();
		
		Statement st=connectToLibrary.conn.createStatement();
		System.out.println("sql is "+sql.toString());
		System.out.println(st);
		rs=st.executeQuery(sql.toString());
		
	}
}
