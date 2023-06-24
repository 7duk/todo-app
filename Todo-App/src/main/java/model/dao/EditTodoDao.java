package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.jdbc.Connection;

public class EditTodoDao {
	public boolean UpdateTodo(String title, String decription, String date, String id, String status) {

		String query = "Update todos set description = ?,is_done =?,target_date=?,title = ? where id = ?";

		int result = 0;
		try (Connection connection = (Connection) JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, decription);
			preparedStatement.setBoolean(2, Boolean.parseBoolean(status));
			preparedStatement.setDate(3, JDBCUtils.getSQLDate(LocalDate.parse(date)));
			preparedStatement.setString(4, title);
			preparedStatement.setString(5, id);

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
