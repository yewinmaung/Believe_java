package controller;

import java.io.IOException;
import java.io.PrintWriter;
import model.BankAccount;
import model.PaymentAccess;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateBankAccountServlet
 */
@WebServlet("/EditBankAccountServlet")
public class EditBankAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBankAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BankAccount ba=new BankAccount();
        PaymentAccess pa=new PaymentAccess();
		String id=request.getParameter("paymentsid");
		System.out.println("Payment Id :"+id);
		 
		ba=pa.getBankAccount(id);
		
		response.setContentType("text/html");
		request.setAttribute("ba", ba);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin/editbankaccount.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
