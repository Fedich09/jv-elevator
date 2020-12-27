import java.util.LinkedList;
import java.util.Queue;

public class Elevator implements RandomFloorsAndPassengers {
    private static int MAX_SEATS_IN_ELEVATOR = 5;
    private final Building building;
    private Queue<Passenger> queueInElevator;
    private int passengersInElevator;

    public Elevator() {
        queueInElevator = new LinkedList<>();
        passengersInElevator = 0;
        building = new Building();
    }

    public Queue<Passenger> getQueueInElevator() {
        return queueInElevator;
    }

    public void setQueueInElevator(Queue<Passenger> queueInElevator) {
        this.queueInElevator = queueInElevator;
    }

    public int getPassengersInElevator() {
        return passengersInElevator;
    }

    public void setPassengersInElevator(int passengersInElevator) {
        this.passengersInElevator = passengersInElevator;
    }

    public int getHighestFloorWherePassengerWantsRise(Queue<Passenger> passengerQueue) {
        int retFloor = -1;
        for (Passenger passengers : passengerQueue) {
            if (passengers.getFloor() > retFloor) {
                retFloor = passengers.getFloor();
            }
        }
        return retFloor;
    }

    public void loadElevator(int floor) {
        Queue<Passenger> passengerQueue = building.getArrayOfFloors()[floor].getQueue();
        while (getPassengersInElevator() != MAX_SEATS_IN_ELEVATOR
                && passengerQueue.peek() != null) {
            queueInElevator.add(passengerQueue.peek());
            passengerQueue.poll();
            building.getArrayOfFloors()[floor].setQueue(passengerQueue);
            setPassengersInElevator(queueInElevator.size());
            building.getArrayOfFloors()[floor].setPassengersOnFloor(building
                    .getArrayOfFloors()[floor].getPassengersOnFloor() - 1);
        }
    }

    public int unloadElevator(int floor) {
        Queue<Passenger> passengerQueue = getQueueInElevator();
        int retValue = 0;
        int counterIteration = 0;
        while (counterIteration != MAX_SEATS_IN_ELEVATOR && passengerQueue.peek() != null) {
            if (passengerQueue.peek().getFloor() == floor) {
                passengerQueue.poll();
                setQueueInElevator(passengerQueue);
                setPassengersInElevator(passengerQueue.size());
                retValue++;
            } else {
                passengerQueue.add(passengerQueue.peek());
                passengerQueue.poll();
            }
            counterIteration++;
        }
        return retValue;
    }

    public boolean didElevatorStillWorks() {
        System.out.println("I think, you wanna see the queues at the each floor");
        System.out.println(displayQueues());
        loadElevator(0);
        int newTheHighestFloor = getHighestFloorWherePassengerWantsRise(getQueueInElevator());
        if (newTheHighestFloor == -1) {
            newTheHighestFloor = 4;
        }
        int floorCounter = 0;
        int passengersInBuilding = building.getPassengersInBuilding();
        while (passengersInBuilding != 0) {
            if (!(getQueueInElevator().size() == 0)) {
                newTheHighestFloor = getHighestFloorWherePassengerWantsRise(getQueueInElevator());
            }
            if (getPassengersInElevator() > 0) {
                System.out.println(getWhoInElevator(getQueueInElevator(), floorCounter));
                passengersInBuilding -= unloadElevator(floorCounter);
            }
            if (getPassengersInElevator() < MAX_SEATS_IN_ELEVATOR) {
                loadElevator(floorCounter);
            }
            floorCounter++;
            if (floorCounter == newTheHighestFloor) {
                while (floorCounter != 0) {
                    if (getPassengersInElevator() > 0) {
                        System.out.println(getWhoInElevator(getQueueInElevator(), floorCounter));
                        passengersInBuilding -= unloadElevator(floorCounter);
                    }
                    if (getPassengersInElevator() < MAX_SEATS_IN_ELEVATOR) {
                        loadElevator(floorCounter);
                    }
                    floorCounter--;
                }
            }
        }
        System.out.println(getWhoInElevator(getQueueInElevator(), floorCounter)
                + ", People who in building - " + passengersInBuilding);
        return false;
    }

    public String displayQueues() {
        StringBuilder stringBuilder = new StringBuilder();
        Floor[] floors = building.getArrayOfFloors();
        for (int i = 0; i < floors.length; i++) {
            stringBuilder.append("[");
            for (Passenger passenger : floors[i].getQueue()) {
                stringBuilder.append(passenger.getFloor()).append(", ");
            }
            stringBuilder.append("]; ").append("Floor number: ")
                    .append(i).append(", People are waiting: ")
                    .append(floors[i].getQueue().size()).append("\n");
        }
        return stringBuilder.toString();
    }

    public String getWhoInElevator(Queue<Passenger> inElevator, int floor) {
        StringBuilder stringBuilder = new StringBuilder("Peoples who in elevator - ");
        if (inElevator.size() != 0) {
            for (Passenger passengers : inElevator) {
                stringBuilder.append(passengers.getFloor()).append(", ");
            }
        } else {
            stringBuilder.append("0, ");
        }
        stringBuilder.append("Floor - ").append(floor);
        return stringBuilder.toString();
    }
}
