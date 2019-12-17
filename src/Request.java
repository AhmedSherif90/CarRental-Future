 
public class Request {

    private Car car;

    public Car getCar() {
        return car;
    }
    private Customer customer;
    private int duration;
    private int requestid;
    private boolean confirmed;

    public Request() {

    }
    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    
    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
   
        this.duration = duration;
      
            }
         
   

    public int getRequestid() {
        return requestid;
    }

    public void setRequestid(int requestid) {
        this.requestid = requestid;
    }
//Shefo

    public int totlaCost() {
        int total = (int) (Integer.valueOf((this.car.getDialycost())) * duration);
        if (duration > 3) {
            total *= 0.55; //15% discount
        }
        return total;
    }

    @Override
    public String toString() {
        String result = "_____________________________________________________________________________\n";
        result += "\t\t RequestId :(" + requestid + ")\n";
        result += customer;

        if (car instanceof PassngerCar) {
            result += "\ncar Maker & model\t YEAR\t DialyCost\t Seats\t Color \n";

        } else {
            result += "\ncar Maker & model\t YEAR\t DialyCost\t EngineSize\t Color \n";

        }

        result += car;
        result += "\nduration:- " + duration;
        result += duration > 1 ? " days\n " : " day\n";
        result += "Status:- ";
        result += confirmed ? "confirmed\n " : "Not confirmed\n";
        result += "Total Cost:- " + totlaCost() + " L.E \n";
        result += duration > 3 ? " Reward 15% Discount\n" : "";

        return result;

    }

}
