package codility.lesson4_counting_elements;

import java.util.HashMap;
import java.util.Map;

public class PermCheck {

    /**
     * map 써서 쉽게 해결했는데 안쓰고 푸는 방법 고려해봐야할듯.
     * @param A
     * @return
     */
    public static int solution(int[] A) {

        Map<Integer, Integer> check = new HashMap<>();

        if(A.length == 1 && A[0] != 1) {
            return 0;
        }

        int visitCount = 0;

        for (int a : A) {
            if(check.containsKey(a)) {
                visitCount = check.get(a);
            }
            check.put(a, visitCount+1);
            visitCount = 0;
        }

        for (int i = 1; i <= A.length ; i++) {
            if(!check.containsKey(i)) {
                return 0;
            }

            if(check.get(i) > 1) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
//        int[] A = {4, 1, 3, 2};
//        int[] B = {4, 1, 3};
        int[] B = {3, 1};

//        System.out.println(solution(A));
        System.out.println(solution(B));
    }
}
