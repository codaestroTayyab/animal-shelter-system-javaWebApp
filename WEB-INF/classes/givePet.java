import java.io.*;
import javax.servlet.http.*;

import myBeans.petDAO;

import javax.servlet.*;
import java.sql.*;

public class givePet extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<center>");
        try
        {   
            HttpSession session = request.getSession(false);
            String email = (String) session.getAttribute("email");
            if(email != null)
            {
                int petID = 0;
                try
                {
                   petID = Integer.parseInt(request.getParameter("petID"));
                }
                catch(NumberFormatException nfe)
                {
                    nfe.printStackTrace();
                }
               
                petDAO pDao = new petDAO();
                Boolean flag= pDao.removePet(petID, email);

                if(flag)
                {
                    out.println("<p>Pet is given successfully and removed from the system</p>");
                    out.println("</center>");
                    RequestDispatcher rd = request.getRequestDispatcher("/givePet.jsp");
                    rd.include(request, response);
                }
                else
                {
                    out.println("<p>Pet not Found</p>");
                    out.println("</center>");
                    RequestDispatcher rd = request.getRequestDispatcher("/givePet.jsp");
                    rd.include(request, response);
                }       
            }
            else
            {
                out.println("<p>You're not Logged in. Kindly Login!</p>");
                out.println("</center>");
                RequestDispatcher rd = request.getRequestDispatcher("/loginPage.html");
                rd.include(request, response);
            }
            
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
    
}
