package model.bo;

import java.util.ArrayList;

import model.bean.Todo;
import model.dao.GetAllTodoDao;

public class GetAllTodoApp {
	public ArrayList<Todo> GetAllToDo(String username){
		GetAllTodoDao todo = new GetAllTodoDao();
		return todo.GetAllTodo(username);
	}
}
