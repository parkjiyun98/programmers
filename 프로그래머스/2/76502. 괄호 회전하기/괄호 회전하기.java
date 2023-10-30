import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = s;
        for(int i = 0; i < s.length(); i++){
            char first = str.charAt(0);
            str = str.substring(1) + first;
            if(check(str))
                answer++;
        }
        return answer;
     }
    
    public boolean check(String s){
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        
        for(char c : arr){
            if(stack.isEmpty())
                stack.push(c);
            else if(stack.peek() == '[' && c == ']')
                stack.pop();
            else if(stack.peek() == '{' && c == '}')
                stack.pop();
            else if(stack.peek() == '(' && c == ')')
                stack.pop();
            else
                stack.push(c);
        }
        if(stack.isEmpty())
            return true;
        
        return false;
    }
}