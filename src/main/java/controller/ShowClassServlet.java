package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import model.CourseAccess;
import model.Category;
/**
 * Servlet implementation class ShowClassServlet
 */
@WebServlet("/ShowClassServlet")
public class ShowClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter pt=response.getWriter();
	  
	    CourseAccess ca=new CourseAccess();
	    RequestDispatcher rd = request.getRequestDispatcher("");
	    
	    try {
			List<Category> list = ca.showClass();
              System.out.println("scs:"+list);
			if (list.size() > 0) {
				request.setAttribute("categorylist", list);
				rd = request.getRequestDispatcher("admin/addcourse.jsp");
				
				rd.forward(request, response);
			} else {
				request.setAttribute("noCourse","No course");
				response.sendRedirect("display.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
