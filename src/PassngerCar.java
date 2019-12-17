
public class PassngerCar extends Car {

    private String color;
    private String passseat;

    public PassngerCar(String maker, String model, String year, String passseat, String color, String dialycost) {
        super(model, maker, year, dialycost);
        this.color = color;
        this.passseat = passseat;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPassseat() {
        return passseat;
    }

    public void setPassseat(String passseat) {
        this.passseat = passseat;
    }

    @Override
    public String toString() {
        return getMaker() + "  " + getModel() + "  " + getYear() + "  " + getDialycost() + "\t\t  " + passseat + "" + color;
    }

}
