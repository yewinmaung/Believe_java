package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.CourseAccess;
//@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
/**
 * Servlet implementation class UpdateClassServlet
 */
@WebServlet("/UpdateClassServlet")
public class UpdateClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClassServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		String fileFolder = "upload_images";
		String savePath = "D:\\Java\\Believe\\Believe1\\src\\main\\webapp" + File.separator + fileFolder;
		File fileSaveDir = new File(savePath);

		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		String title=request.getParameter("title");
		
		Part part = request.getPart("cimg");
		String fileName = extractFileName(part);
		int id=Integer.parseInt(request.getParameter("classid"));
		String price=request.getParameter("price");
		CourseAccess ca = new CourseAccess();
		boolean flag=ca.updateCategory(id,title, fileName, price);
		if(flag) {
			 
			 part.write(savePath + File.separator + fileName);
			PrintWriter pw=response.getWriter();
			System.out.println(savePath + File.separator + fileName);
			
			response.sendRedirect("CategoryListServlet");
		 }
		 else {
			 response.setContentType("text/html");
			 request.setAttribute("courseErrorexist", "error");
			 //RequestDispatcher rd = request.getRequestDispatcher("admin/addcourse.jsp");
				//rd.include(request, response);
			 response.sendRedirect("admin/classdetail.jsp");
				
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
