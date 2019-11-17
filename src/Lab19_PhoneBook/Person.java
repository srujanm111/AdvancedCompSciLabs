package Lab19_PhoneBook;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int folds = name.length() / 4;
        long sum = 0;
        for (int i = 0; i < folds; i++) {
            char[] group = name.substring(i * 4, i * 4 + 4).toCharArray();
            long multiplier = 1;
            for (char c : group) {
                sum += c * multiplier;
                multiplier *= 256;
            }
        }

        char[] excess = name.substring(folds * 4).toCharArray();
        long multiplier = 1;
        for (char c : excess) {
            sum += c * multiplier;
            multiplier *= 256;
        }

        return (int)(sum % PhoneBook.dbSize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }
}
