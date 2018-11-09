package codility.lesson4_counting_elements;

public class FrogRiverOne {

    /**
     * 1..X까지 값이 있는 최소 인덱스 구하기
     * 문제를 이해 못해서 못풀었다가... 난독증인가 ㅡㅡ
     * @param X
     * @param A
     * @return
     */
    public static int solution(int X, int[] A) {

        int count = 0;
        int[] permCheck = new int[X+1];

        for (int i=0; i<A.length;i++) {
            if(A[i] <= X) {
                if(permCheck[A[i]] == 0) {
                    count++;
                    permCheck[A[i]]++;

                    if (count == X) {
                        return i+1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] A =  {1, 3, 4, 2, 3, 5, 4};
        int[] B =  {1, 3, 1, 4, 2, 3, 5, 4};

        System.out.println(solution(5, A));
        System.out.println(solution(5, B));
    }
}
