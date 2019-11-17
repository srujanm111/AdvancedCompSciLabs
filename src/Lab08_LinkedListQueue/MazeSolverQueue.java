package Lab08_LinkedListQueue;

import Lab03_MazeSolver.Maze;
import Lab03_MazeSolver.MazeSolver;
import Lab03_MazeSolver.Square;

public class MazeSolverQueue extends MazeSolver {

    MyQueue<Square> queue;

    public MazeSolverQueue(Maze maze) {
        super(maze);
    }

    @Override
    public void makeEmpty() {
        queue = new MyQueue<>();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void add(Square s) {
        queue.offer(s);
    }

    @Override
    public Square next() {
        return queue.poll();
    }

}
