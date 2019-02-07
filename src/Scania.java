import java.awt.*;

public class Scania extends Vehicle{

    // Frågor till Niklas
    // Är det rimligt att ha en Vehicle class som man Delegerar till via Composition?
    // Annars hur ska man använda ett builder pattern när man har en Abstract Class?
    // Om vi vill använda gas, så vill vi få ett felmeddelande
    // Problem -> Man kan kringå gas med denna lösningen, om man callar på truck.gas() istället för scania objektets gas.
    // Dock är den privat så man kan inte nå truck i detta fallet.
    // När jag Unloader så kan jag antigen returnera Vehicle via pop, och då blir andra fllet att jag returnerar null, alt en void funktion

    private RegularCargo cargo;
    //private Vehicle truck;
    public Scania(){
        this(Color.red);
    }


/*
    public Scania(Color color){
        truck = new VehicleBuilder()
                .constructBody(color, 2)
                .createEngine(250)
                .vehicleType(Vehicle.Type.TRUCK)
                .setDirection(Direction.SOUTH)
                .setModelName("Scania")
                .setPosition(new Position())
                .buildVehicle();
        cargo = new RegularCargo();
        truck.getEngine().stopEngine();
    }
    */

    public Scania(Color color){
        super(new Body(color, 2),
                new Engine(250),
                new Position(),
                Direction.SOUTH,
                "Scania",
                Type.TRUCK
                );
        cargo = new RegularCargo();
        getEngine().stopEngine();
    }


    public RegularCargo getCargo() {
        return cargo;
    }




    public void raiseCargo(double amount){
        if(!isMoving()){
            cargo.raise(amount);
        }
        else{
            throw new IllegalStateException("You need to stop moving before raising the cargo");
        }
    }

    public void lowerCargo(double amount){
        if(!isMoving()){
            cargo.lower(amount);
        }
        else{
            throw new IllegalStateException("You need to stop moving before lowering the cargo");
        }
    }


    @Override
    public void gas(double amount){
        if(cargo.getCurrentAngle() > 0){
            throw new IllegalStateException("You need to lower the cargo before moving");
        }
        else{
            super.gas(amount);
        }
    }

}
