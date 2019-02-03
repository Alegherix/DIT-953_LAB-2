import java.awt.*;


/**
 *
 */
public abstract class Car implements Movable{

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

    /**
     * Sets the Color of the car
     * @param clr Color to set car to
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Starts the engine of the car
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Kills the engine of the car
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    /**
     * Increase the speed with a given amount
     * @param amount to increase speed by
     */
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Decrease the speed with a given amount
     * @param amount to decrease speed by
     */

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }


    /**
     * Returns a boolean if amount is in range of [0,1]
     * @param amount to check if in valid range
     * @return Wheter the value is in valid range
     */
    private boolean acceptedValueRange(double amount){
        //return (amount<=1.0 && amount>=0.0)? true : throw new IllegalArgumentException("");
        if(amount <= 1.0 && amount >= 0.0){
            return true;
        }
        else{
            throw new IllegalArgumentException("Number must be in range of [0,1]");
        }
    }


    /**
     * Increase the speed of the car by given argument, if argument is in allowed range
     * @param amount to increase the speed by
     */
    public void gas(double amount){
        if(acceptedValueRange(amount)){
            incrementSpeed(Math.abs(amount));
        }
    }

    /**
     * Lowers the cars speed by given argument, if argument is in allowed range
     * @param amount to lower the speed by
     */
    public void brake(double amount){
        if(acceptedValueRange(amount)){
            decrementSpeed(Math.abs(amount));
        }
    }


    /**
     * Move the car based on it's current speed
     */
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

    /**
     * Turns the car in an 90° angle towards the lefthand side
     */
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

    /**
     * Turns the car in an 90° angle towards the righthand side
     */
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
