package codility.lesson7_stacks_and_queues;

import java.util.Stack;

/**
 * 100/100
 * code 정리필요.
 *  1. H Loop
 *  2. 스택이 비었다면 push
 *  3. 빈 스택이 아니면
 *      3-1. peek 과 i가 같다면 push(i)
 *      3-2. peek이 i보다 작다면 push(i)
 *      3-3. peek이 i보다 크다면 stack에서 peek과 같은 값들 모두 Pop, numOfBlock++
 *  4. 빈 스택이 아니라면, peek후 같은 값들 pop, numOfBlock++
 */
public class StoneWall {

    public void popStone(Stack<Integer> S, int value) {
        while(!S.isEmpty() && S.peek() == value) {
            S.pop();
        }
    }

    public int solution(int[] H) {

        int numOfBlock = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i: H) {
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                boolean loop = true;
                while (loop) {
                    int peek = stack.peek();
                    if(peek == i) {
                        stack.push(i);
                        loop = false;
                    } else if (peek > i) {
                        popStone(stack, peek);
                        numOfBlock++;

                        if(!stack.isEmpty()) {
                            peek = stack.peek();
                            if(peek < i) {
                                stack.push(i);
                            }
                        } else {
                            stack.push(i);
                            loop = false;
                        }
                    } else if(peek < i) {
                        stack.push(i);
                        loop = false;
                    }

                    if(stack.isEmpty()) {
                        loop = false;
                    }

                }
            }
        }

        while(!stack.isEmpty()) {
            popStone(stack, stack.peek());
            numOfBlock++;
        }

        return numOfBlock;
    }

    public static void main(String[] args) {

        int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        int[] H2 = {3,2,1};
        int[] H3 = {1,1,1};
        int[] H4 = {1,2,1};

        StoneWall stoneWall = new StoneWall();
        System.out.println(stoneWall.solution(H));
        System.out.println(stoneWall.solution(H2));
        System.out.println(stoneWall.solution(H3));
//        System.out.println(stoneWall.solution(H4));
    }
}
