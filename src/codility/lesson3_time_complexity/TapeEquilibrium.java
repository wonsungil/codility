package codility.lesson3_time_complexity;

public class TapeEquilibrium {

    public static int solution(int[] A) {
        /**
         * Array의 시작부터 더 한 값과 Array의 끝부터 더 한 값의 차 중 최소값
         */
        int size = A.length;

        int leftSum = 0;
        int rightSum = 0;
        int left[] = new int[A.length-1];
        int right[] = new int[A.length-1];

        for (int i  = 0 ; i < size-1 ; i++) {
            leftSum += A[i];
            left[i] = leftSum;

            rightSum += A[size-(i+1)];
            right[size-2-i] = rightSum;
        }

        int min = Math.abs(left[0] - right[0]);

        for (int i=1; i<size -1; i++) {
            if(min > Math.abs(left[i] - right[i])) {
                min = Math.abs(left[i] - right[i]);
            }
        }


        return min;
    }

    public static void main(String[] args) {

        int[] A = {3, 1, 2, 4, 3};

        System.out.println(solution(A));


    }
}
