package model.bo;

import model.dao.DeleleTodoDao;

public class DeleteTodoBo {
	public boolean DeleleBo(String id) {
		DeleleTodoDao delete = new  DeleleTodoDao();
		return delete.DeleleTodo(id);
	}

}
