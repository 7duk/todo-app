package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.jdbc.Connection;

public class InsertTodoDao {
	public boolean InsertTodo(String title, String decription, String date, String username, String status) {
		String query = "INSERT INTO todos" + " VALUES " + " (null,?,?, ?, ?, ?);";

		int result = 0;
		try (Connection connection = (Connection) JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, decription);
			preparedStatement.setBoolean(2, Boolean.parseBoolean(status));
			preparedStatement.setDate(3, JDBCUtils.getSQLDate(LocalDate.parse(date)));
			preparedStatement.setString(4, username);
			preparedStatement.setString(5, title);

			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
			if (result >= 0)
				return true;

		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return false;
	}
}
