package Lab18_EmployeeDatabase;

public class Practice {

    private static final int TABLE_SIZE = 11;

    public static void main(String[] args) {
        int[] keys = {10, 100, 32, 45, 58, 126, 1, 29, 200, 400, 15};
        for (int key : keys) {
            System.out.println(hash(key));
        }
    }

    // O(1) retrieval time
    // O(n)
    // True: All equals() => true objects should have the same hash code
    // False: All objects with the same hash code should be equals() => true

    private static int hash(int key) {
        return (key + key / 2) % TABLE_SIZE;
    }

}
