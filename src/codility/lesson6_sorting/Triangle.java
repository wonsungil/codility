package codility.lesson6_sorting;

/**
 * 81/100
 */
public class Triangle {

    public static boolean isTriangular(int[] A, int P, int Q, int R) {

        long PQ = (long)A[P] + (long)A[Q];
        long QR = (long)A[Q] + (long)A[R];
        long RP = (long)A[R] + (long)A[P];

        if (PQ>A[R] && QR>A[P] && RP>A[Q]) {
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
        int[] C = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        System.out.println(solution(A));
//        System.out.println(solution(B));
        System.out.println(solution(C));

    }
}
