import java.util.Scanner;

public class ninetyNineProblems {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int initialNumber = s.nextInt();

        System.out.println(findClosestNumber(initialNumber));

    }

    private static int findClosestNumber(int initialNumber) {
        if (initialNumber <= 100){
            return 99;
        }
        else {
          int lastTwoDigits = getLastTwoDigits(initialNumber);
          if (lastTwoDigits < 49){
              return  initialNumber - lastTwoDigits - 1;
          } else {
              return initialNumber + (99-lastTwoDigits);
          }
        }
    }

    private static int getLastTwoDigits(int initialNumber) {
        if (initialNumber < 100){
            return initialNumber;
        } else {
            return getLastTwoDigits(initialNumber % 100);
        }
    }
}


//get last two integers. if they are less than 50, subtract that number + 1