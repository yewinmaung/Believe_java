package controller;

import java.io.IOException;
import java.util.List;
import java.io.*;

import model.BankAccount;
import model.Category;
import model.Course;
import model.CourseAccess;
import model.Enroll;
import model.PaymentAccess;
import model.EnrollAccess;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import javax.servlet.http.*;

import model.UserAccess;
/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
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
		int userid=Integer.parseInt(request.getParameter("userid"));
		int classid=Integer.parseInt(request.getParameter("classid"));
		System.out.println(userid+"::"+classid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String account=request.getParameter("accno");
		PaymentAccess pa=new PaymentAccess();
		EnrollAccess ea=new EnrollAccess();
		BankAccount ba=pa.enrollUser(name, email, account);
		CourseAccess ca = new CourseAccess();
		RequestDispatcher rd = request.getRequestDispatcher("");
		boolean isValid=pa.isValid(email,account);
            boolean canJoin= pa.canJoin(email,account,ba.getAmount());
          
		if(isValid) {
			if(canJoin) {
				boolean reduceAmount=pa.reduceAmount(name, email,account, ba.getAmount());
				
				boolean flag=ea.getEnroll(userid, classid, name, email);
				
					List<Course> list = ca.detailLecture(classid);
					Category catlist=ca.showdetailClass(classid);
					if (list.size() > 0) {
						
						request.setAttribute("courselist", list);
						request.setAttribute("categorylist", catlist);
						//request.setAttribute("catlist", catlist);
						
						rd = request.getRequestDispatcher("user/video.jsp");
						rd.forward(request, response);
					} else {
						response.setContentType("text/html");
						System.out.println("error video");
						rd=request.getRequestDispatcher("user/video.jsp");
						request.setAttribute("noCourse","error");
						rd.include(request, response);
					}	
				
				
				//RequestDispatcher rd = request.getRequestDispatcher("user/video.jsp");
				//out.println(" <div class=\"alert alert-danger \">Your Account is Invlid!</div>");
				//request.setAttribute("loginError", "error");
				//rd.include(request, response);
				
				//response.sendRedirect("LectureServlet");
			}
			else {
				response.setContentType("text/html");
				rd = request.getRequestDispatcher("user/enroll.jsp");
				// out.println(" <div class=\"alert alert-danger \">Your Account is Invlid!</div>");
				request.setAttribute("amountError", "error");
				rd.include(request, response);
			}
		
			}
		else {
			response.setContentType("text/html");
			request.setAttribute("classid", classid);
			rd = request.getRequestDispatcher("user/enroll.jsp");
			// out.println(" <div class=\"alert alert-danger \">Your Account is Invlid!</div>");
			request.setAttribute("paymentError", "error");
			rd.include(request, response);
		}
	}

}
