package codility.lesson7_stacks_and_queues;

import java.sql.Statement;
import java.util.Stack;

public class StoneWall {

    public void print(Stack<Integer> S) {
        Stack<Integer> temp = (Stack<Integer>)S.clone();
        while (!temp.isEmpty()) {
            System.out.print( temp.pop() + ", ");
        }

    }

    public int solution2(int[] H) {

        int numOfBlock = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i: H) {
            print(stack);
            System.out.println("[" + numOfBlock + "]");

            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                boolean loop = true;
                while (loop) {
                    int peek = stack.peek();

                    if(peek == i) {
                        stack.pop();
                        numOfBlock++;
                    } else if (peek > i) {
                        stack.pop();
                        numOfBlock++;

                        if(!stack.isEmpty()) {
                            peek = stack.peek();
                            if(peek < i) {
                                stack.push(i);
                            }
                        } else {
                            stack.push(i);
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

        if(!stack.isEmpty()) {
            numOfBlock+=stack.size();
        }

        return numOfBlock;
    }

    public int solution(int[] H) {
        Stack<Integer> wallStack = new Stack<>();

        int numOfBlock = 0;
        for (int i : H) {
            if(wallStack.isEmpty()) {
                wallStack.push(i);
            } else {
                int peek = wallStack.peek();
                if(peek == i) {
                    wallStack.pop();
                    numOfBlock++;
                } else if(peek > i) {
                    wallStack.pop();
                    numOfBlock++;
                    wallStack.push(i);
                } else if(peek < i) {
                    wallStack.push(i);
                }
            }
        }

        if(wallStack.size() > 0) {
            numOfBlock+=wallStack.size();
        }

        return numOfBlock;
    }

    public static void main(String[] args) {

        int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        int[] H2 = {3,2,1};

        StoneWall stoneWall = new StoneWall();
        System.out.println(stoneWall.solution2(H));
    }
}
