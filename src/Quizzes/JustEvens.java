package Quizzes;

public class JustEvens {

    public static int justEvens(int n) {
        if (n == 0) return 0;
        int lastDigit = n % 10;
        return lastDigit % 2 == 0 ? (justEvens(n / 10) * 10) + lastDigit : (justEvens(n / 10));
    }

    public static void main(String[] args){
        System.out.println(justEvens(8342116));
        System.out.println(justEvens(-34512));
        System.out.println(justEvens(7));
    }
}
