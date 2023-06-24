package controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import model.bean.LoginBean;
import model.bo.LoginBo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("./login/login.jsp");}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBo loginbo = new LoginBo();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
			try {
				if (loginbo.isValidAccount(loginBean)) {
					
					HttpSession session =  request.getSession();
					System.out.println("session: "+ username);
					session.putValue("user", username);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/todo/todo-list.jsp");
					dispatcher.forward(request, response);
					
				}
				else {
//					response.sendRedirect("../login/login.jsp");
					System.out.println("11111");
					request.setAttribute("error", "Username or password incorrect");
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login/login.jsp");
					dispatcher.forward(request, response);
				}
			} catch (Exception e) {
				System.out.println("looooi");
				e.printStackTrace();
				
			}
	}

}
