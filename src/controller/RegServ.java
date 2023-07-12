package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/reg1")
public class RegServ extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String upass = request.getParameter("upass");
        String upass1 = request.getParameter("upass1");

        Student e = new Student(email, upass, upass1);

        try {
            if (upass.equals(upass1)) {
                int a = new StudentDao().save(e);

                if (a > 0) {
                    out.print("<p style='color: red; margin-top: 30px; text-align: center; font-weight: bold; font-size: 18px;'>Successfully Registered</p>");

                    // Create a cookie to store the email
                    Cookie emailCookie = new Cookie("email", email);
                    emailCookie.setMaxAge(24 * 60 * 60); // Set cookie expiration time to 24 hours
                    response.addCookie(emailCookie);

                    RequestDispatcher rd = request.getRequestDispatcher("login.html");
                    rd.include(request, response);
                } else {
                    out.print("<p style='color: red; margin-top: 30px; text-align: center; font-weight: bold; font-size: 18px;'>Data not inserted properly</p>");

                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                    rd.include(request, response);
                }
            } else {
                out.print("<p style='color: red; margin-top: 30px; text-align: center; font-weight: bold; font-size: 18px;'>Passwords are not matched</p>");

                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request, response);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
