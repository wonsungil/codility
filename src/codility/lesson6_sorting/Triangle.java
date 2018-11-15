package codility.lesson6_sorting;

/**
 * 75/100
 */
public class Triangle {

    public static boolean isTriangular(int[] A, int P, int Q, int R) {

        if((A[P] + A[Q] > A[R])
            && (A[Q] + A[R] > A[P])
            && (A[R] + A[P] > A[Q])) {

            return true;
        }

        return false;
    }

    public static int solution(int[] A) {

        int size = A.length;

        for (int i=0 ; i<size-2; i++) {
            for (int j=i+1; j<size-1; j++) {
                for (int k=j+1; k<size; k++) {
                    if(isTriangular(A, i, j, k)) {
                        return 1;
                    }

                    if(isTriangular(A, size - (i+1), size - (j+1), size - (k+1))) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 20};
        int[] B = {10, 50, 5, 1};
        System.out.println(solution(A));
        System.out.println(solution(B));

    }
}
