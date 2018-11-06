package codility.lesson3_time_complexity;

public class FrogJmp {
    public static int solution(int X, int Y, int D) {

        /**
         * Y-X를 D로 나누면 D의 배수가 되고 Y-X 모듈러 연산의 나머지값이 존재하면 +1회 (큰값이 되는) 추가한다.
         */

        int YX = Y-X;
        int N = YX/D;

        return N + (YX%D > 0? 1:0);
    }

    public static void main(String[] args) {
//        System.out.println(solution(3, 999111321, 7));
        System.out.println(solution(10, 85,  30));
        System.out.println(solution(1, 1,  3));
        System.out.println(solution(1, 5,  2));
        System.out.println(solution(5, 105,  3));
        System.out.println(solution(50, 199,  4));
    }
}
