import java.io.*;
import javax.servlet.http.*;

import myBeans.petBean;
import myBeans.petDAO;

import javax.servlet.*;
import java.sql.*;
import java.util.ArrayList;

public class displayPet extends HttpServlet
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
            String email = (String)session.getAttribute("email");
            if(email != null)
            {
                petDAO pDao = new petDAO();
                ArrayList arr = pDao.displayPetList(email);
                
                for(int i = 0; i < arr.size(); i++)
                {
                    petBean pet = (petBean)arr.get(i);
                    out.println("<h1>Pet # " +(i+1)+ " </h1>");
                    out.println(pet);
                }
                
                if (arr.size() == 0)
                { 
                    out.println("<h1>Pet not Found</h1>");
                }
                out.println("<br><br><br>");
                out.println("</center>");
               
                RequestDispatcher rd = request.getRequestDispatcher("/backToMain.html");
                rd.include(request, response);
            }
            else
            {
                out.println("<p>You're not Logged in. Kindly Login!</p>");
                out.println("</center>");
                RequestDispatcher rd = request.getRequestDispatcher("/loginPage.html");
                rd.include(request, response);
            }
            out.println("</body></html>");
            
           
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
    
}
