import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorTest {
    private static Elevator elevator;

    @BeforeEach
    void setUp() {
        elevator = new Elevator();
    }

    @Test
    void newElevator_Ok() {
        assertEquals(elevator.getPassengersInElevator(), 0);
        assertEquals(elevator.getQueueInElevator().size(), 0);
    }

    @Test
    void getAndSetQueueInElevator_Ok() {
        Queue<Passenger> passengerQueue = new LinkedList<>();
        passengerQueue.add(new Passenger(5));
        elevator.setQueueInElevator(passengerQueue);
        assertTrue(elevator.getQueueInElevator().size() != 0);
    }

    @Test
    void getAndSetPassengersInElevator() {
        int passengersInElevator = elevator.getPassengersInElevator();
        assertTrue(passengersInElevator == 0);
        elevator.setPassengersInElevator(5);
        passengersInElevator = elevator.getPassengersInElevator();
        assertTrue(passengersInElevator != 0);
    }

    @Test
    void getHighestFloorWherePassengerWantsRise_Ok() {
        Queue<Passenger> passengerQueue = new LinkedList<>();
        passengerQueue.add(new Passenger(4));
        assertEquals(elevator.getHighestFloorWherePassengerWantsRise(passengerQueue), 4);
    }

    @Test
    void loadElevator_Ok() {
        elevator.loadElevator(0);
        assertTrue(elevator.getPassengersInElevator() > 0);
    }

    @Test
    void unloadElevator_Ok() {
        for (int i = 0; i < elevator.getHighestFloorWherePassengerWantsRise(elevator.getQueueInElevator()); i++) {
            elevator.unloadElevator(i);
        }
        assertEquals(elevator.getPassengersInElevator(), 0);
    }

    @Test
    void elevatorStillWork_Ok() {
        assertFalse(elevator.didElevatorStillWorks());
    }
}