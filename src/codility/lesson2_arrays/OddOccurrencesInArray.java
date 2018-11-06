package codility.lesson2_arrays;

public class OddOccurrencesInArray {

    public static int solution(int[] A) {
        int unpair = A[0];

        for (int i=1; i<A.length; i++) {
            unpair ^= A[i];
        }

        return unpair;
    }

    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
    }
}
