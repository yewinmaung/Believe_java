package controller;

import java.io.File;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.CourseAccess;
import model.Category;
import model.Course;

//@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
/**
 * Servlet implementation class AddCourseServlet
 */
@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCourseServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=UTF-8");
		String fileFolder = "upload_images";
		String savePath = "D:\\Java\\Believe\\Believe1\\src\\main\\webapp" + File.separator + fileFolder;
		File fileSaveDir = new File(savePath);

		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		String name = request.getParameter("name");
		int type =Integer.parseInt(request.getParameter("type")) ;
		String link = request.getParameter("link");
		Part part = request.getPart("file");
		
		String fileName = extractFileName(part);
		CourseAccess ca = new CourseAccess();
		boolean flag = ca.addCourse(name, type, fileName, link);
		
			 if(flag) {
				
				part.write(savePath + File.separator + fileName);
				PrintWriter pw=response.getWriter();
				System.out.println(savePath + File.separator + fileName);
				response.sendRedirect("CourseListServlet");
			 }
			 else {
				
				 List<Category> list;
				try {
					list = ca.showClass();
					 response.setContentType("text/html");
					 request.setAttribute("courseErrorexist", "error");
					 request.setAttribute("categorylist", list);
					 RequestDispatcher rd = request.getRequestDispatcher("admin/addcourse.jsp");
					 rd.include(request, response);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 //response.sendRedirect("CreateClassServlet");
					
				}

		response.getWriter().print("The file uploaded sucessfully.");
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
