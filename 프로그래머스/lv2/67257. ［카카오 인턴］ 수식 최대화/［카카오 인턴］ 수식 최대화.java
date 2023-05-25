import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = Long.MIN_VALUE;
        String op[][] = { { "+", "-", "*" }, { "+", "*", "-" }, { "-", "*", "+" }, { "-", "+", "*" }, { "*", "-", "+" }, { "*", "+", "-" } };
        
        ArrayList<String> list = new ArrayList<>();
        int start = 0;
        
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'){
                list.add(expression.substring(start, i));
                list.add(expression.charAt(i) + "");
                start = i+1;
            }
        }
        list.add(expression.substring(start));
        
        for(int i = 0; i < op.length; i++){
            ArrayList<String> temp = new ArrayList<>(list);
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < temp.size(); k++){
                    if(op[i][j].equals(temp.get(k))){
                        temp.set(k-1, calc(temp.get(k-1), temp.get(k), temp.get(k+1)));
                        temp.remove(k);
                        temp.remove(k);
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(temp.get(0))));
        }
        return answer;
    }
    
    public static String calc(String num1, String op, String num2){
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);
        
        if(op.equals("+"))
            return n1 + n2 + "";
        else if(op.equals("-"))
            return n1 - n2 + "";
        else
            return n1 * n2 + "";
    }
}