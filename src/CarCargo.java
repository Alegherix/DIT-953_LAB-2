import java.util.Stack;


public class CarCargo implements ICargo{

    enum CargoState{
        UP, DOWN
    }

    public final int LIMIT = 10;
    private Stack<Vehicle> cars;
    private CargoState cargoState;

    public CarCargo() {
        cars = new Stack<>();
        cargoState = CargoState.UP;
    }

    public void updateCargoPosition(Position position){
        for(Vehicle car : cars){
            car.setPosition(position);
        }
    }

    public Vehicle unload(){
        return cars.pop();
    }

    public void load(Vehicle vehicle){
       cars.push(vehicle);
    }

    public boolean loadable(Vehicle vehicle){
        return withinRange() && loadingProperly(vehicle) && shouldBeDown()  ;
    }


    public boolean withinRange(){
        if(cars.size() < LIMIT){
            return true;
        }
        else{
            throw new IllegalStateException("The cargo is already fully stacked");
        }
    }

    public boolean loadingProperly(Vehicle vehicle){
        if(vehicle.getType().equals(Vehicle.Type.CAR)){
            return true;
        }
        else{
            throw new IllegalArgumentException("You can only load cars onto this Cargo");
        }
    }

    public boolean shouldBeDown(){
        if(!stateIsDown()){
            throw new IllegalStateException("You need to lower the cargo before trying to load");
        }
        else{
            return true;
        }
    }

    public boolean stateIsDown(){
        return cargoState.equals(CargoState.DOWN);
    }

    public Stack<Vehicle> getCars() {
        return cars;
    }

    @Override
    public void lower() {
        cargoState = CargoState.DOWN;
    }

    @Override
    public void raise() {
        cargoState = CargoState.UP;
    }

}
