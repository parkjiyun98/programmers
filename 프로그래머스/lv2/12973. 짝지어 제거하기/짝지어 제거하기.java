import java.util.*;
class Solution
{
    public int solution(String s)
    {
        /*
        int answer = -1;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }
        
        if(stack.isEmpty())
            answer = 1;
        else
            answer = 0;

        return answer;
        */
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(stack.size() == 0){
                stack.push(c);
            }
            else if(stack.peek() == c){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }


        return stack.size() > 0 ? 0 : 1;
    }
}