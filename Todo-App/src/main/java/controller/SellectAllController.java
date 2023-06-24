package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.bean.Todo;
import model.bo.GetAllTodoApp;

/**
 * Servlet implementation class SellectAllController
 */
@WebServlet("/SellectAllController")
public class SellectAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellectAllController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Todo> todo = new ArrayList<>();
		HttpSession session = request.getSession();
		String username = (String)session.getValue("user");
		GetAllTodoApp selectall = new GetAllTodoApp();
		int  i = Integer.parseInt( request.getParameter("load")); 
		System.out.println("i:"+i);
		System.out.println("loooo");
		if(i==1) {
			System.out.println("loooo777");
		todo = selectall.GetAllToDo(username);
		request.setAttribute("list", todo);
//		RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath()+"/todo/todo-list.jsp");
//		rd.forward(request, response);
		RequestDispatcher dispatcher   = this.getServletContext().getRequestDispatcher("/todo/todo-list.jsp");
        dispatcher.forward(request, response);}
	}

}
