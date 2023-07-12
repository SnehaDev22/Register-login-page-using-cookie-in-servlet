package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/log")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String upass = request.getParameter("upass");
		
		Student e = new Student(email, upass);
		try {  
			boolean verified = new StudentDao().verifyUser(e);

			if (verified) {
		        out.print("<p style='color: red; margin-top: 30px; text-align: center; font-weight: bold; font-size: 18px;'>Log In Successfully</p>");

				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);

				// Perform further actions after successful login

			} else {
		        out.print("<p style='color: red; margin-top: 30px; text-align: center; font-weight: bold; font-size: 18px;'>Invalid login or password</p>");

				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
