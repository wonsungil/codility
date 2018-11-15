package codility.lesson6_sorting;

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

        for (int i=0 ; i<A.length; i++) {
            for (int j=i+1; j<A.length; j++) {
                for (int k=j+1; k<A.length; k++) {
                    if(isTriangular(A, i, j, k)) {
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
