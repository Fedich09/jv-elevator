import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {
    private static Passenger passenger;

    @BeforeAll
    static void beforeAll() {
        passenger = new Passenger(5);
    }

    @Test
    void newPassenger_Ok() {
        Passenger newPassenger = new Passenger(5);
        int floorWhichPassengerRise = newPassenger.getFloor();
        assertTrue(floorWhichPassengerRise <= 19 && floorWhichPassengerRise >= 4);
    }

    @Test
    void getFloor_Ok() {
        int floor = passenger.getFloor();
        assertTrue(floor >= 4 && floor <= 19);
    }

    @Test
    void equals_Ok() {
        assertTrue(passenger.equals(passenger));
    }

    @Test
    void hashcode_Ok() {
        int hash = passenger.hashCode();
        assertEquals(passenger.hashCode(), hash);
    }
}