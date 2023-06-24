package model.bo;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.bean.Todo;
import model.dao.JDBCUtils;
import model.dao.SelectTodoDao;

public class SelectTodoBo {
	public Todo SelectBo(String id) {
		SelectTodoDao select = new SelectTodoDao();
		return select.SelectTodo(id);
	}
}
