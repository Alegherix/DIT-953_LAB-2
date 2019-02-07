import java.util.Stack;


public class CarCargo {

    enum CargoState{
        UP, DOWN
    }

    public final int LIMIT = 10;
    private Stack<Vehicle> cars;
    private CargoState cargoState;
    private Position position;

    public CarCargo() {
        cars = new Stack<>();
        cargoState = CargoState.UP;
        position = new Position();
    }

    public void updateCargoPosition(Position position){
        for(Vehicle car : cars){
            car.setPosition(position);
        }
    }


    public Vehicle unloadCargo(){
        return (canBeUnloaded())? cars.pop() : null;
    }

    public void loadCarOntoCargo(Vehicle vehicle){
        if(vehicle.getType().equals(Vehicle.Type.TRUCK)){
            throw new IllegalArgumentException("You can only load cars onto this cargo");
        }
        else{
            cars.push(vehicle);
        }
    }

    public boolean canBeUnloaded(){
        return cargoState.equals(CargoState.DOWN);
    }

    public Stack<Vehicle> getCars() {
        return cars;
    }

}
