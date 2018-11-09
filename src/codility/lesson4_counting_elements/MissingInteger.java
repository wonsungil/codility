package codility.lesson4_counting_elements;


import java.util.HashMap;
import java.util.Map;

public class MissingInteger {

    /**
     * 1. 배열 A에 양수인 수가 없으면 1을 리턴
     * 2. 배열 A가 순열이면 최대값 +1 리턴
     * 3. 배열 A가 중간에 값이 없다면, 없는 값 중 최소값 리턴
     *
     * @param A
     * @return
     */
    public static int solution(int[] A) {
        int max = A[0];
        Map<Integer, Boolean> permMap = new HashMap<>();

        permMap.put(A[0], true);
        for (int i=1; i<A.length; i++) {
            if(A[i] > max) max = A[i];

            if(!permMap.containsKey(A[i])) {
                permMap.put(A[i], true);
            }
        }

        if(max < 0) {
            return 1;
        }

        for (int i=1; i <= A.length; i++) {
            if(!permMap.containsKey(i)) {
                return i;
            }
        }

        return max+1;
    }

    public static void main(String[] args) {

        int[] A = {1, 3, 6, 4, 1, 2};
//        int[] A = {-1, -3};
//        int[] A = {1, 2, 3};
//        int[] A = {4, 5, 6, 2};

        System.out.println(solution(A));
    }
}
