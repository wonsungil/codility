package codility.lesson5_prefix_sums;

public class MinAvgTwoSlice {

    public static int solution(int[] A) {

        if(A.length==1) {
            return A[0];
        }

        float minAvg = -1;
        int minStartPos = 0;
        int sum = 0;
        int p = 0;
        int q = 0;

        for (int i=0; i<A.length ; i++) {
            for(int j=i+1; j<A.length; j++) {
                for (int k=i; k<=j; k++) {
                    sum += A[k];
                }
                float currentAvg = (float)sum/(j+1-i);
                if((minAvg==-1) || (minAvg>currentAvg)) {
                    minAvg = currentAvg;
                    minStartPos = i;
                }

                sum = 0;
            }
        }

        return minStartPos;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 2, 5, 1, 5, 8};

        System.out.println(solution(A));
    }
}
