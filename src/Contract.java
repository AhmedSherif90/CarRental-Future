
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

/**
 *
 * @author AhmedSherif
 */
public class Contract {

    private String name;
    private String phonenumber;
    private String nationalIDcard;
    private int cusID;
    private long cr;
    private String driverlicense;
    private String payment;
    private int returnTime;
    private int totlaCost;
    LocalDate date;

    public Contract() {

    }

    public Contract(Request re) {

        this.driverlicense = re.getCustomer().getDriverlicense();
        this.phonenumber = re.getCustomer().getPhonenumber();
        this.nationalIDcard = re.getCustomer().getNationalIDcard();
        this.cusID = re.getCustomer().getId();
        this.name = re.getCustomer().getName();
        this.totlaCost = re.totlaCost();
        this.returnTime = re.getDuration();

    }

    public void save(int x) {
        try {
            FileWriter fw = new FileWriter("contracts\\contract" + x + ".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            try ( PrintWriter pw = new PrintWriter(bufferedWriter)) {

                pw.println(toString());

            }

        } catch (IOException e) {
            System.out.println("File not Found And"
                    + "Data is unsaved");
        }

    }

    @Override
    public String toString() {
        return "________________________________________________________________\n"
                + "\t\tContract\n\n"
                + "*Customer Name:- " + name
                + "\n*Customer ID:- " + cusID
                + "\n*Customer National ID card:- " + nationalIDcard
                + " \n*Customer Driver license:- " + driverlicense
                + " \n*Customer PhoneNumber :- " + phonenumber
                + " \n*Total Cost:-" + totlaCost + "L.E"
                + " \n*Customer PayMent:- " + getPayment()
                + " \n*Customer Cradit card number:-" + getCr()
                + " \n*Date :" + (date = LocalDate.now())
                + " \n*return time :" + (date = LocalDate.now().plusDays(returnTime)) + "\n\t\t\t\t(FutureAgance)\n\n"
                + "_______________________________________________________________";

    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public long getCr() {
        return cr;
    }

    public void setCr(long cr) {
        this.cr = cr;
    }

}
