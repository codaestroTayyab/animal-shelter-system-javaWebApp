import java.io.*;
import javax.servlet.http.*;

import myBeans.petDAO;

import javax.servlet.*;
import java.sql.*;

public class Signup extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try
        {

            String name = request.getParameter("shelterName");
            String Email = request.getParameter("Email").toLowerCase();
            String pass = request.getParameter("Password");
            String num = (request.getParameter("countryCode") + request.getParameter("mobileNum"));
            String city = request.getParameter("City");
            String address = request.getParameter("address");


            petDAO pDao = new petDAO();
            Boolean flag = pDao.userSignup(name, Email, pass, num, city, address);

            out.println("<html>");
            out.println("<body>");
            
                if (flag)
                {
                    out.println("<center>");
                    out.println("<p>Sign up Successfull ! <br> You can login now.");
                    out.println("</center>");
                    RequestDispatcher rd = request.getRequestDispatcher("/loginPage.html");
                    rd.include(request, response);
                }
                else
                {
                    out.println("<center>");
                    out.println("<p>Error! Data not entered.</p>");
                    out.println("</center>");
                    RequestDispatcher rd = request.getRequestDispatcher("/signupPage.html");
                    rd.include(request, response);
                }

            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
            out.println("<center>");
            out.println("<p>Email already exist!</p>");
            out.println("</center>");
            RequestDispatcher rd = request.getRequestDispatcher("/signupPage.html");
            rd.include(request, response);
        }
        
    }
}
