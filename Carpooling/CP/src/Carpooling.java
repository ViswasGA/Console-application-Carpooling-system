import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.*;

import com.mysql.cj.xdevapi.Statement;

public class Carpooling {
    boolean exit;

    public static void main(String[] args) throws Exception {
        Carpooling c = new Carpooling();
        c.runcar();
    }

    public void header() {
        System.out.println("+-------------------------------------------+");
        System.out.println("|           Weclome to our                  |");
        System.out.println("|         Carpooliong System                |");
        System.out.println("+-------------------------------------------+");
    }

    public void servicemenu() {
        System.out.println("\nplease enter your choice:");
        System.out.println("---------------------------");
        System.out.println("1. Rent a Car");
        System.out.println("2. Passenger Details");
        System.out.println("3. Payment Details ");
        System.out.println("4. Updation Details ");
        System.out.println("0. Exit");
        System.out.println("---------------------------");
    }

    public void runcar() {
        header();
        while (!exit) {
            servicemenu();
            int choice = getInput();
            performAction(choice);

        }
    }

    public int getInput() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 4) {
            try {
                System.out.println("\nEnter your selection:");
                choice = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.print("Invalid selection.please try again");
            }
        }
        return choice;
    }

    public void performAction(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Thank you for using our carpooling system.");
                break;
            case 1:
                Driver d=new Driver();
                d.getDetails();
                break;
            case 2:
                Passenger p =new Passenger();
                p.getPassengerDetails();
                break;
            case 3:
              Payment pay=new Payment();
              pay.paymentgetDetails();
               break;
            case 4:

            default:
                System.out.print("An Unknown error occurred");
        }
    }
       
    }
    
    

