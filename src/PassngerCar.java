
public class PassngerCar extends Car {

    private String car;
    

    public PassngerCar(String car,String cost) {
         super(cost);
        this.car = car;
        
    }

    
    @Override
    public String toString() {
        return car;
    }

}
