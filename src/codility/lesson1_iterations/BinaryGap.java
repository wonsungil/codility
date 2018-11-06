package codility.lesson1_iterations;

public class BinaryGap {

    public static int solution(int A) {
        /**
         * 2진수로 사이 0의 길이 중 최대길이
         */

        int gap = 0;
        int maxGap = 0;

        for (char a : Integer.toBinaryString(A).toCharArray()) {
            if('1' == a) {
                if(gap > maxGap) {
                    maxGap = gap;
                }
                gap = 0;
            } else {
                gap++;
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {
        System.out.println(solution(9));
    }
}
