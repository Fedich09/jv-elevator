public class Building implements RandomFloorsAndPassengers {
    private final Floor[] arrayOfFloors;
    private int passengersInBuilding;

    public Building() {
        int amountOfFloors = getRandomFloors();
        arrayOfFloors = new Floor[amountOfFloors];
        for (int i = 0; i < arrayOfFloors.length; i++) {
            arrayOfFloors[i] = new Floor(amountOfFloors);
            passengersInBuilding += arrayOfFloors[i].getPassengersOnFloor();
        }
    }

    public int getPassengersInBuilding() {
        return passengersInBuilding;
    }

    public Floor[] getArrayOfFloors() {
        return arrayOfFloors;
    }
}
