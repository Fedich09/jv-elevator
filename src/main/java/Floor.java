import java.util.LinkedList;
import java.util.Queue;

public class Floor implements RandomFloorsAndPassengers {
    private Queue<Passenger> queue;
    private int passengersOnFloor;

    public Floor(int amountOfFloors) {
        queue = new LinkedList<>();
        int randomPassengers = getRandomPassengers();
        while (randomPassengers != 0) {
            queue.add(new Passenger(amountOfFloors));
            passengersOnFloor++;
            randomPassengers--;
        }
    }

    public Queue<Passenger> getQueue() {
        return queue;
    }

    public int getPassengersOnFloor() {
        return passengersOnFloor;
    }

    public void setQueue(Queue<Passenger> queue) {
        this.queue = queue;
    }

    public void setPassengersOnFloor(int passengersOnFloor) {
        this.passengersOnFloor = passengersOnFloor;
    }
}
