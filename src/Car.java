import java.awt.*;


/**
 *
 */
public abstract class Car extends Vehicle{

    public Car() {
    }

    public Car(String modelName) {
        super(modelName);
    }

    public Car(Body body, Engine engine, String modelName) {
        super(body, engine, modelName);
    }
}
