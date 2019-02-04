import java.awt.*;

public class Saab95 extends Car implements Movable{

    public boolean turboOn;

    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    /**
     * Sets the turbo of the car to on
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Sets the turbo of the car off.
     */
    public void setTurboOff(){
	    turboOn = false;
    }


    /**
     * Returns the speed factor of the Saab95
     * @return the speed factor
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

}
