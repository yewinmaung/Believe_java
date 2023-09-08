package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PaymentAccess;
import model.BankAccount;
/**
 * Servlet implementation class UpdateBankAccountServlet
 */
@WebServlet("/UpdateBankAccountServlet")
public class UpdateBankAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBankAccountServlet() {
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
		PaymentAccess pa=new PaymentAccess();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String accno=request.getParameter("account");
		
		int amount=Integer.parseInt(request.getParameter("amount"));
		boolean flag;
		try {
			flag = pa.updateAmount(name, email, accno, amount);
			
			if(flag) {
				response.setContentType("text/html");
				RequestDispatcher rd = request.getRequestDispatcher("ShowBankAccountServlet");
			
				rd.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
