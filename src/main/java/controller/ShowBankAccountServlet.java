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

import model.BankAccount;
import model.Course;
import model.PaymentAccess;
/**
 * Servlet implementation class ShowBankAccountServlet
 */
@WebServlet("/ShowBankAccountServlet")
public class ShowBankAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBankAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       PaymentAccess pa=new PaymentAccess();
       RequestDispatcher rd = request.getRequestDispatcher("");
       
       try {
		List<BankAccount> list = pa.showBankAccount();
		  
		if (list.size() > 0) {
			request.setAttribute("accountList", list);
			rd = request.getRequestDispatcher("admin/bankAccount.jsp");
			rd.forward(request, response);
		}
		else {
			response.setContentType("text/html");
			
			rd=request.getRequestDispatcher("admin/bankAccount.jsp");
			request.setAttribute("noAccount","error");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
