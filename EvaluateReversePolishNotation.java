/**
 *Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *Some examples:
 *["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *http://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
*/

public class Solution {
    private boolean isInteger(String str) { 
        try{
            Integer.parseInt(str);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    public int evalRPN(String[] tokens) {
        int result = 0;
        if(tokens == null || tokens.length == 0) return result;
        Stack<Integer> stack = new Stack<Integer>();

        int s1 = 0;
        int s2 = 0;
        for(String token:tokens) {
            if(isInteger(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                if(stack.isEmpty()) {
                    return result;   
                } 
                s2 = stack.pop(); 
                if(stack.isEmpty()) {
                    return result;   
                } 
                s1 = stack.pop(); 
                if("+".equals(token)) {
                    stack.push(s1+s2);
                } else if("-".equals(token)) {
                    stack.push(s1-s2);
                } else if("*".equals(token)) {
                    stack.push(s1*s2);
                } else if("/".equals(token) && s2 !=0) { //miss the check herer
                    stack.push(s1/s2);
                } else {
                    return result;
                }
            }
        }
        if(!stack.isEmpty()) {
            result = stack.pop();
        } 
        return result;
    }
}
