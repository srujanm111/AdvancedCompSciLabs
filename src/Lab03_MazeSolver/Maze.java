package Lab03_MazeSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Maze {

    private Square[][] grid;
    private Square start;
    private Square exit;

    public Maze() {
        loadMaze("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab03_MazeSolver/maze-2");
    }

    public boolean loadMaze(String fileName) {
        Scanner input = null;
        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect File Location");
            return false;
        }

        int r1 = input.nextInt();
        int c1 = input.nextInt();

        grid = new Square[r1][c1];

        for (int r = 0; r < r1; r++) {
            for (int c = 0; c < c1; c++) {
                grid[r][c] = new Square(r, c, input.nextInt());
                if (grid[r][c].getType() == Square.START) start = grid[r][c];
                else if (grid[r][c].getType() == Square.EXIT) exit = grid[r][c];
            }
        }

        return true;
    }

    public List<Square> getNeighbors(Square s) {
        List<Square> neighbors = new ArrayList<>();
        if (s.getRow() > 0 && grid[s.getRow() - 1][s.getCol()] != null) neighbors.add(grid[s.getRow() - 1][s.getCol()]);
        if (s.getCol() < grid[s.getRow()].length - 1 && grid[s.getRow()][s.getCol() + 1] != null)
            neighbors.add(grid[s.getRow()][s.getCol() + 1]);
        if (s.getRow() < grid.length - 1 && grid[s.getRow() + 1][s.getCol()] != null)
            neighbors.add(grid[s.getRow() + 1][s.getCol()]);
        if (s.getCol() > 0 && grid[s.getRow()][s.getCol() - 1] != null) neighbors.add(grid[s.getRow()][s.getCol() - 1]);
        return neighbors;
    }

    public Square getStart() {
        return start;
    }

    public Square getExit() {
        return exit;
    }

    public void reset() {
        for (Square[] squares : grid) {
            for (Square square : squares) {
                square.reset();
            }
        }
    }

    @Override
    public String toString() {
        String map = "";
        for (Square[] squares : grid) {
            for (Square square : squares) {
                map += square.toString();
            }
            map += "\n";
        }
        return map;
    }
}
