package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserAccess;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserAccess ua = new UserAccess();
		PrintWriter out = response.getWriter();
		User user = ua.loginUser(email, password);
		boolean isValid = ua.isValid(email, password);
		int type = 0;

		HttpSession session = request.getSession(true);

		if (isValid) {
		
          System.out.println(user);
			if (user.getType() == 0) {
				
				session.setAttribute("user", user);
				RequestDispatcher rd = request.getRequestDispatcher("user/index.jsp");
				rd.forward(request, response);
			} else if (user.getType() == 1) {
				session.setAttribute("admin", user);
				
				RequestDispatcher rd = request.getRequestDispatcher("admin/dashboard.jsp");
				rd.forward(request, response);

			} 

		}

		else {

			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("user/login.jsp");
			request.setAttribute("userError", "error");
			rd=request.getRequestDispatcher("admin/alogin.jsp");
			request.setAttribute("adminError","error");
			rd.include(request, response);
		}

	}

}
