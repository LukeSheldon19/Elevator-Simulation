public class ManualOperator {
    public static void main(String[] args) {
        // Initialize a building with five floors
        Building building = new Building(5);
        Elevator elevator = building.getElevator();
        // Add passengers to the top and bottom floors
        Floor bottom = building.getFloor(1);
        Floor top = building.getFloor(5);
        for (int i = 0; i < 5; i++) {
            bottom.add(new Passenger(5));
            top.add(new Passenger(1));
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 2; j <= 4; j++) {
                bottom.add(new Passenger(j));
                top.add(new Passenger(j));
            }
        }
        // Prompt the user to control the elevator
        StdOut.println("Options: (p)rint state, (a)scend, (d)escend, (l)oad, (u)nload");
        StdOut.print("> ");
        while (!StdIn.isEmpty()) {
            String operation = StdIn.readString();
            if (operation.equals("p")) {
                StdOut.print(building);
            }
            else if (operation.equals("a")) {
                try {
                    elevator.ascend();
                }
                catch (ElevatorException e) {
                    StdOut.println("Error: " + e.getMessage());
                }
            }
            else if (operation.equals("d")) {
                try {
                    elevator.descend();
                }
                catch (ElevatorException e) {
                    StdOut.println("Error: " + e.getMessage());
                }
            }
            else if (operation.equals("l")) {
                elevator.load();
            }
            else if (operation.equals("u")) {
                elevator.unload();
            }
            else {
                StdOut.println("Invalid operation.");
            }
            StdOut.print("> ");
        }
    }
}
