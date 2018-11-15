package codility.lesson6_sorting;

import java.util.HashMap;
import java.util.Map;

public class Distinct {

    public static int solution(int[] A) {

        Map<Integer, Boolean> check = new HashMap<>();

        int numOfVal = 0;

        for (int item : A) {
            if(!check.containsKey(item)) {
                check.put(item, true);
                numOfVal++;
            }
        }

        return numOfVal;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 1, 2, 3, 1};

        System.out.println(solution(A));

    }
}
