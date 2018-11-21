package codility.lesson7_stacks_and_queues;

import java.util.Stack;

public class Nested {

    public boolean isOpenBracket(char item) {
        return item == '{' || item == '(' || item == '[';
    }

    public boolean isCloseBracket(char item) {
        return item == '}' || item == ')' || item == ']';
    }

    public boolean isMatch(char open, char close) {
        if(open=='(' && close==')') {
            return true;
        } else if(open=='{' && close=='}') {
            return true;
        } else if(open=='[' && close==']') {
            return true;
        }
        return false;
    }

    public int solution(String S) {

        int isNested = 0;

        if(S.length()==0) {
            return 1;
        }

        Stack bracketsStack = new Stack();
        for (char item : S.toCharArray()) {
            if(isOpenBracket(item)) {
                bracketsStack.push(item);
                if(bracketsStack.size()>1) {
                    isNested = 1;
                }
            }
            if(isCloseBracket(item)) {
                if(bracketsStack.isEmpty()) {
                    return 0;
                }

                char pop = (char)bracketsStack.pop();
                if (!isOpenBracket(pop) || !isMatch(pop,item)) {
                    return 0;
                }
            }
        }

        if(!bracketsStack.isEmpty()) {
            return 0;
        }
        return isNested;
    }

    public static void main(String[] args) {

    }
}
