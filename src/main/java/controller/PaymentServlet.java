package controller;

import java.io.IOException;
import java.io.*;

import model.BankAccount;
import model.PaymentAccess;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String account=request.getParameter("accno");
		PaymentAccess pa=new PaymentAccess();
		BankAccount ba=pa.enrollUser(name, email, account);
	    
        boolean isValid=pa.isValid(email,account,ba.getAmount());
            boolean canJoin= pa.canJoin(email,account,ba.getAmount());
          
		if(isValid) {
			if(canJoin) {
				boolean reduceAmount=pa.reduceAmount(name, email,account, ba.getAmount());
				response.setContentType("text/html");
				RequestDispatcher rd = request.getRequestDispatcher("user/index.jsp");
				// out.println(" <div class=\"alert alert-danger \">Your Account is Invlid!</div>");
				//request.setAttribute("loginError", "error");
				rd.include(request, response);
			}
			else {
				response.setContentType("text/html");
				RequestDispatcher rd = request.getRequestDispatcher("user/enroll.jsp");
				// out.println(" <div class=\"alert alert-danger \">Your Account is Invlid!</div>");
				request.setAttribute("amountError", "error");
				rd.include(request, response);
			}
		
			}
		else {
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("user/enroll.jsp");
			// out.println(" <div class=\"alert alert-danger \">Your Account is Invlid!</div>");
			request.setAttribute("paymentError", "error");
			rd.include(request, response);
		}
	}

}
