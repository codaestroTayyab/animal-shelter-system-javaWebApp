import java.io.*;
import javax.servlet.http.*;

import myBeans.petDAO;

import javax.servlet.*;
import java.sql.*;

public class Login extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String Email = request.getParameter("Email").toLowerCase();
        String Pass = request.getParameter("Password");

        out.println("<html><body>");
        try
        {
            petDAO pDao = new petDAO();
            Boolean flag = pDao.userLogin(Email, Pass);
            
            if(flag)
            {
                HttpSession session = request.getSession();
                session.setAttribute("email", Email);
                RequestDispatcher rd = request.getRequestDispatcher("/homePage.jsp");
                rd.forward(request, response);
            }
            
            else
            {
                out.println("<center>");
                out.println("<p>Wrong Email or Password.</p>");
                out.println("</center>");
                RequestDispatcher rd = request.getRequestDispatcher("/loginPage.html");
                rd.include(request, response);
            }

            out.println("</body></html>");
        }
        catch (Exception e)
        {
            out.println(e);
        }

    }
}
