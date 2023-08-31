public class Passenger {
    private Integer destination;

    public Passenger(int destination) {
        this.destination = destination;
    }

    public String toString() {
        return destination.toString();
    }

    public Integer getDestination() {
        return destination;
    }

    public static void main(String[] args) {
        StdOut.println(new Passenger(1));
    }
}
