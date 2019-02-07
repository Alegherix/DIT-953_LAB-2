public class RegularCargo implements ICargo{

    private double currentAngle;
    public static final int LOWER_LIMIT = 0;
    public static final int UPPER_LIMIT = 70;

    public RegularCargo() {
        currentAngle = LOWER_LIMIT;
    }

    @Override
    public void lower(double amount) {
        if(currentAngle - amount <=0){
            currentAngle = 0;
        }
        else{
            currentAngle -= amount;
        }
    }

    @Override
    public void raise(double amount) {
        if(amount + currentAngle >=70){
            currentAngle = 70;
        }
        else{
            currentAngle += amount;
        }
    }

    public double getCurrentAngle() {
        return currentAngle;
    }
}
