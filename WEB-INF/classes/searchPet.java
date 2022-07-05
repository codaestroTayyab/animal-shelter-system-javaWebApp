import java.io.*;
import javax.servlet.http.*;

import myBeans.petBean;
import myBeans.petDAO;

import javax.servlet.*;
import java.sql.*;
import java.util.ArrayList;

public class searchPet extends HttpServlet
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
                String petName = request.getParameter("petName");
                int petID = 0;
                try
                {
                    petID = Integer.parseInt(request.getParameter("petID"));
                }
                catch (NumberFormatException nfe) 
                {
                    nfe.printStackTrace();
                }
                String petType = request.getParameter("petType");
                String dos = request.getParameter("petDos");
                int age = 0;
                try
                {
                    age = Integer.parseInt(request.getParameter("petAge"));
                }
                catch (NumberFormatException nfe) 
                {
                    nfe.printStackTrace();
                }

                
                petDAO pDao = new petDAO();
                ArrayList arr = pDao.searchPet(petID, petName, petType, dos, age, email);
                
                Boolean flag = false;
                for(int i = 0; i < arr.size(); i++)
                {
                    petBean pet = (petBean)arr.get(i);
                    out.println("<h1>Pet # " +(i+1)+ " </h1>");
                    out.println(pet);
                    flag = true;
                }
                if(flag == true)
                {
                    
                    out.println("<br><br><br>");
                    RequestDispatcher rd = request.getRequestDispatcher("/backToMain.html");
                    rd.include(request, response);
                    out.print("</center>");
                }
                if (arr.size() == 0)
                {
                    out.println("<p>Pet not Found</p>");
                    out.println("</center>");
                    RequestDispatcher rd = request.getRequestDispatcher("/searchPet.jsp");
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
            out.println("</body></html>");
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
    
}
