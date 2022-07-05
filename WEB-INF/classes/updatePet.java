import java.io.*;
import javax.servlet.http.*;

import myBeans.petDAO;

import javax.servlet.*;
import java.sql.*;

public class updatePet extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<center>");
        HttpSession session = request.getSession(false);
        String email = (String)session.getAttribute("email");
        if(email != null)
        {   
            try
            {
                String petName = request.getParameter("petName");
                String petType = request.getParameter("petType");
                int petID = 0;
                try
                {
                   petID = Integer.parseInt(request.getParameter("petID"));
                }
                catch(NumberFormatException nfe)
                {
                    nfe.printStackTrace();
                }
                String dos = request.getParameter("dos");
                int age = 0;
                try
                {
                    age = Integer.parseInt(request.getParameter("age"));
                }
                catch (NumberFormatException nfe) 
                {
                    nfe.printStackTrace();
                }
               
                
                petDAO pDao = new petDAO();
                Boolean flag = pDao.updatePet(petID, petName, petType, dos, age, email);
                
                
                if(flag)
                {
                    out.println("<p>Record has been updated!</p>");
                    out.println("</center>");
                    RequestDispatcher rd = request.getRequestDispatcher("/updatePet.jsp");
                    rd.include(request, response);
                }
                else
                {
                    out.println("<p>Pet not Found</p>");
                    out.println("</center>");
                    RequestDispatcher rd = request.getRequestDispatcher("/updatePet.jsp");
                    rd.include(request, response);
                }
            }
            catch(Exception e)
            {
                out.println(e);
            }
           
        }
        else if(session == null)
        {
            out.println("<p>You're not Logged in. Kindly Login!</p>");
            out.println("</center>");
            RequestDispatcher rd = request.getRequestDispatcher("/loginPage.html");
            rd.include(request, response);
        }
        out.println("</body></html>");
       
    }
    
}
