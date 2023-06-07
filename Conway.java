public class Conway {
    public static void main(String[] args) {
        Grid grid = new Grid(5, 5);

        boolean[][] startingPattern = {
            {false, false, false, false, false},
            {false, false, true, false, false},
            {false, false, true, false, false},
            {false, false, true, false, false},
            {false, false, false, false, false}
        };
        grid.initialize(startingPattern);
        grid.display();

        for (int i = 0; i < 10; i++) {
            System.out.println("Generation " + i);
            grid.nextGeneration();
            grid.display();
        }
    }
}