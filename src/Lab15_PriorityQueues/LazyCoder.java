package Lab15_PriorityQueues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LazyCoder {

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab15_PriorityQueues/goat.dat"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int cases = input.nextInt();
        for (int c = 0; c < cases; c++) {
            int nContracts = input.nextInt();
            for (int n = 0; n < nContracts; n++) {

            }
        }
    }

    private static class Contract implements Comparable<Contract> {
        int a, b, d;

        public Contract(int a, int b, int d) {
            this.a = a;
            this.b = b;
            this.d = d;
        }

        @Override
        public int compareTo(Contract o) {
            return 0;
        }
    }

}
