package Lab03_MazeSolver;

public abstract class MazeSolver {

    private Maze maze;
    private boolean solved;

    public MazeSolver(Maze maze) {
        this.maze = maze;
        makeEmpty();
        add(maze.getStart());
    }

    public Maze getMaze() {
        return maze;
    }

    public abstract void makeEmpty();

    public abstract boolean isEmpty();

    public abstract void add(Square s);

    public abstract Square next();

    public boolean isSolved() {
        if (isEmpty() || solved) return true;
        return false;
    }

    public void step() {
        if (isEmpty()) return;

        Square current = next();

        if (current == maze.getExit()) {
            solved = true;
            return;
        }

        for (Square neighbor : maze.getNeighbors(current)) {
            if (neighbor.getType() != Square.WALL && neighbor.getStatus() != Square.EXPLORED) {
                add(neighbor);
                neighbor.setStatus(Square.WORKING);
            }
        }

        current.setStatus(Square.EXPLORED);
    }

    public String getPath() {
        if (isEmpty()) return "Maze is unsolvable";
        if (isSolved()) return "Maze is solved";
        return "Maze not solved";
    }

    public void solve() {
        while (!isSolved()) step();
    }
}
