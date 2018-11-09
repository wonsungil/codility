package codility.lesson92_2016_college_coders;

public class TennisTournament {

    public static int solution(int P, int C) {
        int maxMatch = P/2;
        return Math.min(maxMatch, C);
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 3));
        System.out.println(solution(10, 3));
    }
}