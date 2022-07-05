package myBeans;
import java.util.*;
import java.io.*;
import java.sql.*;

public class petDAO 
{
    Statement st;
    Connection con;
    public petDAO() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1/userWeb";
        con = DriverManager.getConnection(url,"root","root");
        st = con.createStatement();
    }
    
    public Boolean addPet(petBean pet, String email) throws Exception
    {
        String petName = pet.getName();
        String petType = pet.getType();
        String dos = pet.getDos();
        int age = pet.getAge();

        if (petName == "" || petType == "" || dos == "" || age == 0)
        {
            return false;
        }
        String query = "insert into pet (email, petName, petType, dateOfSubmission, Age) values ('"+email+"' ,'"+petName+"' ,'"+petType+"' , '"+dos+"' , '"+age+"')";

            int rs = st.executeUpdate(query);

            if (rs > 0)
            {
               return true; 
            }
            else
            {
    	        return false;
            }
    }

    public ArrayList displayPetList(String email) throws Exception
    {
        String query = "SELECT * FROM PET where email = '"+ email+"'" ;
        ArrayList arr = new ArrayList<petBean>();
        ResultSet rs = st.executeQuery( query );
        
        while(rs.next())
        {
            petBean pet = new petBean();

            pet.setId(rs.getInt("petID"));
            pet.setName(rs.getString("petName"));
            pet.setType(rs.getString("petType"));
            pet.setDos(rs.getString("dateOfSubmission")); 
            pet.setAge(rs.getInt("Age"));

            arr.add(pet); 
        }
        return arr;
    }

    public Boolean removePet(int petID, String email) throws Exception
    {
        if(petID == 0)
        {
            return false;
        }
        String query = "DELETE FROM PET WHERE PETID = '"+ petID + "' AND EMAIL = '"+ email+ "'";
        int rs = st.executeUpdate(query);
        if(rs > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public ArrayList searchPet(int petID, String petName, String petType, String dos, int age, String email) throws Exception
    {
        
        String query = "SELECT * FROM PET WHERE email = '"+email+"' AND (PETID = '"+petID+"' OR PETNAME = '"+petName+"' OR PETTYPE = '" + petType + " ' OR dateOfSubmission = '"+dos+" ' OR AGE = '"+age+"')";
        
        ResultSet rs = st.executeQuery(query);
        ArrayList arr = new ArrayList<petBean>();  
        while(rs.next())
        {
            
            petBean pet = new petBean();

            pet.setId(rs.getInt("petID"));
            pet.setName(rs.getString("petName"));
            pet.setType(rs.getString("petType"));
            pet.setDos(rs.getString("dateOfSubmission")); 
            pet.setAge(rs.getInt("Age"));

            arr.add(pet); 
        }
        return arr;
    }

    public Boolean updatePet(int petID, String petName, String petType, String dos, int age, String email) throws Exception
    {
        if(petID == 0)
        {
            return false;
        }
        PreparedStatement pst=con.prepareStatement("Select * from pet WHERE petID = ? AND email = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

        pst.setInt(1, petID);
        pst.setString(2, email);
    
        ResultSet rs = pst.executeQuery();
        
        if(rs.next())
        {
            if(!petName.isEmpty())
            {
                rs.updateString("petName", petName);
            }
            if(!petType.isEmpty())
            {
                rs.updateString("petType", petType);
            }
            if(!dos.isEmpty())
            {
                rs.updateString("dateOfSubmission", dos);
            }
            if(age != 0)
            {
                rs.updateInt("Age", age);
            }
            rs.updateRow();
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean userLogin(String Email, String Pass) throws Exception
    {
        String query="SELECT * FROM USER WHERE Email = '"+Email+"' AND Pass = '"+Pass+"'";
        
        ResultSet rs = st.executeQuery( query );
        if(rs.next())
        {
           return true;
        }
        
        else
        {
            return false;
        } 
    }

    public Boolean userSignup(String name, String Email, String pass, String num, String city, String address) throws Exception
    {
        if(name == "" || Email == "" || pass == "" || num == "" || city =="" || address == "")
        {
            return false;
        }
        String query = "insert into user (email, pass, shelterName, mobileNum, address, city) values ('"+Email+"' , '"+pass+"' , '"+name+"', '"+num+"', '"+address+"', '"+city+"')";

        int rs = st.executeUpdate(query);

        if (rs > 0)
        {
            return true;
        }
        else
        {
            return false;
            
        }
            
    }  
    
}
