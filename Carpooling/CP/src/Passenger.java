import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Passenger extends PassengerEntity {
    public static void getPassengerDetails(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the Passenger Details");
        String Passengername=sc.nextLine();
        System.out.println("Enter the Passenger Number");
        String PassengerNumber=sc.nextLine();
        System.out.println("Enter the Departure Area");
        String Departure=sc.nextLine();
        System.out.println("enter the Destination");
        String Destination=sc.nextLine();
        passengerdetails(Passengername, PassengerNumber, Departure, Destination);

    }
public static void passengerdetails(String passengername, String passengerNumber, String departure, String destination) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car", "root", "viswas@478");

        // Check if there are any records with the same "departure" and "destination" values
        String selectQuery = "SELECT * FROM Passenger WHERE Departure = ? AND Destination = ?";

        PreparedStatement selectStatement = con.prepareStatement(selectQuery);
        selectStatement.setString(1, departure);
        selectStatement.setString(2, destination);
        ResultSet resultSet = selectStatement.executeQuery();
        if (resultSet.next()) {
            // If there are matching records, book the ride for the new passenger
            String insertQuery = "INSERT INTO Booked_Passenger VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = con.prepareStatement(insertQuery);
            insertStatement.setString(1, resultSet.getString("passengername"));
            insertStatement.setString(2, passengername);
            insertStatement.setString(3, resultSet.getString("passengernumber"));
            insertStatement.setString(4, passengerNumber);
            insertStatement.setString(5, departure);
            insertStatement.setString(6, destination);
            int rowsInserted = insertStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Passenger is ready for a ride with "+resultSet.getString("passengername")+" with contact: "+resultSet.getString("passengernumber"));
                String deleteQuery = "DELETE FROM Passenger WHERE passengernumber = ?";
                PreparedStatement del = con.prepareStatement(deleteQuery);
                System.out.println(resultSet.getString("passengernumber"));
                del.setString(1,resultSet.getString("passengernumber"));
                del.executeUpdate();

            } else {
                System.out.println("Ride Failed");
            }
        } else {
            System.out.println("No suitable ride is available for this route. come back later");
             String insertQuery = "INSERT INTO Passenger VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = con.prepareStatement(insertQuery);
            insertStatement.setString(1, passengername);
            insertStatement.setString(2, passengerNumber);
            insertStatement.setString(3, departure);
            insertStatement.setString(4, destination);
            int rowsInserted = insertStatement.executeUpdate();

        }
        con.close();

    } catch (Exception e) {
        System.out.println(e);
    }
}

}