package codility.lesson8_leader;

import java.util.*;

/**
 * 100/100
 */
public class Dominator {

    public int solution(int[] A) {

        Map<Integer, List<Integer>> indexes = new HashMap<>();

        int item=0;
        for (int i=0; i<A.length; i++) {

            item = A[i];

            if(indexes.containsKey(item)) {
                indexes.get(item).add(i);
            } else {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                indexes.put(item, index);
            }
        }

        int dominator = -1;
        for (int key: indexes.keySet()) {
            List<Integer> index = indexes.get(key);

            if((A.length/2) < index.size()) {
                dominator = index.get(0);
            }
        }

        return dominator;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};

        Dominator dominator = new Dominator();
        System.out.println(dominator.solution(A));
    }
}
