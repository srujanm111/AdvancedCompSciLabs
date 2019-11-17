package Lab15_PriorityQueues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rooms {

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab15_PriorityQueues/rooms.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int cases = input.nextInt();
        for (int i = 0; i < cases; i++) {
            int numGuests = input.nextInt();
            Guest[] guests = new Guest[numGuests];
            for (int i1 = 0; i1 < numGuests; i1++) {
                guests[i1] = new Guest(input.nextInt());
            }
            for (int i1 = 0; i1 < numGuests; i1++) {
                guests[i1].duration = input.nextInt();
            }


        }
    }

    private static class Guest implements Comparable<Guest> {

        int arrivalTime;
        int duration;

        public Guest(int arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        @Override
        public int compareTo(Guest o) {
            int dif = arrivalTime - o.arrivalTime;
            if (dif == 0) dif = duration - o.duration;
            return dif;
        }
    }

}
