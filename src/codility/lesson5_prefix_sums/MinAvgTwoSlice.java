package codility.lesson5_prefix_sums;

/**
 * TODO 60/100
 */
public class MinAvgTwoSlice {

    public static int solution(int[] A) {
        int minPos = 0;
        float min = 10001;
        int curSum = 0;
        float curAvg;

        int totalSum = 0;
        float totalAvg = 0;

        for (int i=0; i<A.length ; i++) {
            totalSum += A[i];
        }
        totalAvg = (float)totalSum / (A.length+1);
        System.out.println(totalAvg);

        for (int i=0; i<A.length; i++) {
            totalSum -= A[i];
            System.out.println(totalSum);
            System.out.println((float)totalSum/A.length-(i+1));
        }


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
