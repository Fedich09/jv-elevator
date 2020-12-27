import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {
    private static Building building;

    @BeforeAll
    static void beforeAll() {
        building = new Building();
    }

    @Test
    void passengersInBuilding_Ok() {
        int actual = building.getPassengersInBuilding();
        assertTrue(actual >= 0 && actual <= 200);
    }

    @Test
    void floorsInBuilding_Ok() {
        Floor[] actual = building.getArrayOfFloors();
        assertTrue(actual.length <= 20 && actual.length >= 5);
    }

    @Test
    void newBuilding_Ok() {
        Building newBuilding = new Building();
        int actualPassengers = newBuilding.getPassengersInBuilding();
        assertTrue(actualPassengers > 0 && actualPassengers < 200);
        Floor[] actualFloors = newBuilding.getArrayOfFloors();
        assertTrue(actualFloors.length >= 5 && actualFloors.length <= 20);
    }
}