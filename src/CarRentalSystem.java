 
import java.util.ArrayList;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author AhmedSherif
 */
public class CarRentalSystem {

    private ArrayList<Customer> customerArray;
    private Customer newCustomer;
    private Contract newContract;
    private Request request;
    private PassngerCar[] pCar;
    private SportCars[] SCar;
    private Scanner x;
    public static String counterasString = "";
    public static int counter = 0;
    public static int ios = 10;

    public CarRentalSystem() {

        this.customerArray = new ArrayList();

        SCar = new SportCars[4];
        SCar[0] = new SportCars("Chevrolet\t", "Corvett\t ", "2019\t", 6500, "\tRed\t", "15000");
        SCar[1] = new SportCars("Chevrolet\t", "Camaro\t", "2019\t", 2500, "\tYellow\t", "15000");
        SCar[2] = new SportCars("Ford     \t", "Mustang\t", "2019\t", 3000, "\tBlack\t", "15000");
        SCar[3] = new SportCars("Mini Cooper\t", "Countryman", "2019", 3500, "\tBlue", "15000");

        pCar = new PassngerCar[10];
        pCar[0] = new PassngerCar("Honda\t", "Civic\t", "2018\t", "5\t", "Red\t", "1800");
        pCar[1] = new PassngerCar("BMW  \t", "3 Series\t", "2019\t", "5\t", "Black\t", "1800");
        pCar[2] = new PassngerCar("Ford \t", "Focus\t", "2018\t", "5\t", "Sliver\t", "1800");
        pCar[3] = new PassngerCar("Mazda\t", "3\t", "2020\t", "5\t", "Sliver\t", "1800");
        pCar[4] = new PassngerCar("Honda\t", "Accord\t", "2018\t", "5\t", "Red\t", "1800");
        pCar[5] = new PassngerCar("Toyota\t", "MR2\t", "2018\t", "5\t", "Red\t", "1800");
        pCar[6] = new PassngerCar("Audi  \t", "5000\t", "2018\t", "5\t", "Blue\t", "1800");
        pCar[7] = new PassngerCar("Mercedes-Benz\t", "GLC\t", "2017\t", "7\t", "Sliver\t", "1800");
        pCar[8] = new PassngerCar("Audi  \t", "Q5\t", "2019\t", "7\t", "Black\t", "1800");
        pCar[9] = new PassngerCar("Jeep  \t", "Gladiator\t", "2020\t", "5\t", "Blue\t", "1800");

    }

    public int LoadData() {

        try {
            x = new Scanner(new File("Numofrequest.txt"));

            while (x.hasNext()) {

                counterasString = x.next();

                counter = Integer.parseInt(counterasString);

            }

        } catch (FileNotFoundException e) {
        }
        return counter;

    }

    public void addCustomer() {

        Scanner in = new Scanner(System.in);
        newCustomer = new Customer();
        request = new Request();

        boolean notVaildInput = true;
        while (notVaildInput) {
            try {
                System.out.println("Please input Customer information");
                if (newCustomer.getName().length() == 0) {
                    System.out.println("please enter your First & Last Name,Sir:-");

                    // removes the spaces and returns the omitted string.
                    String name = in.nextLine().trim();

                    newCustomer.setName(name);
                }

                //set NationalIDcard
                if (newCustomer.getNationalIDcard().length() == 0) {
                    System.out.println("Enter your National ID card OR \"q\" to quit:- ");
                    String NationalIDcard = in.nextLine().trim();

                    if ("q".equals(NationalIDcard.toLowerCase())) {
                        return;

                    }
                    newCustomer.setNationalIDcard(NationalIDcard);
                    newCustomer.setDriverlicense(NationalIDcard);
                }
                // removes the spaces and returns the omitted string.

                //set phoneNumber
                System.out.println("Enter your Phone Number:- ");
                String phoneNumber = in.nextLine().trim();
                newCustomer.setPhonenumber(phoneNumber);

                //set adress 
                System.out.println("Enter your Adress (example: 22 jump street):- ");
                String adress = in.nextLine();
                newCustomer.setAdress(adress);
                //set id  start from 1000
                int id = (LoadData() + 1000);
                newCustomer.setId(id);

                ///// Break While Loop\\\\\
                notVaildInput = false;

            } catch (Exception e) {
                System.out.println("Error invaild typing format");
                System.out.println(e.getMessage());
            }

        }
        customerArray.add(newCustomer);
        request.setConfirmed(true);
        System.out.println(newCustomer);
    }

