package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PaymentAccess;
/**
 * Servlet implementation class CreateBankAccountServlet
 */
@WebServlet("/CreateBankAccountServlet")
public class CreateBankAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBankAccountServlet() {
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
	String account=request.getParameter("account");
	String amount=request.getParameter("amount");
	PaymentAccess pa=new PaymentAccess();
	boolean cba=pa.createBankAccount(name, email,account, amount);
	if(cba) {
		RequestDispatcher rd=request.getRequestDispatcher("user/index.jsp");
		rd.forward(request, response);	
	}
	}

}
