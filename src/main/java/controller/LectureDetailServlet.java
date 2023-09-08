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

import model.Category;
import model.Course;
import model.CourseAccess;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/LectureDetail")
public class LectureDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LectureDetailServlet() {
        super();
        // TODO Auto-generated constaructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Course course=new Course();
		CourseAccess ca = new CourseAccess();
		String courseId = request.getParameter("courseid");
		 course = ca.courseData(courseId);
		
		System.out.println("LDServlet :"+course.getName());
		try {
			List<Course> list = ca.showCourse();
			
		
				    response.setContentType("text/html");
					request.setAttribute("course", course);
					request.setAttribute("courselist", list);
					//response.sendRedirect("LecturServlet");
					RequestDispatcher rd = request.getRequestDispatcher("user/video.jsp");
					rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
