package myBeans;
import java.io.*;


public class petBean implements Serializable
{
    private int petID;
    private String petName;
    private String petType;
    private String dos;
    private int age;

   public petBean()
   {
       petID = 0;
       petName = "";
       petType = "";
       dos = "";
       age = 0;
   }

   public void setId (int petID)
   {
       this.petID = petID;
   }

   public int getId()
   {
        return petID;
   }

   public void setName (String petName)
   {
       this.petName = petName;
   }

   public String getName()
   {
       return petName;
   }

   public void setType (String petType)
   {
       this.petType = petType;
   }

   public String getType()
   {
       return petType;
   }

   public void setDos (String dos)
   {
       this.dos = dos;
   }

   public String getDos()
   {
       return dos;
   }

   public void setAge(int age)
   {
       this.age = age;
   }

   public int getAge()
   {
        return age;
   }

   public String toString()
   {
       return "Pet ID: " + petID + "<br>" + "Pet Name: " + petName + "<br>" + "Pet Type: " +petType+ "<br>" +"Age: " + age +"<br>" + "Date of Submission: " + dos + "<br>";
   }
}
