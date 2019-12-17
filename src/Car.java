
public class Car {

    private String model;
    private String maker;
    private String year;
    private String dialycost;
   

    public Car(String model, String maker, String year, String dialycost) {
        this.model = model;
        this.maker = maker;
        this.year = year;
        this.dialycost = dialycost;
       
    }

    Car() {

    }

    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDialycost() {
        return dialycost;
    }

    public void setDialycost(String dialycost) {
        this.dialycost = dialycost;
    }

    

}
