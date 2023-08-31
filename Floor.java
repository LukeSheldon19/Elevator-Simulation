public class Floor {

    //Queue!!!!!

    // TODO Add appropriate instance variables

    private Queue<Passenger> q;

    public Floor() {
        // TODO Complete this method
        q = new Queue<Passenger>();
    }//construct new queue

    /**
     * Add this passenger to the back of the line for the elevator.
     *
     * @param passenger a passenger waiting for the elevator
     */
    public void add(Passenger passenger) {
        // TODO Complete this method

        q.enqueue(passenger);

    }

    /**
     * Remove this passenger from the front of the line, so they can board the elevator
     *
     * @return the passenger from the front of the line
     */
    public Passenger remove() {
        // TODO Complete this method

        Passenger f_in_l = q.dequeue();

        return f_in_l;
    }

    /**
     * @return the number of passengers waiting for the elevator on this floor
     */
    public int waiting() {
        // TODO Complete this method

        int x = q.size();
        return x;
    }

    public String toString() {
        return q.toString();
    }

    public static void main(String[] args) {

    }
}
