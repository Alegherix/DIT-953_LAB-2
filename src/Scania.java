import java.awt.*;

public class Scania extends Vehicle {

    private Cargo cargo;

    public Scania(){
        this(Color.red);
    }

    public Scania(Color color){
        super(new Body(color, 4), new Engine(250), "Scania");
        this.cargo = new Cargo();
        getEngine().stopEngine();
    }

    public boolean canTiltCargo(){
        return getEngine().getCurrentSpeed()<=0;
    }

    public void updatePositionOfCargo(){

    }

}
