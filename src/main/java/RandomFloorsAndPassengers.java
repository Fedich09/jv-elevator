public interface RandomFloorsAndPassengers {
    int MAX_FLOORS = 19;
    int MIN_FLOORS = 6;
    int MAX_PASSENGERS = 10;
    int MIN_PASSENGERS = 0;

    default int getRandomFloors() {
        return (int) (Math.random() * (MAX_FLOORS - MIN_FLOORS) + MIN_FLOORS);
    }

    default int getRandomPassengers() {
        return (int) (Math.random() * (MAX_PASSENGERS - MIN_PASSENGERS + 1) + MIN_PASSENGERS);
    }
}
