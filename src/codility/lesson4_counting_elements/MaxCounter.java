package codility.lesson4_counting_elements;

public class MaxCounter {

    /**
     * all_counter 시 최대값을 저장한 뒤 마지막에 N만큼 반복하면서 마지막 최대 보다 작은 counter를 업데이트 해준다.
     *
     * @param N
     * @param A
     * @return
     */
    public static int[] solution(int N, int[] A) {

        int[] counter = new int[N];
        int lastUpdate = 0;
        int maxValue = 0;

        for (int i=0 ; i<A.length; i++) {

            if(A[i] == N+1) {

                lastUpdate = maxValue;

            } else if (A[i] <= N){
               counter[A[i]-1]++;

               if(counter[A[i]-1] <= lastUpdate) {
                   counter[A[i]-1] = lastUpdate + 1;
               }

               if(counter[A[i]-1] > maxValue) {
                   maxValue = counter[A[i]-1];
               }
            }

            for(int k=0 ; k<counter.length; k++) {
                System.out.print(counter[k] + " ");
            }
            System.out.println();
        }

        for (int i=0 ; i<counter.length; i++) {
            if(counter[i] < lastUpdate) {
                counter[i] = lastUpdate;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 4, 6, 1,  4, 4};
        int[] B = {2, 1, 1, 2, 1};

        int[] result2 = solution(5, B);

        for (int item: result2) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
