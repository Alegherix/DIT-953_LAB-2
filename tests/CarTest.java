import org.junit.Test;

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
    public void testBrakes(){
        Car testVolvo = new Volvo240();
        int testSpeed = 50;
        testVolvo.currentSpeed = testSpeed;
        for (int i = 0; i <= testSpeed; i++) {
            testVolvo.brake(1);
        }
        assertEquals(0, testVolvo.getCurrentSpeed(),0);
    }

}