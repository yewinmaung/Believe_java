package controller;

import java.io.IOException;
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
 * Servlet implementation class CategoryListServlet
 */
@WebServlet("/CategoryListServlet")
public class CategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseAccess ca = new CourseAccess();
		RequestDispatcher rd = request.getRequestDispatcher("");
		System.out.println("CourseListServlet Aung");
		
		 
		try {
			List<Category> list = ca.showClass();
         
			if (list.size() > 0) {
				request.setAttribute("catlist", list);
				//request.setAttribute("catlist", catlist);
				rd = request.getRequestDispatcher("admin/categorylist.jsp");
				rd.forward(request, response);
			} else {
				response.setContentType("text/html");
				rd=request.getRequestDispatcher("admin/categorylist.jsp");
				request.setAttribute("noCourse","error");
				rd.include(request, response);
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
