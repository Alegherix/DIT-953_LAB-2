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


}