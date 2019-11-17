package Lab03_MazeSolver;

public class MazeSolverStack extends MazeSolver {

    SquareStack stack;

    public MazeSolverStack(Maze maze) {
        super(maze);
    }

    @Override
    public void makeEmpty() {
        stack = new SquareStack();
    }

    @Override
    public boolean isEmpty() {
        return stack.size == 0;
    }

    @Override
    public void add(Square s) {
        stack.push(s);
    }

    @Override
    public Square next() {
        return stack.pop();
    }
}
