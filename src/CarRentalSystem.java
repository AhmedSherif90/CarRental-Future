
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
 * @author AhmedSherif
 */
public class CarRentalSystem {

    private ArrayList<Customer> customerArray;
    private Customer newCustomer;
    private Contract newContract;
    private Request request;
    private final PassngerCar[] pCar;
    private final SportCars[] SCar;
    //Statics
    private static Scanner x;
    public static int position = 0;
    public static String counterasString = "";
    public static int counter = 0;
    public static int numofPcars = 0;
    public static int numofScars = 0;
    //ArrayList
    ArrayList<String> Passngercars;
    ArrayList<String> PcarCost;
    ArrayList<String> Supercars;
    ArrayList<String> ScarCost;

    /*M*/
    public CarRentalSystem() {
        this.customerArray = new ArrayList();
        LoadData();
        LoadCars();
        SCar = new SportCars[numofScars];
        pCar = new PassngerCar[numofPcars];
        for (int i = 0; i < numofPcars; i++) {
            pCar[i] = new PassngerCar(Passngercars.get(i), PcarCost.get(i));
        }
        for (int i = 0; i < numofScars; i++) {
           SCar[i] = new SportCars(Supercars.get(i), ScarCost.get(i));
        }
    }

    public void LoadCars() {

        Passngercars = new ArrayList<>();
        PcarCost = new ArrayList<>();
        Supercars = new ArrayList<>();
        ScarCost = new ArrayList<>();
        try {
            x = new Scanner(new File("Passngercars.txt"));

            while (x.hasNextLine()) {

                Passngercars.add(x.nextLine());
                numofPcars++;
            }
        } catch (FileNotFoundException e) {
        }
        try {
            x = new Scanner(new File("Passngercars.txt"));

            while (x.hasNext()) {
                if (x.next().equalsIgnoreCase("DialyCost:")) {
                    PcarCost.add(x.next());
                }
            }

        } catch (FileNotFoundException e) {
        }
        /////
        try {
            x = new Scanner(new File("SuperCars.txt"));

            while (x.hasNextLine()) {

                Supercars.add(x.nextLine());
                numofScars++;
            }

        } catch (FileNotFoundException e) {
        }
        try {

            x = new Scanner(new File("SuperCars.txt"));

            while (x.hasNext()) {
                if (x.next().equalsIgnoreCase("DialyCost:")) {
                    ScarCost.add(x.next());
                }
            }

        } catch (FileNotFoundException e) {
        }
    }

    public void setName(Customer newCustomer) {
        Scanner in = new Scanner(System.in);

        if (newCustomer.getName().length() == 0) {
            System.out.println("please enter your First & Last Name,Sir:-");

            // removes the spaces and returns the omitted string.
            String name = in.nextLine().trim();

            newCustomer.setName(name);

        }
    }

    public int setNationalIDcard(Customer newCustomer) {
        Scanner in = new Scanner(System.in);
        if (newCustomer.getNationalIDcard().length() == 0) {
            System.out.println("Enter your National ID card OR \"q\" to quit:- ");
            // removes the spaces and returns the omitted string.
            String NationalIDcard = in.nextLine().trim();

            if ("q".equals(NationalIDcard.toLowerCase())) {
                return 0;
            }
            newCustomer.setNationalIDcard(NationalIDcard);
            newCustomer.setDriverlicense(NationalIDcard);

        }
        return 1;
    }

    public void setPhone_setadress(Customer newCustomer) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your Phone Number:- ");
        String phoneNumber = in.nextLine().trim();
        newCustomer.setPhonenumber(phoneNumber);

