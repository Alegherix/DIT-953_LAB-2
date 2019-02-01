import java.awt.*;


public abstract class Car implements Movable{

    /**
     * Offentliga variabler att användas utav båda bilarna
     */

    // Frågor
    // 1) Ska vi lägga till Variabler som representerar bilens Position?
    // 2) Varför klagar compilern om jag returnerar Exception i ena fallet men ej andra
            // 3) Interface eller Abstract class


    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    private Direction direction;
    private Position position;

    public Car() {
        direction = Direction.SOUTH;
        position = new Position();
    }

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

    public boolean inAllowedVelocityRange(){
        return currentSpeed >=0 && currentSpeed <= enginePower;
    }

    public void capVelocity(){
        // Used when !inAllowedVelocityRange
        if(currentSpeed > enginePower){
            currentSpeed = enginePower;
        }
        else{
            currentSpeed = 0;
        }
    }

    private boolean acceptedValueRange(double amount){
        //return (amount<=1.0 && amount>=0.0)? true : throw new IllegalArgumentException("");
        if(amount <= 1.0 && amount >= 0.0){
            return true;
        }
        else{
            throw new IllegalArgumentException("Number must be in range of [0,1]");
        }
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        // Used for increasing speed of abs of amount, so no negative increasing
        if(acceptedValueRange(amount)){
            incrementSpeed(Math.abs(amount));
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if(acceptedValueRange(amount)){
            decrementSpeed(Math.abs(amount));
        }
    }

    @Override
    public void move() {
        switch (direction){
            case SOUTH:
                position.setY(position.getY() + currentSpeed);
                break;
            case NORTH:
                position.setY(position.getY() - currentSpeed);
                break;
            case WEST:
                position.setX(position.getX() - currentSpeed);
                break;
            case EAST:
                position.setX(position.getX() + currentSpeed);
        }
    }

    @Override
    public void turnLeft() {
        switch (direction){
            case EAST:
                direction = Direction.NORTH;
                break;
            case NORTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
        }
    }

    @Override
    public void turnRight() {
        switch (direction){
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
            case NORTH:
                direction = Direction.EAST;
        }
    }
}
