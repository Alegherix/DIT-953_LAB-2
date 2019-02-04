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

    /**
     * Returns the speed factor of the Volvo240
     * @return the speed factor
     */
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }


}
