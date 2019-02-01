import java.awt.*;

public class Volvo240 extends Car{

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

    public void decrementSpeed(double amount){
        //Sänker hastigheten till Max värdet av x -> 0
        //Dvs vi kan ej gå under 0
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
