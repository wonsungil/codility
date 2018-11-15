package codility.lesson5_prefix_sums;

/**
 * TODO 50/100
 */
public class CountDiv {

    public static int solution(int A, int B, int K) {
        int count = 0;
        for (int i=A; i<=B; i++) {
            if(i % K == 0) {
                System.out.println(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int A = 2;
        int B = 100;
        int K = 2;

        long startTime = System.currentTimeMillis();
        System.out.println(solution(A, B, K));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }
}
