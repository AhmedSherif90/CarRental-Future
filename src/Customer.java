
public class Customer {

    private String name;
    private int id;
    private String phonenumber;
    private String adress;
    private String nationalIDcard;
    private String driverlicense;
    private String creditCard;

    public Customer() {
        name = "";
        adress = "";
        id = 0;
        phonenumber = "";
        nationalIDcard = "";
        driverlicense = "";
        creditCard = "";

    }

    public String getNationalIDcard() {
        return nationalIDcard;
    }

    public void setNationalIDcard(String nationalIDcard) {
        if ((nationalIDcard.charAt(0) == '2' || nationalIDcard.charAt(0) == '3')) {
            if (nationalIDcard.charAt(0) == '3') {

                if ((nationalIDcard.charAt(1) == '0') && (nationalIDcard.charAt(2) == '0' || nationalIDcard.charAt(2) == '1')) {
                    if (nationalIDcard.length() == 14 && nationalIDcard.matches("[0-9]+")) {
                        this.nationalIDcard = nationalIDcard;

                    } else {
                        throw new IllegalArgumentException("NationalIDcard must have 14 digit ");

                    }

                } else {
                    throw new IllegalArgumentException("You must be 18 or older  ");

                }

            }

            if (nationalIDcard.length() == 14 && nationalIDcard.matches("[0-9]+")) {
                this.nationalIDcard = nationalIDcard;

            } else {
                throw new IllegalArgumentException("NationalIDcard must have 14 digit ");

            }
        } else {
            throw new IllegalArgumentException("please input a real NIC... First digit must be 2 or 3");

        }

    }

    public String getDriverlicense() {
        return driverlicense;

    }

    public void setDriverlicense(String driverlicense) {

        this.driverlicense = this.nationalIDcard;

    }

    public String getName() {
        return name;

    }

    public void setName(String name) {

        String[] fullname = name.split(" ");

        if (fullname.length == 2) {
            this.name = name;

        } else {
            throw new IllegalArgumentException(" Name must have First ,Last Name");

        }
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;

    }

    public String getPhonenumber() {
        return phonenumber;

    }

    public void setPhonenumber(String phonenumber) {

        if ((phonenumber.charAt(0) == '0' && phonenumber.charAt(1) == '1' && phonenumber.length() == 11 && phonenumber.matches("[0-9]+"))) {
            this.phonenumber = phonenumber;

        } else {
            throw new IllegalArgumentException(" Phone Number must be digit , Phone Number must have 11 digit ");

        }
    }

    public String getAdress() {
        return adress;

    }

    public void setAdress(String adress) {
        this.adress = adress;

    }

    @Override
    public String toString() {
        String r = "***********************************************************************************\n";
        r += "                               Customer information                        \n";
        r += "=> Customer Name:- " + name + "\n" + "=> Id:-" + id + "\n" + "=> Customer phonenumber:-" + phonenumber + "\n" + "=> Customer adress:-" + adress + "\n" + "=> Customer Driverlicense:-" + driverlicense + "\n" + "=> Customer National ID Scard:-" + nationalIDcard + "\n";
        r += "*****************************************************************************";
        return r;

    }

    public String getCreditCard() {
        return creditCard;

    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

}
