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
import model.EnrollAccess;
import model.User;
import model.Category;
import model.Course;
import model.CourseAccess;
import model.Enroll;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnrollServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
//		int class_id = Integer.parseInt(request.getParameter("class_id"));
//		//int user_id = Integer.parseInt(request.getParameter("userid"));
//
//		response.setContentType("text/html");
//		request.setAttribute("classid", class_id);
//		RequestDispatcher rd = request.getRequestDispatcher("user/enroll.jsp");
//		rd.include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CourseAccess ca = new CourseAccess();
		RequestDispatcher rd = request.getRequestDispatcher("");

		int class_id = Integer.parseInt(request.getParameter("classid"));
		int user_id = Integer.parseInt(request.getParameter("userid"));
		System.out.println("Classid" + class_id);
		System.out.println("UserId" + user_id);
		EnrollAccess ea = new EnrollAccess();
		
		
		
		
		boolean enstu = ea.getenrollStu(user_id, class_id);
		
		if (enstu) {
			
			List<Course> list = ca.detailLecture(class_id);
			Category catlist=ca.showdetailClass(class_id);
			System.out.println(catlist.getTitle());
			//System.out.println("Enroll Servlet" + catlist.get(class_id));
			if (list.size() > 0) {
				request.setAttribute("categorylist", catlist);
				request.setAttribute("courselist", list);
				// request.setAttribute("catlist", catlist);
				rd = request.getRequestDispatcher("user/video.jsp");
				rd.forward(request, response);
			} else {
				response.setContentType("text/html");
				System.out.println("error video");
				rd = request.getRequestDispatcher("user/video.jsp");
				request.setAttribute("noCourse", "error");
				rd.include(request, response);
			}
		} else {
			response.setContentType("text/html");
			request.setAttribute("classid", class_id);
			rd = request.getRequestDispatcher("user/enroll.jsp");
			// out.println(" <div class=\"alert alert-danger \">Your Account is
			// Invlid!</div>");

			rd.include(request, response);
		}

//		Enroll stu=ea.enrollStu(user_id,class_id);
//		
//		if(stu!=null) {
//	    		response.setContentType("text/html");
//	    		response.sendRedirect("LecturServlet");
//		}
//		else {
//			response.setContentType("text/html");
//    		response.sendRedirect("UserClassShowServlet");
//		}
	}

}
