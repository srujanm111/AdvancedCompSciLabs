package Lab18_EmployeeDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Test {

    private static final boolean LINEAR_HASHING = true;
    private static final boolean GOOD_HASH = false;
    private static final double LOAD_FACTOR = 0.99;
    private static final int RECORDS_ADDED = 50000;
    private static final int TABLE_SIZE = (int) (RECORDS_ADDED / LOAD_FACTOR);

    public static void main(String[] args) {
        EmployeeDatabase database = new EmployeeDatabase(TABLE_SIZE);
        Scanner input = null;
        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab18_EmployeeDatabase/Large Data Set.txt"));
        } catch (FileNotFoundException e) {
        }

        Timer buildTableTimer = new Timer();
        while (input.hasNext()) {
            int id = input.nextInt();
            Employee employee = new Employee(input.nextLine());
            if (LINEAR_HASHING)
                database.putLinearProbe(GOOD_HASH, id, employee);
            else
                database.putQuadraticProbe(GOOD_HASH, id, employee);
        }
        buildTableTimer.stop();

        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab18_EmployeeDatabase/Successful Search Records.txt"));
        } catch (FileNotFoundException e) {
        }
        Timer successfulSearchTimer = new Timer();
        while (input.hasNext()) {
            int id = input.nextInt();
            input.nextLine();
            if (LINEAR_HASHING)
                database.getLinearProbe(successfulSearchTimer, GOOD_HASH, id);
            else
                database.getQuadraticProbe(successfulSearchTimer, GOOD_HASH, id);
        }
        successfulSearchTimer.stop();

        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab18_EmployeeDatabase/Unsuccessful Search Records.txt"));
        } catch (FileNotFoundException e) {
        }
        Timer unsuccessfulSearchTimer = new Timer();
        while (input.hasNext()) {
            int id = input.nextInt();
            input.nextLine();
            if (LINEAR_HASHING)
                database.getLinearProbe(unsuccessfulSearchTimer, GOOD_HASH, id);
            else
                database.getQuadraticProbe(unsuccessfulSearchTimer, GOOD_HASH, id);
        }
        unsuccessfulSearchTimer.stop();


        //print report

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab18_EmployeeDatabase/Test Report.txt"));
        } catch (FileNotFoundException e) {
        }

        writer.println("Type of Hashing Used: " + (LINEAR_HASHING ? "LINEAR PROBING" : "QUADRATIC PROBING"));
        writer.println("Quality of Hashing Function: " + (GOOD_HASH ? "GOOD" : "POOR"));
        writer.println("Number of Record Added: " + RECORDS_ADDED);
        writer.println("Table Size: " + TABLE_SIZE);
        writer.println("Load Factor: " + LOAD_FACTOR);
        writer.println("Average Insertion Time: " + ((double)buildTableTimer.time() / RECORDS_ADDED) + "ms");
        writer.println("Number of Table Insertion Collisions: " + database.collisionCounter);
        writer.println("Percentage of Collision: " + (((double)database.collisionCounter / RECORDS_ADDED) * 100) + "%");
        writer.println("Successful Search Records");
        writer.println("Average Search Time: " + ((double)successfulSearchTimer.time() / 1000) + "ms");
        writer.println("Number of Probes Needed: " + successfulSearchTimer.counter);
        writer.println("Unsuccessful Search Records");
        writer.println("Average Search Time: " + ((double)unsuccessfulSearchTimer.time() / 1000) + "ms");
        writer.println("Number of Probes Needed: " + unsuccessfulSearchTimer.counter);
        writer.close();
    }

    static class Timer {
        long startTime;
        long finishTime;
        int counter;

        public Timer() {
            startTime = System.currentTimeMillis();
        }

        public void stop() {
            finishTime = System.currentTimeMillis();
        }

        public long time() {
            return System.currentTimeMillis() - startTime;
        }
    }

}
