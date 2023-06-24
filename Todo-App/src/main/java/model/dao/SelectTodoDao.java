package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.bean.Todo;

public class SelectTodoDao {
	public Todo SelectTodo(String id){
		Todo todo = new Todo();
		try {
			String query = "Select * from todos where id = '"+id+"'";
			System.out.println(query);
			Connection con = (Connection) JDBCUtils.getConnection();
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				todo.setId(rs.getLong(1));
				todo.setTitle(rs.getString(6));
				todo.setUsername(rs.getString(5));
				todo.setTargetDate(rs.getDate(4).toLocalDate());
				todo.setDescription(rs.getString(2));
				todo.setStatus(rs.getBoolean(3));
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
		return todo;
	}

}