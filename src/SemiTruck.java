public class SemiTruck extends Vehicle {


    private CarCargo cargo;

    public boolean canLoadCarCargo(){
        return !isMoving() && cargo.getCars().size() <= cargo.LIMIT;
    }

    /**
     * Drives the SemiTruck and updates the position of the cargo to that of the truck
     */
    @Override
    public void move() {
        super.move();
        cargo.updateCargoPosition(getPosition());
    }

    /**
     * Used to decide what position the cargo should have when unloading
     * @return Position of cargo
     */
    private Position decideCargoPositionWhenUnloading(){
        double xPosition = 0;
        double yPos = 0;

        switch (getDirection()){
            case NORTH:
                xPosition = getPosition().getY() - 1;
                yPos = getPosition().getY();
                break;
            case SOUTH:
                xPosition = getPosition().getY() + 1;
                yPos = getPosition().getY();
                break;
            case EAST:
                yPos = getPosition().getX() - 1;
                xPosition = getPosition().getX();
                break;
            case WEST:
                yPos = getPosition().getX() + 1;
                xPosition = getPosition().getX();
                break;
        }
        return new Position(xPosition, yPos);
    }
}
