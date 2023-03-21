import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        /*
        int[] answer = new int[100];
        int day = 0;
        
        for(int i = 0; i < progresses.length; i++){
            while(progresses[i] + (speeds[i] * day) < 100){
                day++;
            }
            answer[day]++;
        }
        
        int count = 0;
        
        for(int i = 0; i < answer.length; i++){
            if(answer[i] != 0){
                count ++;
            }
        }
        
        int[] result = new int[count];
        count = 0;
        for(int i = 0; i < answer.length; i++){
            if(answer[i] != 0){
                result[count] = answer[i];
                count++;
            }
        }
        
        return result;
        */
        
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        int index = 0;
        int count = 0;
        List<Integer> list = new LinkedList<>();
        for(int j : progresses)
            q.add(j);
        
        while(!q.isEmpty()){
            if(q.peek() + i * speeds[index] >= 100){
                int size = q.size();
                for(int j = 0; j < size; j++){
                    if(q.peek() + i * speeds[index] >= 100){
                        q.poll();
                        index++;
                        count++; 
                    }
                }
                list.add(count);
                count = 0;
                i = 0;
            }else{
                i++;
            }
                
        }
        return list.stream().mapToInt(Integer :: intValue).toArray();
        
    }
}