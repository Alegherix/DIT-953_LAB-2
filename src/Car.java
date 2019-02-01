import java.awt.*;


public abstract class Car {

    /**
     * Offentliga variabler att användas utav båda bilarna
     */

    // Frågor
    // 1) Ska vi lägga till Variabler som representerar bilens Position?
    // 2) Vi ska bara ta in värden i intervallet 0-1, casta Exception

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name


    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        //Sänker hastigheten till Max värdet av x -> 0
        //Dvs vi kan ej gå under 0
        // Togs ifrån Volvos implementation

        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public boolean allowedVelocityChange(){
        return false;
    }

    private boolean acceptedValueRange(double amount){
        //return (amount<=1.0 && amount>=0.0)? true : throw new IllegalArgumentException("");
        if(amount<=1.0 && amount>=0.0){
            return true;
        }
        else{
            throw new IllegalArgumentException("Number must be in range of [0,1]");
        }
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if(acceptedValueRange(amount)){
            incrementSpeed(amount);
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if(acceptedValueRange(amount)){
            decrementSpeed(amount);
        }
    }

}
