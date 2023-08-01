import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Payment implements PaymentInterface {

    @Override
    public void  paymentgetDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Payment cash");
        int payment = sc.nextInt();
        sc.nextLine(); // Consume the newline character after reading the integer input
        System.out.println("Enter the Contact Number");
        String contactNumber = sc.nextLine();
        System.out.println("Enter the Rating for the Driver (1/2/3/4/5)");
        int rating = sc.nextInt();
        System.out.println("Guys, thanks again for giving me this feedback");
        Paymentdetails(payment, contactNumber,rating);
    }

    public void Paymentdetails(int payment, String contactNumber,int rating) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car", "root", "viswas@478");
            String insertQuery ="insert into payment values(?,?,?)" ;
            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
            // Set the values for the placeholders
            preparedStatement.setInt(1, payment);
            preparedStatement.setString(2, contactNumber);
            preparedStatement.setInt(3, rating);

            // Execute the insert query
            int rowsInserted = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
