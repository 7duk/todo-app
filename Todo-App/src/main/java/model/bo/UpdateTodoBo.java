package model.bo;

import model.dao.EditTodoDao;

public class UpdateTodoBo {
	public boolean UpdateBo(String title, String decription, String date, String id, String status) {
		EditTodoDao edit = new EditTodoDao();
		return edit.UpdateTodo(title, decription, date, id, status);
	}

}
