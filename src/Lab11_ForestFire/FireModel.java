package Lab11_ForestFire;

public class FireModel {
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;

    public FireModel(FireView view) {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    public void recursiveFire() {
        myView.updateView(myGrid);
        for (int i = 0; i < myGrid[myGrid.length - 1].length; i++) {
            recursiveFireHelper(i, myGrid.length - 1);
        }
        for (int i = 0; i < myGrid[0].length; i++) {
            if (myGrid[0][i].getStatus() == FireCell.BURNING) {
                System.out.println("Onett is in trouble!");
                return;
            }
        }
        System.out.println("The town of Onett is safe.");
    }

    private void recursiveFireHelper(int x, int y) {
        if (x < 0 || y < 0 || x >= myGrid[0].length || y >= myGrid.length) return;
        if (myGrid[y][x].getStatus() == 1) myGrid[y][x].setStatus(FireCell.BURNING);
        else return;
        recursiveFireHelper(x + 1, y);
        recursiveFireHelper(x, y + 1);
        recursiveFireHelper(x - 1, y);
        recursiveFireHelper(x, y - 1);
    }

    public void solve() {
        recursiveFire();
    }

}
