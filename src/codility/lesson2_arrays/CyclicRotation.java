package codility.lesson2_arrays;

public class CyclicRotation {

    public static int[] solution(int[] A, int K) {

        int size = A.length;

        if(size == K) {
            return A;
        }

        int[] shift = new int[size];

        int pos = 0;

        for (int i=0; i<size; i++) {
            pos = (i+K) % size;
            shift[pos] = A[i];
        }

        return shift;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
    }
}
