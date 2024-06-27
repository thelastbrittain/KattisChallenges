import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class BinaryTenKindsOfPeople {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args){
        Integer mapRows = getRows();
        Integer mapCols = getCols();
        ArrayList<ArrayList<Integer>> binaryMap = getMap(mapRows, mapCols);



    }

    private static ArrayList<ArrayList<Integer>> getMap(Integer mapRows, Integer mapCols) {
        ArrayList<ArrayList<Integer>> binaryMap = new ArrayList<>();
        for (int i = 0; i < mapCols; i++){
            String lineNumbers = Long.toString(s.nextInt());
            assert lineNumbers.length() == mapRows;
            ArrayList<Integer> digitList = new ArrayList<>();
            for (char c : lineNumbers.toCharArray()){
                Integer number = Character.getNumericValue(c);
                assert number == 1 || number == 0;
                digitList.add(number);
            }
            binaryMap.add(digitList);
        }
        return binaryMap;
    }

    private static Integer getRows() {
        return s.nextInt();
    }

    private static Integer getCols() {
        return s.nextInt();
    }

}
