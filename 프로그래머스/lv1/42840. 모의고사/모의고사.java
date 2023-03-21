import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] count = new int[3];
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == first[i%5]) count[0]++;
            if(answers[i] == second[i%8]) count[1]++;
            if(answers[i] == third[i%10]) count[2]++;
        }
        int max = Math.max(count[0], Math.max(count[1], count[2]));
        ArrayList<Integer> result = new ArrayList<>();
        if(max == count[0])
            result.add(1);
        if(max == count[1])
            result.add(2);
        if(max == count[2])
            result.add(3);
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = result.get(i);
        
        return answer;
    }
}