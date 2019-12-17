
public class SportCars extends Car {

    private String color;
    private int enginesize;

    public SportCars(String maker, String model, String year, int enginesize, String color, String dialycost) {
        super(model, maker, year, dialycost);
        this.color = color;
        this.enginesize = enginesize;
    }

    public int getEnginesize() {
        return enginesize;
    }

    public void setEnginesize(int enginesize) {
        this.enginesize = enginesize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {

        return getMaker() + "\t" + getModel() + "\t" + getYear() + "\t" + getDialycost() + "\t" + enginesize + "cc\t" + color;
    }

}
