package codility.lesson7_stacks_and_queues;

import java.util.PriorityQueue;
import java.util.Queue;

public class Fish {

    class FishNode implements Comparable<FishNode>{

        private int value;

        public FishNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(FishNode target) {
            if(this.value > target.getValue()) {
                return 1;
            } else if(this.value < target.getValue()){
                return -1;
            }
            return 0;
        }
    }

    public int solution(int[] A, int[] B) {

        Queue<FishNode> upstream = new PriorityQueue<>();
        Queue<FishNode> downstream = new PriorityQueue<>();

        int size = A.length;
        int numOfFish = 0;

        for (int i=0; i<size; i++) {
            if(B[i]==0) {
                upstream.add(new FishNode(A[i]));
            } else {
                downstream.add(new FishNode(A[i]));
            }
        }

        int upFish = 0;
        int downFish = 0;

        if(upstream.isEmpty()) {
            return downstream.size();
        } else if(downstream.isEmpty()) {
            return upstream.size();
        } else {
            while(!upstream.isEmpty()) {
                upFish = upstream.peek().getValue();
                downFish = downstream.peek().getValue();

                if(upFish > downFish) {
                    downstream.poll();
                } else if(upFish == downFish){
                    numOfFish+=2;
                    upstream.poll();
                    downstream.poll();
                } else {
                    upstream.poll();
                }
                if(upstream.isEmpty()) {
                    numOfFish+=downstream.size();
                }
                if(downstream.isEmpty()) {
                    numOfFish+=upstream.size();
                    upstream.clear();
                }
            }
        }

        return numOfFish;
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};

        int[] A2 = {0, 1};
        int[] B2 = {1, 1};
        int[] A3 = {1, 1};
        int[] B3 = {1, 0};
        int[] A4 = {1, 1};
        int[] B4 = {0, 1};

        int[] A5 = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] B5 = {0, 1, 1, 1, 1, 1, 1, 1, 1};

        int[][] TA = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        int[][] TB = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

        Fish fish = new Fish();
        for (int[] innerA : TA) {
            for (int[] innerB : TB) {
                System.out.print("A={"+innerA[0]+","+innerA[1]+"}");
                System.out.print(", B={"+innerB[0]+","+innerB[1]+"} ==> ");
                System.out.println(fish.solution(A, B));
            }
        }

        System.out.println(fish.solution(A, B));
        System.out.println(fish.solution(A2, B2));
        System.out.println(fish.solution(A3, B3));
        System.out.println(fish.solution(A4, B4));
        System.out.println(fish.solution(A5, B5));
    }
}
