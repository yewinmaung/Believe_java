package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.User;
import model.UserAccess;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10, // 10 MB
maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
/**
 * Servlet implementation class AdminChgProfileServlet
 */
@WebServlet("/AdminChgProfileServlet")
public class AdminChgProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChgProfileServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		String fileFolder = "upload_images";
		String savePath = "D:\\Java\\Believe\\Believe1\\src\\main\\webapp" + File.separator + fileFolder;
		File fileSaveDir = new File(savePath);

		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		int id=Integer.parseInt(request.getParameter("pid"));
		System.out.println("User id"+id);
		String name = request.getParameter("name");
		Part part = request.getPart("pimg");
		String fileName = extractFileName(part);
		String password = request.getParameter("pw");
		String confirm = request.getParameter("confirm");
		
		System.out.println(name+" adminImg "+fileName+"Pw"+password+"Confirm"+confirm);
		 System.out.println(password.equals(confirm));
		 HttpSession session = request.getSession(true);
		UserAccess ua=new UserAccess();
		 if (password.equals(confirm)) {
			User ur=ua.changeProfile(name,fileName, password, id);
			 
			User user=ua.selectUser(id);
			session.setAttribute("admin", user);
			response.setContentType("text/html");
			request.setAttribute("aung", "aung");
			//response.sendRedirect("UserLoginServlet");
			 RequestDispatcher rd=	request.getRequestDispatcher("admin/profile.jsp");
		     rd.forward(request, response);
		 }
		else {
			
			response.setContentType("text/html");
			request.setAttribute("onError", "error");
		   RequestDispatcher rd=request.getRequestDispatcher("admin/profile.jsp");
			rd.include(request, response);
		}
		
		

	}

	private String extractFileName(Part part) {
		// TODO Auto-generated method stub
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return null;
	}
	}


