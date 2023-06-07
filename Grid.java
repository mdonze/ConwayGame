public class Grid {
    private int width;
    private int height;
    private boolean[][] cells;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new boolean[height][width];

    }

    public void nextGeneration() {
        boolean[][] nextCells = new boolean[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int liveNeighbors = countLiveNeighbors(y, x);

                if (cells[y][x]) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        // The cell dies
                        nextCells[y][x] = false;
                    } else {
                        // The cell lives
                        nextCells[y][x] = true;
                    }
                } else {
                    // The cell is dead
                    if (liveNeighbors == 3) {
                        // The cell becomes alive
                        nextCells[y][x] = true;
                    } else {
                        // The cell stays dead
                        nextCells[y][x] = false;
                    }
                }

            }
        }
        cells = nextCells;
    }

    private int countLiveNeighbors(int y, int x) {
        int liveNeighbors = 0;
        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                // Skip the cell itself
                if (dy == 0 && dx == 0) {
                    continue;
                }

                int newY = y + dy;
                int newX = x + dx;

                // Check that the neighbor's coordinates are within the grid
                if (newY >= 0 && newY < height && newX >= 0 && newX < width) {
                    // If the neighbo is alive, add 1 to the count
                    if (cells[newY][newX]) {
                        liveNeighbors++;
                    }

                }
            }
        }
        return liveNeighbors;

    }

    public void display() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (cells[y][x]) {
                    System.out.print("O");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        
    }

    public void initialize(boolean[][] initialPattern) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y < initialPattern.length && x < initialPattern[y].length) {
                    cells[y][x] = initialPattern[y][x];
                } else {
                    cells[y][x] = false;
                }
            }
        }
    }
}