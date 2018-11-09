package codility.lesson5_prefix_sums;

public class PassingCars {

    /**
     * A[index] == 0인경우 자신 보다 큰 인덱스 중 값이 1인 수의 합
     * 문제 자체는 쉬운데 이해를 제대로 못해서 몇번 재재출했다...
     *
     * @param A
     * @return
     */
    public static int solution(int[] A) {

        int passingCount = 0;
        int[] checkArr = new int[A.length];

        for (int i=A.length-1; i>=0; i--) {
            if(i<A.length-1 && i>=0) {
                checkArr[i] = checkArr[i+1]+A[i];

            } else {
                checkArr[i] = A[i];
            }
        }

        for (int i=0;i<A.length;i++) {
            if(A[i] == 0) {
                passingCount += checkArr[i];
            }
        }

        return Math.abs(passingCount) > 1000000000 ? -1 : passingCount;
    }

    public static void main(String[] args) {

        int[] A = {0,1,0,1,1};

        System.out.println(solution(A));
    }
}
