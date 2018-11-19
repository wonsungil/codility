package codility.lesson5_prefix_sums;

import java.util.*;

/**
 * TODO 75/100
 */
public class GenomicRangeQuery {

    class Pair implements Comparable {
        private int letter;
        private int index;

        public Pair(int letter, int index ) {
            this.letter = letter;
            this.index = index;
        }

        public int getLetter() {
            return this.letter;
        }

        public int getIndex() {
            return this.index;
        }

        @Override
        public int compareTo(Object p) {
            return this.letter - ((Pair)p).getLetter();
        }
    }

    public List<Pair> sortS(String S) {
        List<Pair> pairList = new ArrayList<>();

        char[] chars = S.toCharArray();
        int value=0;
        for (int i=0; i<chars.length; i++) {

            switch (chars[i]) {
                case 'A' : value = 1; break;
                case 'C' : value = 2; break;
                case 'G' : value = 3; break;
                case 'T' : value = 4; break;
                default : break;
            }

            Pair item  = new Pair(value, i);
            pairList.add(item);
        }
        Collections.sort(pairList);
        return pairList;
    }

    public int[] solution(String S, int[] P, int Q[]) {

        int M = P.length;
        int[] result = new int[M];

        List<Pair> sorted = sortS(S);

        for (int i=0; i<M; i++) {
            for (Pair item : sorted) {
                if( item.getIndex() >= P[i] && item.getIndex() <= Q[i]) {
                    result[i] = item.getLetter();
                    break;
                }
            }
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
