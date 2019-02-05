public class Cargo {

    private double currentAngle;


    public Cargo() {
        currentAngle = 0;
    }

    public void lowerCargo(double amount){
        if(amount - currentAngle <=0){
            currentAngle = 0;
        }
        else{
            currentAngle -= amount;
        }
    }


    public void raiseCargo(double amount){
        if(amount + currentAngle >=70){
            currentAngle = 70;
        }
        else{
            currentAngle += amount;
        }
    }

}
