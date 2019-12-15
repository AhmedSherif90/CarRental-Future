/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.util.Scanner;

/**
 *
 * @author AhmedSherif
 */
public class Main {

    public static void main(String[] args) {
        CarRentalSystem rs = new CarRentalSystem();
        System.out.println("---------------------------");
        System.out.println("Car rental System");
        System.out.println("Welcome Mr.Administrator ");
        System.out.println("---------------------------");

        while (true) {
            int choice = menu();
            switch (choice) {
                case 0:
                    System.out.println("\n\nThank you to visit us");
                    return;
                case 1:
                    rs.addCustomer();
                    break;

                case 2:
                    if (rs.getCustomerArray().isEmpty()) {
                        System.out.println("\nPlease! add a new customer first, Sir");
                        break;
                    } else {
                        rs.PlaceRequest();
                        break;

                    }
                    /*
                case 3:

                    rs.Serch();
                    break;
*/
            }
        }

    }

    private static int menu() {
        System.out.println(" ____________________________________________");
        System.out.println("|Chose from following options:-              |");
        System.out.println("|-----------------------------               |");
        System.out.println("|1: Add new Customer                         |");
        System.out.println("|2: New Request                              |");
       // System.out.println("|3: Serch in contracts                       |");
        System.out.println("|0: Exit                                     |");
        System.out.println(" ____________________________________________ ");
        Scanner in = new Scanner(System.in);
        int choice = -1;
        do {
            try {
                System.out.print("=>Please enter your option ,Sir: ");
                choice = in.nextInt();
                in.nextLine();
                if (choice < 0 || choice > 2) {

                    System.out.println("Invalid  enter vaild Number");
                }
 
            } catch (Exception e) {

                System.out.println("Invalid  input please input digits only");

                break;
            }
        } while (choice < 0 || choice > 2);

        return choice;
        
    }

}
