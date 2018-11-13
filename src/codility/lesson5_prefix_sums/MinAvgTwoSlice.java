package codility.lesson5_prefix_sums;

public class MinAvgTwoSlice {

    public static int solution(int[] A) {
        int minPos = 0;
        float min = 10001;
        int curSum = 0;
        float curAvg;

        for (int i=0; i<A.length; i++) {
            for (int j=i; j<A.length; j++) {
                curSum += A[j];
                if(j-i != 0 ) {
                    curAvg = (float)curSum/(j-i+1);
                    if((min > curAvg)) {
                        min = curAvg;
                        minPos = i;
                    }
                }
            }
            curSum = 0;
        }
        return minPos;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 2, 5, 1, 5, 8};

        System.out.println(solution(A));
    }
}
