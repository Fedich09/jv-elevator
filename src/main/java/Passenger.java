import java.util.Objects;

public class Passenger implements RandomFloorsAndPassengers {
    private static int MIN_FLOOR = 5;
    private final int floorWhichPassengerRise;

    public Passenger(int amountOfFloors) {
        floorWhichPassengerRise = (int) (Math.random()
                * (amountOfFloors - MIN_FLOOR) + MIN_FLOOR);
    }

    public int getFloor() {
        return floorWhichPassengerRise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Passenger passenger = (Passenger) o;
        return floorWhichPassengerRise == passenger.floorWhichPassengerRise;
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorWhichPassengerRise);
    }
}
