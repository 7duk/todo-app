package model.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DeleleTodoDao {
	public boolean DeleleTodo(String id) {
		String query = "Delete from todos where id = " +Integer.parseInt(id);
		try {
			Connection con = (Connection)JDBCUtils.getConnection();
			Statement stmt = (Statement) con.createStatement();
			int result = stmt.executeUpdate(query);
			if(result>= 0) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
}
