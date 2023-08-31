public class Elevator {
    // TODO Add appropriate instance variables

    private Stack<Passenger> s;
    private Floor[] floors;
    private int capacity;

    private int current_floor = 1;

    //instance variable for current?

    /**
     * @param floors   the floors the elevator can travel to
     * @param capacity the maximum capacity of the elevator
     */

    //raises exception if floors contains an invalid floor
    public Elevator(Floor[] floors, int capacity) {
        // TODO Complete this method
        s = new Stack<Passenger>();

        this.floors = floors;
        this.capacity = capacity;

    }

    /**
     * @return the current location of the elevator
     */
    public int getLocation() {
        // TODO Complete this method
        return current_floor;
    }

    /**
     * Ascend one floor.
     *
     * @throws ElevatorException if you try to ascend to a non-existent floor
     */
    public void ascend() throws ElevatorException {
        // TODO Complete this method
        //if location less than length of floors array

        if (current_floor < floors.length) {
            current_floor++;
        }
        else {
            throw new ElevatorException("You are already on the fifth floor");
        }
    }

    /**
     * Descend one floor.
     *
     * @throws ElevatorException if you try to descend to a non-existent floor
     */
    public void descend() throws ElevatorException {
        // TODO Complete this method

        //is location greater than 1
        if (current_floor > 1) {
            current_floor--;
        }
        else {
            throw new ElevatorException("You are already on the first floor");
        }
    }

    /**
     * Load the elevator with as many passengers as will fit from the current floor.
     */
    public void load() {
        // TODO Complete this method

        int count = 0;

        Floor f = floors[current_floor - 1];

        while (s.size() < capacity && f.waiting() > 0) {
            s.push(f.remove());


        }
    }

    /**
     * Unload all the passengers who want to disembark on the current floor.
     * <p>
     * Passengers who aren't disembarking should maintain the same relative order within the
     * elevator.
     *
     * @return the passengers who disembarked on this floor, in the order they disembarked
     */
    public Iterable<Passenger> unload() {
        // TODO Complete this method

        Queue<Passenger> exiting = new Queue<Passenger>();
        Stack<Passenger> staying = new Stack<Passenger>();

        while (!s.isEmpty()) {
            Passenger p = s.pop();
            if (p.getDestination() == current_floor) {
                exiting.enqueue(p);
            }
            else {
                staying.push(p);

            }

        }
        while (!staying.isEmpty()) {
            s.push(staying.pop());
        }

        return exiting;

    }

    public String toString() {
        return s.toString();
    }

    public static void main(String[] args) {

    }
}
