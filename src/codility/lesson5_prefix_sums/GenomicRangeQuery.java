package codility.lesson5_prefix_sums;


import java.util.ArrayList;
import java.util.List;

/**
 * TODO 75/100
 */
public class GenomicRangeQuery {

    public int toValue(char C) {
        switch (C) {
            case 'A' : return 1;
            case 'C' : return 2;
            case 'G' : return 3;
            case 'T' : return 4;
            default : return 0;
        }
    }

    public List<List<Integer>> generateRangeTable(char[] chars) {

        int minValue = 5;
        List<List<Integer>> table = new ArrayList<>();

        for (int i=0; i<chars.length; i++) {
            for (int j=i; j<chars.length;j++) {
                if(minValue > toValue(chars[j])) {
                    minValue = toValue(chars[j]);
                }
                if(table.size() > i) {
                    table.get(i).add(minValue);
                } else {
                    List<Integer> inner = new ArrayList<>();
                    inner.add(minValue);
                    table.add(inner);
                }
            }
            minValue = 5;
        }

        return table;
    }

    public int[] solution(String S, int[] P, int Q[]) {

        int M = P.length;
        int[] result = new int[M];

        List<List<Integer>> table = generateRangeTable(S.toCharArray());

        for (int i=0; i<M; i++) {
            result[i] = table.get(P[i]).get(Q[i]-P[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};

        // 2, 4, 1

        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
        for (int i : genomicRangeQuery.solution(S, P , Q)) {
                System.out.println(i);
        }
    }
}
