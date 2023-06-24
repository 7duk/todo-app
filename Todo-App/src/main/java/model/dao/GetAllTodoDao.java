package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.bean.Todo;

public class GetAllTodoDao {
	public ArrayList<Todo> GetAllTodo(String username){
		ArrayList<Todo> list = new ArrayList<Todo>();
		try {
			String query = "Select * from todos where username = '"+username+"'";
			System.out.println(query);
			Connection con = (Connection) JDBCUtils.getConnection();
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Todo todo = new Todo(rs.getLong(1),rs.getString(6),rs.getString(5),rs.getString(2),rs.getDate(4).toLocalDate(),rs.getBoolean(3));
				list.add(todo);
				System.out.println(rs.getLong(1));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDate(4).toLocalDate());
				System.out.println(rs.getBoolean(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
