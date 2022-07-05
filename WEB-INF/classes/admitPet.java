import java.io.*;
import javax.servlet.http.*;

import myBeans.petBean;
import myBeans.petDAO;

import javax.servlet.*;
import java.sql.*;

public class admitPet extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try
        {   
            String petName = request.getParameter("petName");
            String petType = request.getParameter("petType");
            String dos = request.getParameter("dos");
            int age = 0;
            try
            {
               age = Integer.parseInt(request.getParameter("age"));
            }
            catch(NumberFormatException nfe)
            {
                nfe.printStackTrace();
            }


            out.println("<html>");
            out.println("<body>");
            out.println("<center>");
            HttpSession session = request.getSession(false);
            String email = (String)session.getAttribute("email");
            if(email != null)
            {
                petBean pet = new petBean();
                pet.setName(petName);
                pet.setType(petType);
                pet.setDos(dos);
                pet.setAge(age);
                
                petDAO pDao = new petDAO();
                Boolean flag= pDao.addPet(pet, email);
                
                if (flag)
                {
                    
                    out.println("<p>Pet Admitted Successfully!</p>");
                    out.println("</center>");
                    RequestDispatcher rd = request.getRequestDispatcher("/admitPet.jsp");
                    rd.include(request, response);
                    
                }
                else
                {
                    out.println("<p>Error! Pet not Admitted <br> Fill all Fields Please!.</p>");
                    out.println("</center>");
                    RequestDispatcher rd = request.getRequestDispatcher("/admitPet.jsp");
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

            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
