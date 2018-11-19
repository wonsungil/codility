package codility.lesson6_sorting;

/**
 * 44/100
 */
public class MaxProductOfThree {

    public static int triplet(int[] A, int P, int Q, int R) {
        return A[P] * A[Q] * A[R];
    }

    public static int solution(int[] A) {

        int MAX_VALUE = -1000 * -1000 * -1000;
        int triplet;
        for (int i=0; i<A.length; i++) {
            for (int j=i+1; j<A.length; j++) {
                for (int k=j+1; k<A.length; k++) {
                    triplet = triplet(A, i,j,k);
                    if(triplet > MAX_VALUE) {
                        MAX_VALUE = triplet;
                    }
                }
            }
        }

        return MAX_VALUE;
    }

    public static void main(String[] args) {
        int[] A = {-3, 1, 2, -2, 5, 6};
        int[] B = {-10, -2, -4};

        System.out.println(solution(B));
    }
}
