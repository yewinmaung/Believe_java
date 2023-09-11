package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import model.Counter;
import model.CounterAccess;
import model.MessageAccess;
import model.Message;/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CounterServlet() {
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
		PrintWriter pt = response.getWriter();
		MessageAccess ma=new MessageAccess();
		List<Message> message=ma.showMessage();
		
		System.out.println("Message"+message);
		CounterAccess ca = new CounterAccess();
		Counter getc = ca.getClasse();
		Counter gete=ca.getenrollstu();
		Counter getr=ca.getReport();
		Counter getu=ca.getUser();
		request.setAttribute("classcount", getc);
		request.setAttribute("enrollCourse", gete);
		request.setAttribute("getUser", getu);
		request.setAttribute("report", getr);
		request.setAttribute("message", message);
		
		response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("admin/dashboard.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
