package Lab18_EmployeeDatabase;

public class EmployeeDatabase {

    public int collisionCounter = 0;

    Entry[] entries;

    public EmployeeDatabase(int size) {
        entries = new Entry[size];
    }

    public int goodHashCode(int key) {
        return  (int)(key*2654435761L & (entries.length - 1));
    }

    public int poorHashCode(int key) {
        return key % entries.length;
    }

    public void putLinearProbe(boolean goodHash, int key, Employee value) {
        int index = goodHash ? goodHashCode(key) : poorHashCode(key);
        while (entries[index] != null) {
            index++;
            collisionCounter++;
        }
        entries[index] = new Entry(key, value);
    }

    public Employee getLinearProbe(Test.Timer counter, boolean goodHash, int key) {
        int index = goodHash ? goodHashCode(key) : poorHashCode(key);
        while (entries[index] == null || entries[index].ID != key) {
            index++;
            counter.counter++;
            if (index == entries.length) return null;
        }
        return entries[index].employee;
    }

    public void putQuadraticProbe(boolean goodHash, int key, Employee value) {
        int index = goodHash ? goodHashCode(key) : poorHashCode(key);
        int i = 1;
        while (entries[index] != null) {
            index += (i*i);
            i++;
            collisionCounter++;
        }
        entries[index] = new Entry(key, value);
    }

    public Employee getQuadraticProbe(Test.Timer counter, boolean goodHash, int key) {
        int index = goodHash ? goodHashCode(key) : poorHashCode(key);
        int i = 1;
        while (entries[index] == null || entries[index].ID != key) {
            index += (i*i);
            i++;
            counter.counter++;
            if (index == entries.length) return null;
        }
        return entries[index].employee;
    }

    private class Entry {
        int ID;
        Employee employee;

        public Entry(int ID, Employee employee) {
            this.ID = ID;
            this.employee = employee;
        }

        @Override
        public String toString() {
            return ID + ": " + employee.toString();
        }
    }

}
