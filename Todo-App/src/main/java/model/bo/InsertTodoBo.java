package model.bo;

import model.dao.InsertTodoDao;

public class InsertTodoBo {
	public boolean InsertBo(String title,String decription,String date,String username,String status) {
		InsertTodoDao insert = new InsertTodoDao();
		return insert.InsertTodo(title, decription, date, username, status);
	}
}
