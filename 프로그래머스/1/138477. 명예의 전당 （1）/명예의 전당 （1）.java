import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        for(int i = 0; i < score.length; i++){
            int[] temp = Arrays.copyOfRange(score, 0, i+1);
            Integer[] integerTemp = Arrays.stream(temp).boxed().toArray(Integer[]::new);
            Arrays.sort(integerTemp, Collections.reverseOrder());
            if(i+1 < k)
                answer[i] = integerTemp[i];
            else
                answer[i] = integerTemp[k-1];
        }
        return answer;
    }
}