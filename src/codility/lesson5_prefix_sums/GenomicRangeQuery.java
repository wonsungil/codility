package codility.lesson5_prefix_sums;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 62/100
 */
public class GenomicRangeQuery {
    static Map<Character, Integer> genomMap;
    static {
        genomMap = new HashMap<>();
        genomMap.put('A', 1);
        genomMap.put('C', 2);
        genomMap.put('G', 3);
        genomMap.put('T', 4);
    }

    public static int minimalImpactFactor(String S) {

        int minimal = 999;

        for (char C : S.toCharArray()) {
            if(minimal > genomMap.get(C)) {
                minimal = genomMap.get(C);
            }
        }

        return minimal;
    }

    public static int[] solution(String S, int[] P, int Q[]) {

        int M = P.length;
        int[] result = new int[M];

        int p;
        int q;
        String subS = "";

        for (int i=0; i<M; i++) {
            p = P[i];
            q = Q[i];
            subS = S.substring(p, q+1);
            result[i] = minimalImpactFactor(subS);
        }

        return result;
    }

    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};

        for (int i : solution(S, P , Q)) {
            System.out.println(i);
        }
    }
}
