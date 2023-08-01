import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement; 
import java.util.*;



public class Driver implements DriverDetailsInterface{

   public  void getDetails()
     {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the Driver Details");
        String Drivername=sc.nextLine();
        System.out.println("Enter the Contact Number");
        String ContactNumber=sc.nextLine();
        System.out.println("Enter the Car name");
        String CarName=sc.nextLine();
        System.out.println("enter the price");
        int Price=sc.nextInt();
        Driverdetails(Drivername,ContactNumber,CarName,Price);
        
     }

     

     public void Driverdetails(String Drivername,String ContactNumber,String CarName,int Price){
      try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car","root","viswas@478");
        String insertQuery = "INSERT INTO Driver VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
            // Set the values for the placeholders
            preparedStatement.setString(1, Drivername);
            preparedStatement.setString(2, ContactNumber);
            preparedStatement.setString(3, CarName);
            preparedStatement.setInt(4,Price);
            // Execute the insert query
            int rowsInserted = preparedStatement.executeUpdate();
            if(rowsInserted > 0){
               System.out.println("Successful");
            }else{
               System.out.println("Failed");

            }
      } catch (Exception e){
         System.out.println(e);
      }
     }
}