        //set adress
        System.out.println("Enter your Adress (example: 22 jump street):- ");
        String adress = in.nextLine();
        newCustomer.setAdress(adress);
    }

    /*M*/
    public void addCustomer() {

        boolean notVaildInput = true;
        newCustomer = new Customer();
        System.out.println("Please input Customer information");
        while (notVaildInput) {
            try {
                //set Name
                setName(newCustomer);
                //set NationalIDcard
                if (setNationalIDcard(newCustomer) == 0) {
                    return;
                }
                //set phoneNumber
                setPhone_setadress(newCustomer);
                //set id  start from 1000
                int id = (counter + 1000);
                newCustomer.setId(id);
                ///// Break While Loop\\\\\
                notVaildInput = false;
            } catch (Exception e) {
                System.out.println("Error invaild typing format");
                System.out.println(e.getMessage());
            }

        }
        customerArray.add(newCustomer);
        System.out.println(newCustomer);
    }

    public void print() {

        System.out.println("__________________________________");
        System.out.println("Please chose type of car:-");
        System.out.println("---------------------------");
        System.out.println("1: Passnger car ");
        System.out.println("2: Sports and super cars ");
        System.out.print("Enter your option:  ");
    }

    /*M*/
    public void PlaceRequest() {

        request = new Request();
        boolean notVaildInput = true;
        Scanner inn = new Scanner(System.in);
        String customerId = "";
        while (notVaildInput) {
            try {
                System.out.println("Please input Customer ID in customer information OR \"q\" to quit:- ");
                customerId = inn.nextLine();
                if ("q".equals(customerId.toLowerCase())) {
                    return;
                }
                int check = Integer.parseInt(customerId);
                
                try {
                    if (check != newCustomer.getId()) {
                        throw new IllegalArgumentException("  customer id not found in our data ");
                    }
                } catch (IllegalArgumentException e) {
                }
                request.setCustomer(newCustomer);
                notVaildInput = false;
            } catch (Exception ex) {
                System.out.println("Error :wrong format, or customer id not found in our data ");
            }
        }
        notVaildInput = true;
        while (notVaildInput) {
            try {
                print();
                Scanner sc = new Scanner(System.in);
                String CarType = sc.nextLine().trim();
                Scanner in = new Scanner(System.in);
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
            Scanner in = new Scanner(System.in);
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
                Confirmtherequest();
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

    public void Confirmtherequest() {
        Scanner in = new Scanner(System.in);
        boolean notVaildInput1 = true;
        while (notVaildInput1) {
            System.out.println("Do you want confirm the request:-");
            System.out.println("1: yes");
            System.out.println("2: no");
            char choice2 = in.next().charAt(0);

            switch (choice2) {
                case '2':
                    customerArray.clear();
                    return;
                case '1':
                    disPayment();
                    String payment = in.next();
                    if (payment.charAt(0) == '1') {
                        payment1();
                        notVaildInput1 = false;
                    } else if (payment.charAt(0) == '2') {
                        System.out.print("Enter a credit card number:- ");
                        long number = in.nextLong();
                        CreaditCardChecker cr = new CreaditCardChecker(number);
                        cr.print();
                        if (cr.isIsValid()) {
                            payment2(number);
                            notVaildInput1 = false;
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

        }

    }

    public void disPayment() {
        System.out.println("Enter what is the payment method: ");
        System.out.println("1: Cash");
        System.out.println("2: Cradit Card");
    }

    public void payment1() {
        request.setConfirmed(true);
        newContract = new Contract(request);
        newContract.setPayment("Cash");
        
        counter++;
        request.setRequestid(counter);
        SaveData();
        System.out.println(request);
        System.out.println(newContract);
        newContract.save(counter);
        request.setDuration(0);
        customerArray.clear();
    }

    public void payment2(long number) {
        request.setConfirmed(true);
        newContract = new Contract(request);
        newContract.setPayment("by Cradit Card");
        newContract.setCr(number);
         
        counter++;
        request.setRequestid(counter);
        SaveData();
        System.out.println(request);
        System.out.println(newContract);
        newContract.save(counter);
        request.setDuration(0);
        customerArray.clear();

    }

    public void LoadData() {
        try {
            x = new Scanner(new File("Numofrequest.txt"));
            while (x.hasNext()) {
                counterasString = x.next();
                counter = Integer.parseInt(counterasString);
            }
        } catch (FileNotFoundException e) {
        }
      

    }

    public void SaveData() {
        counterasString = String.valueOf(counter);
        try {
            FileWriter fw = new FileWriter("Numofrequest.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bufferedWriter)) {
                pw.println(counterasString);

            }
        } catch (IOException e) {
            System.out.println("File not Found And"
                    + "Data is unsaved");
        }
        try {
            FileWriter fw = new FileWriter("request.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bufferedWriter)) {

                pw.println(request);

            }

        } catch (IOException e) {
            System.out.println("File not Found And"
                    + "Data is unsaved");
        }

    }

    /*M*/
    public void Serch() {
        Scanner in = new Scanner(System.in);
        boolean notVaildInput = true;

        while (notVaildInput) {
            try {
                System.out.println("Input userName ");
                String UserName = in.next();
                if (UserName.equals("admin") || UserName.equals("ADMIN")) {
                    System.out.println("Input Password ");
                    String Password = in.next();
                    if (Password.equals("123")) {
                      
                        System.out.println("input customer id");
                        int index = in.nextInt();
                        position = (index - 1000) + 1;
                        if (counter >= position) {
                            try {
                                x = new Scanner(new File("contracts\\contract" + position + ".txt"));
                                String data[] = new String[13];
                                while (x.hasNext()) {
                                    for (int i = 0; i < 13; i++) {
                                        data[i] = x.nextLine();
                                    }
                                    String Show = Show(data[3], data[4], data[5], data[6], data[7],
                                            data[8], data[9], data[10], data[11], data[12]);
                                    System.out.println(Show);
                                    break;
                                }
                                x.close();
                                notVaildInput = false;
                            } catch (FileNotFoundException e) {
                            }
                        } else {
                            System.out.println("no data for this id");
                        }
                    } else {
                        System.out.println("Password is invalid");
                    }
                } else {
                    System.out.println("UserName not found in our database");
                }
            } catch (Exception e) {
                System.out.println("Error check with valid input");
            }
        }
    }

    public String Show(String name, String cusID, String nationalIDcard, String driverlicense, String phonenumber, String totlaCost, String Payment, String Cr, String date, String returnTime) {
        return "________________________________________________________________\n"
                + "\t\tContract\n\n"
                + name
                + "\n" + cusID
                + "\n" + nationalIDcard
                + "\n" + driverlicense
                + "\n" + phonenumber
                + "\n" + totlaCost
                + "\n" + Payment
                + "\n" + Cr
                + "\n" + (date)
                + "\n" + (returnTime) + "\n\t\t\t\t(FutureAgance)\n\n"
                + "_______________________________________________________________\n\n";

    }

    public ArrayList<Customer> getCustomerArray() {
        return customerArray;
    }

    public void setCustomerArray(ArrayList<Customer> customerArray) {
        this.customerArray = customerArray;
    }

}
