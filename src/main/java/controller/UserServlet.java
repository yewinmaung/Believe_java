package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.UserAccess;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserAccess ua=new UserAccess();
		PrintWriter out=response.getWriter();
		boolean isVilid=ua.isVilid(email);
		
		if(isVilid) {
			
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("user/register.jsp");
			// out.println(" <div class=\"alert alert-danger \">Your Account is Invlid!</div>");
			request.setAttribute("loginError", "error");
			rd.include(request, response);
			}
		else {
			boolean flag=ua.regUser(name, password, email);
			if(flag) {
				RequestDispatcher rd=request.getRequestDispatcher("user/index.jsp");
				rd.forward(request, response);	
			}
		 }
		
	}

}
