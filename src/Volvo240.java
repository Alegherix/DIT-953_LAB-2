import java.awt.*;

public class Volvo240 extends Car implements Movable{

    public static final double trimFactor = 1.25;

    
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
        // Sätter Hastigheten till Minsta värdet ifrån x -> 100
        // Dvs vi kan ej gå över 100
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }


    @Override
    public void move() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }
}
