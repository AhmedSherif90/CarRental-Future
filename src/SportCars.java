
public class SportCars extends Car {
    private String car;
    public SportCars(String car, String cost) {
        super(cost);
        this.car = car;
    }
    @Override
    public String toString() {

        return car;
    }

}
