import java.awt.*;

public class Volvo240 extends Vehicle implements ICar{

    public static final double trimFactor = 1.25;


    public Volvo240(){
        this(Color.black);
    }

    public Volvo240(Color color){
        super(new Body(color, 4), new Engine(100), "Volvo240");
        getEngine().stopEngine();
    }


    /**
     * Returns the speed factor of the Volvo240
     * @return the speed factor
     */
    public double speedFactor(){
        return getEngine().getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public Color getColor() {
        return getBody().getColor();
    }
}
