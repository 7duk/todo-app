package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.bo.InsertTodoBo;
import java.io.IOException;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String status = request.getParameter("isDone");
		String date = request.getParameter("targetDate");
		String name = (String) session.getAttribute("user");
		InsertTodoBo insert = new InsertTodoBo();
		if(insert.InsertBo(title, description, date, name, status)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/todo/todo-list.jsp");
			dispatcher.forward(request, response);
		}
		else {
			System.out.println("Loi insert");
		}
	}

}
