import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BinaryTenKindsOfPeople {
    private static Scanner s = new Scanner(System.in);
    public record position(int row, int column){
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            position position = (position) o;
            return row == position.row && column == position.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }

    public static void main(String[] args){
        Integer mapRows = s.nextInt();
        Integer mapCols = s.nextInt();
        ArrayList<ArrayList<Integer>> binaryMap = getMap(mapRows, mapCols);
        Integer numberOfQuerries = s.nextInt();;
        ArrayList<ArrayList<Integer>> querries = getQuerries(numberOfQuerries);
        solveQuerries(querries, binaryMap);


    }

    private static void solveQuerries(ArrayList<ArrayList<Integer>> querries, ArrayList<ArrayList<Integer>> binaryMap ) {
        for (ArrayList<Integer> querry : querries){
            solveQuerry(querry, binaryMap);
        }
    }

    private static void solveQuerry(ArrayList<Integer> querry, ArrayList<ArrayList<Integer>> binaryMap) {
        position startPostion = new position(querry.get(0), querry.get(1));
        position endPosition = new position(querry.get(2), querry.get(3));
        ArrayList<position> previouslyVisitedLocations = new ArrayList<>();
        if (startIsBinary(startPostion, binaryMap)){
            if (solveCase(startPostion, endPosition,null, binaryMap, 0, previouslyVisitedLocations)){
                System.out.println("binary");
                return;
            }
        } else {
            if (solveCase(startPostion, endPosition,null, binaryMap, 1, previouslyVisitedLocations)){
                System.out.println("decimal");
                return;
            }
        }
        System.out.println("neither");
    }

    private static boolean solveCase(position startPostion, position endPosition, position previousPosition, ArrayList<ArrayList<Integer>> binaryMap, int number, ArrayList<position> previouslyVisitedLocations) {
        if (previousPosition!= null){
            previouslyVisitedLocations.add(previousPosition);
        }
        if (notInRange(startPostion, binaryMap)) {
            return false;
        }
        if (wrongType(startPostion, binaryMap, number)){
            return false;
        }
        if (previouslyVisitedLocations.contains(startPostion)) {
            return false;
        }
        if (startPostion == endPosition) {
            return true;
        }
        if (solveCase(new position(startPostion.row - 1, startPostion.column), endPosition, startPostion, binaryMap, number, previouslyVisitedLocations)) {
            return true;
        } else if (solveCase(new position(startPostion.row + 1, startPostion.column), endPosition, startPostion, binaryMap, number, previouslyVisitedLocations)) {
            return true;
        } else if (solveCase(new position(startPostion.row, startPostion.column + 1), endPosition, startPostion, binaryMap, number, previouslyVisitedLocations)) {
            return true;
        } else return solveCase(new position(startPostion.row, startPostion.column - 1), endPosition, startPostion, binaryMap, number, previouslyVisitedLocations);
    }

    private static boolean wrongType(position startPostion, ArrayList<ArrayList<Integer>> binaryMap, int number) {
        if (getMapPoint(startPostion, binaryMap) != number){
            return true;
        }
        return false;
    }

    private static boolean notInRange(position startPostion,ArrayList<ArrayList<Integer>> binaryMap ) {
        if (startPostion.row < 1 || startPostion.row > (binaryMap.size())){
            return true;
        } else if (startPostion.column < 1 || startPostion.column > (binaryMap.getFirst().size())){
            return true;
        }
        return false;
    }

    private static boolean startIsBinary(position startPostion, ArrayList<ArrayList<Integer>> binaryMap) {
        Integer mapPoint = getMapPoint(startPostion, binaryMap);
        return mapPoint % 2 == 0;
    }

    private static Integer getMapPoint(position givenPosition, ArrayList<ArrayList<Integer>> binaryMap) {
        return binaryMap.get(givenPosition.row - 1).get(givenPosition.column - 1);
    }

    private static ArrayList<ArrayList<Integer>> getQuerries(Integer numberOfQuerries) {
        ArrayList<ArrayList<Integer>> querryList = new ArrayList<>();
        for (int i = 0; i < numberOfQuerries; i++){
            ArrayList<Integer> digitList = new ArrayList<>();
            for (int j = 0; j < 4; j++){
                digitList.add(s.nextInt());
            }
            querryList.add(digitList);
        }
        return querryList;
    }



    private static ArrayList<ArrayList<Integer>> getMap(Integer mapRows, Integer mapCols) {
        ArrayList<ArrayList<Integer>> binaryMap = new ArrayList<>();
        for (int i = 0; i < mapRows; i++){
            String lineNumbers = Long.toString(s.nextInt());
            assert lineNumbers.length() == mapCols;
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



}
