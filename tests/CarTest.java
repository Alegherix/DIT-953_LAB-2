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

    public void maxSpeedVolvo(){
        Car testVolvo = new Volvo240();
        for(int i =0; i<= testVolvo.getEnginePower(); i++){
            testVolvo.gas(1);
        }
        assertEquals(testVolvo.getCurrentSpeed(), testVolvo.getEnginePower(), 0);
    }

    public void maxSpeedSaab(){
        Car testSaab = new Saab95();
        for (int i = 0; i < testSaab.getEnginePower(); i++) {
            testSaab.gas(1);
        }
        assertEquals(testSaab.enginePower, testSaab.getEnginePower(), 0);
    }


}