import java.util.Scanner;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner sIn = new Scanner(System.in);
        System.out.println("Enter two numbers separated by a space: ");
        int a = sIn.nextInt();
        int b = sIn.nextInt();
        int c = a + b;
        System.out.println(c);

    }
}
