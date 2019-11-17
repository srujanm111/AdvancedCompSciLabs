package Lab23_Thievery;

import java.util.Objects;

public class Pascal {

    public static void main(String[] args) {
        for (int r = 0; r < 40; r++) {
            for (int c = 0; c <= r; c++) {
                System.out.print(pascal(r, c) + " ");
            }
            System.out.println();
        }
    }

    public static int pascal(int row, int col) {
        if (row < 0 || col < 0 || row < col)
            return 0;
        if (row == 0)
            return 1;

        return pascal(row - 1, col) + pascal(row - 1, col - 1);
    }

    private static class Pair {

        int r, c;
        int val;

        public Pair(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return r == pair.r && c == pair.c && val == pair.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c, val);
        }
    }

}

