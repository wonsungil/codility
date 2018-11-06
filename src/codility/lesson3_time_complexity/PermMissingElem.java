package codility.lesson3_time_complexity;

public class PermMissingElem {
    public static int solution(int[] A) {

        /**
         * A의 길이 + 1 한 만큼 전체를 더 한 값과, A원소들의 합의 차
         */

        int total = A.length+1;
        int sumOfItem = 0;

        for(int i=0; i<A.length; i++) {
            total += (i+1);
            sumOfItem += A[i];
        }

        return total-sumOfItem;
    }

    public static void main(String[] args) {

//        int[] A = {2,1,3,5};
//        int[] A = {1};
        int[] A = {1,2};

        System.out.println(solution(A));

    }
}
