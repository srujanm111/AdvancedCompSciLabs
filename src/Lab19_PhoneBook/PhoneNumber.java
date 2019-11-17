package Lab19_PhoneBook;

public class PhoneNumber {

    private int number;

    public PhoneNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number % PhoneBook.dbSize;
    }
}
