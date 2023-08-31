public class Building {
    private Floor[] floors;
    private Elevator elevator;

    public Building(int height) {
        floors = new Floor[height];
        for (int i = 0; i < height; i++) {
            floors[i] = new Floor();
        }
        elevator = new Elevator(floors, 10);
    }

    public int getHeight() {
        return floors.length;
    }

    public Floor getFloor(int i) {
        return floors[i - 1];
    }

    public Elevator getElevator() {
        return elevator;
    }

    public String toString() {
        String visualization = "";
        for (int i = getHeight(); i > 0; i--) {
            visualization += i;
            if (elevator.getLocation() == i) {
                visualization += " E ";
            }
            else {
                visualization += "   ";
            }
            visualization += getFloor(i) + "\n";
        }
        visualization += "Elevator: " + elevator + "\n";
        return visualization;
    }

    public static void main(String[] args) {

    }
}
