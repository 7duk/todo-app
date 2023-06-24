package controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.bean.Todo;
import model.bo.SelectTodoBo;
import model.bo.UpdateTodoBo;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditController() {
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
		// TODO Auto-generated method stub
		String edit = request.getParameter("edit");
		System.out.println("edit:" + edit);

		if (edit == null) {
			String id = request.getParameter("id");
			System.out.println("id:" + id);
			Todo todo = new Todo();
			SelectTodoBo select = new SelectTodoBo();
			todo = select.SelectBo(id);
			request.setAttribute("list", todo);
			System.out.println("EditController");
			RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form-edit.jsp");
			dispatcher.forward(request, response);
		}
		else if (edit.equals("1")) {
			String id = request.getParameter("id");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String status = request.getParameter("isDone");
			String date = request.getParameter("targetDate");
			UpdateTodoBo update = new UpdateTodoBo();
			System.out.println("update o day");
			if (update.UpdateBo(title, description, date, id, status)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/todo/todo-list.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println("Loi update");
			}
		}
	}

}
