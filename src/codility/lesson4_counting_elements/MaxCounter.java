package codility.lesson4_counting_elements;

public class MaxCounter {

    /**
     * 77/100 속도 고려해서 재작성 필요
     * @param N
     * @param A
     * @return
     */
    public static int[] solution(int N, int[] A) {

        int[] counter = new int[N];
        int maxVal = 0;
        int index = 0;
        for (int i = 0; i < A.length;  i++) {

            if(A[i] == N+1) {
                for (int j=0 ; j < N; j++) {
                    counter[j] = maxVal;
                }

            } else {
                index = A[i] - 1;
                counter[index]++;
                if(counter[index] > maxVal) {
                    maxVal = counter[index];
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 4, 6, 1,  4, 4};
        int[] B = {2, 1, 1, 2, 1};

        int[] result = solution(5, A);

        int[] result2 = solution(1, B);

        for (int item: result2) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
