import java.util.Scanner;

public class PrintingProblem {
    public static void main(String[] args){
    Scanner s  = new Scanner(System.in);
    int numOfStatues = s.nextInt();
    int numOfPrinters = 1;
    int numOfDaysRequired = calculateNumOfDays(numOfStatues, numOfPrinters);
    System.out.println(numOfDaysRequired);
    }

    private static int calculateNumOfDays(int numOfStatues, int numOfPrinters) {
        if (numOfPrinters < numOfStatues){
            return calculateNumOfDays(numOfStatues, numOfPrinters * 2) + 1;
        } else
            return 1;
    }

}
