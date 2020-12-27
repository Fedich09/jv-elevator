import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {
    private static Floor floor;

    @BeforeAll
    static void beforeAll() {
        floor = new Floor(5);
    }

    @Test
    void newFloor_Ok() {
        Floor newFloor = new Floor(5);
        int actualPassengersOnFloor = newFloor.getPassengersOnFloor();
        assertTrue(actualPassengersOnFloor >= 0 && actualPassengersOnFloor <= 10);
        int actualQueueSize = newFloor.getQueue().size();
        assertTrue(actualQueueSize <= 10);
    }

    @Test
    void getQueueAndSetQueue_Ok() {
        Queue<Passenger> passengerQueue = floor.getQueue();
        passengerQueue.poll();
        floor.setQueue(passengerQueue);
        assertEquals(floor.getQueue(), passengerQueue);
    }

    @Test
    void getAndSetPassengerOnFloor_Ok() {
        floor.setPassengersOnFloor(5);
        int actualPassengersOnFloor = floor.getPassengersOnFloor();
        assertEquals(actualPassengersOnFloor, floor.getPassengersOnFloor());
    }
}