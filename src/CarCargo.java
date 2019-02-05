import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CarCargo {

    private CargoPlacement cargoPlacement;
    Stack<ICar> cars;


    public CarCargo() {
        cargoPlacement = CargoPlacement.DOWN;
        cars = new Stack<>();
    }

    enum CargoPlacement{
        UP, DOWN
    }

    public CargoPlacement getCargoPlacement() {
        return cargoPlacement;
    }

    public Stack<ICar> getCars() {
        return cars;
    }

    boolean tiltable(SemiTruck semiTruck){
        return semiTruck.getEngine().getCurrentSpeed()<=0;
    }

    // Och om bilarna är rimligt nära.
    boolean loadable(){
        return cargoPlacement.equals(CargoPlacement.DOWN);
    }

    public boolean unloadable(){
        return cargoPlacement.equals(CargoPlacement.DOWN);
    }

    public void unloadCargo(){
        cars.pop();
    }

    public void updateCargoPosition(Position position){
        for(ICar car : cars){

        }
    }

}
