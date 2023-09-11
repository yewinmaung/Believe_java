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

/**
 * Servlet implementation class LecturServlet
 */
@WebServlet("/LecturServlet")
public class LecturServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseAccess ca = new CourseAccess();
		RequestDispatcher rd = request.getRequestDispatcher("");
		
		
		 
		try {
			List<Course> list = ca.showCourse();
         
			if (list.size() > 0) {
				request.setAttribute("courselist", list);
				//request.setAttribute("catlist", catlist);
				rd = request.getRequestDispatcher("user/video.jsp");
				rd.forward(request, response);
			} else {
				response.setContentType("text/html");
				rd=request.getRequestDispatcher("user/video.jsp");
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
