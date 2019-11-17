package Lab19_PhoneBook;

public class PhoneBook implements IMap {

    public static int dbSize;

    private Entry[] entries;
    private int size;

    public PhoneBook(int size) {
        entries = new Entry[size];
        dbSize = size;
    }

    @Override
    public PhoneNumber put(Person person, PhoneNumber phone) {
        int index = person.hashCode();
        if (entries[index] == null){
            entries[index] = new Entry(person, phone);
            return null;
        }
        else
            entries[index].next = new Entry(person, phone);

        return null;
    }

    @Override
    public PhoneNumber get(Person person) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public PhoneNumber remove(Person person) {
        return null;
    }

    private class Entry {
        Person person;
        PhoneNumber number;
        Entry next;

        public Entry(Person person, PhoneNumber number) {
            this.person = person;
            this.number = number;
        }
    }
}
