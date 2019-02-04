import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void getNrDoors() {
        Car testVolvo = new Volvo240();
        Car testSaab = new Saab95();
        assertEquals(4, testVolvo.getNrDoors());
        assertEquals(2, testSaab.getNrDoors());
    }

    @Test
    public void maxSpeedVolvo(){
        Car testVolvo = new Volvo240();
        for(int i =0; i<= testVolvo.getEnginePower(); i++){
            testVolvo.gas(1);
        }
        assertEquals(testVolvo.getCurrentSpeed(), testVolvo.getEnginePower(), 0);
    }

    @Test
    public void maxSpeedSaab(){
        Car testSaab = new Saab95();
        for (int i = 0; i < testSaab.getEnginePower(); i++) {
            testSaab.gas(1);
        }
        assertEquals(testSaab.enginePower, testSaab.getEnginePower(), 0);
    }


    @Test
    public void testBrakesDoesntGoBelowZero(){
        Car testVolvo = new Volvo240();
        int testSpeed = 50;
        testVolvo.currentSpeed = testSpeed;
        for (int i = 0; i <= testSpeed+1; i++) {
            testVolvo.brake(1);
        }
        assertEquals(0, testVolvo.getCurrentSpeed(),0);
    }

    @Test
    public void testBrakeLowersSpeed(){
        Car testVolvo = new Volvo240();
        int testSpeed = 50;
        testVolvo.currentSpeed = testSpeed;
        testVolvo.brake(1);
        assertTrue(testSpeed>testVolvo.getCurrentSpeed());
    }

    @Test
    public void testCarMovement(){
        Car testCar = new Saab95();
        int randomNumber = ThreadLocalRandom.current().nextInt();
        testCar.currentSpeed = randomNumber;
        testCar.move();
        assertEquals(randomNumber, testCar.getPosition().getY(),0);
    }

    @Test
    public void testCarLeftTurnDirection(){
        Car testCar = new Volvo240();
        List<Direction> directionList = Arrays.asList(Direction.EAST, Direction.NORTH, Direction.WEST, Direction.SOUTH);
        for (int i = 0; i < directionList.size(); i++) {
            testCar.turnLeft();
            assertTrue(directionList.get(i).equals(testCar.getDirection()));
        }
    }

}