    public void PlaceRequest() {
        request = new Request();
        boolean notVaildInput = true;
        Scanner in = new Scanner(System.in);
        String customerId = "";
        while (notVaildInput) {
            try {
                System.out.println("Please input Customer ID in customer information OR \"q\" to quit:- ");

                customerId = in.nextLine();

                if ("q".equals(customerId.toLowerCase())) {
                    return;

                }

                int check = Integer.valueOf(customerId);

                if (check != newCustomer.getId()) {
                    throw new IllegalArgumentException("  customer id not found in our data ");

                }

                request.setCustomer(newCustomer);
                notVaildInput = false;

            } catch (Exception ex) {
                System.out.println("Error :wrong format");
            }

        }
        notVaildInput = true;

        while (notVaildInput) {
            try {
                System.out.println("__________________________________");
                System.out.println("Please chose type of car:-");
                System.out.println("---------------------------");
                System.out.println("1: Passnger car ");
                System.out.println("2: Sports and super cars ");
                System.out.print("Enter your option:  ");

                String CarType = in.nextLine().trim();
                switch (CarType) {
                    case "1":
                        PassngerCar passcCar;
                        System.out.println("Chose one car from list:- ");

                        for (int i = 0; i < pCar.length; i++) {
                            System.out.println((i + 1) + "\t" + this.pCar[i]);

                        }
                        int choice = in.nextInt();
                        int index = (choice - 1);
                        if (index > pCar.length) {
                            System.out.println("Error");
                        }
                        passcCar = (PassngerCar) pCar[index];

                        request.setCar(passcCar);

                        notVaildInput = false;
                        break;
                    case "2":
                        SportCars sportcar;
                        for (int i = 0; i < SCar.length; i++) {
                            System.out.println((i + 1) + ">>" + this.SCar[i]);

                        }
                        int choic = in.nextInt();
                        int indx = choic - 1;
                        if (indx > SCar.length) {
                            System.out.println("Error");
                        }
                        sportcar = (SportCars) SCar[indx];

                        request.setCar(sportcar);

                        notVaildInput = false;
                        break;
                   
                    default:
                        System.out.println("Invalid input");
                        break;
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("out of   maximum");
            } catch (IllegalArgumentException e) {

                System.out.println("Error IllegalArgument ");

            } catch (InputMismatchException e) {
                System.out.println("Invalid input");

            }

        }
        notVaildInput = true;
        while (notVaildInput) {
            try {
                if (request.getDuration() == 0) {
                    System.out.println("Please Enter the duration:");
                    String dr = in.next();
                    if (dr.matches("[0-9]+")) {
                        int duration = Integer.parseInt(dr);
                        request.setDuration(duration);
                    } else {
                        throw new InputMismatchException("input digit only");
                    }
                }

                System.out.println("Do you want confirm the request:-");
                System.out.println("1: yes");
                System.out.println("2: no");

                char choice2 = in.next().charAt(0);

                switch (choice2) {
                    case '2':
                        return;
                    case '1':
                        System.out.println("Enter what is the payment method: ");
                        System.out.println("1: Cash");
                        System.out.println("2: Cradit Card");
                        String payment = in.next();
                        if (payment.charAt(0) == '1') {
                            request.setConfirmed(true);
                            newContract = new Contract(request);
                            newContract.setPayment("Cash");
                            //Load&&Save Data 
                            //Ahmed Sherif
                            LoadData();
                            ++counter;
                            request.setRequestid(counter);

                            SaveData();
                            System.out.println(request);

                            System.out.println(newContract);
                            newContract.save(counter);
                            request.setDuration(0);
                        } else if (payment.charAt(0) == '2') {
                            System.out.print("Enter a credit card number:- ");
                            long number = in.nextLong();
                            CreaditCardChecker cr = new CreaditCardChecker(number);
                            cr.print();
                            if (cr.isIsValid()) {
                                request.setConfirmed(true);
                                newContract = new Contract(request);
                                newContract.setPayment("by Cradit Card");
                                newContract.setCr(number);
                                //Load&&Save Data
                                //Ahmed Sherif
                                LoadData();
                                ++counter;
                                request.setRequestid(counter);

                                SaveData();
                                System.out.println(request);
                                System.out.println(newContract);
                                newContract.save(counter);
                                request.setDuration(0);
                            } else {
                                System.out.println("invalid creadit card");
                                return;
                            }
                            break;
                        } 
                         break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
                notVaildInput = false;
            } catch (NumberFormatException e) {

                System.out.println("Invalid input");

            } catch (InputMismatchException e) {
                System.out.println("Invalid  input please input digits only");

            } catch (Exception e) {
                System.out.println("Invalid  input please check your input");

            }

        }

    }

    public void SaveData() {
        counterasString = String.valueOf(counter);
        try {
            FileWriter fw = new FileWriter("Numofrequest.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            try ( PrintWriter pw = new PrintWriter(bufferedWriter)) {
                pw.println(counterasString);

            }

        } catch (IOException e) {
            System.out.println("File not Found And"
                    + "Data is unsaved");
        }

        try {
            FileWriter fw = new FileWriter("request.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            try ( PrintWriter pw = new PrintWriter(bufferedWriter)) {

                pw.println(request);

            }

        } catch (IOException e) {
            System.out.println("File not Found And"
                    + "Data is unsaved");
        }

    }

    public ArrayList<Customer> getCustomerArray() {
        return customerArray;
    }

    public void setCustomerArray(ArrayList<Customer> customerArray) {
        this.customerArray = customerArray;
    }
    /* working in serch of contract
    public void Serch() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input userName ");
        String UserName = in.next();
        if (UserName.equals("admin") || UserName.equals("ADMIN")) {
            System.out.println("Input Password ");
            int Password = in.nextInt();
            if (Password == 123) {

                System.out.println("input customer id");
                //1001 1000-1000 =0 +1 =1

            } else {
                System.out.println("Password is invalid");
            }
        } else {
            System.out.println("UserName not found in our database");
        }

    }
     */
}
