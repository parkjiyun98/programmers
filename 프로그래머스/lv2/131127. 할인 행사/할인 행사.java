import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < number.length; i++){
            map.put(want[i], number[i]);
        }
        int n = discount.length - 10;
        while(count < n+1){
            
            for(int i = 0; i < n+1; i++){
                HashMap<String, Integer> temp = new HashMap<>(map);
                for(int j = i; j < i+10; j++){
                    if(temp.containsKey(discount[j])){
                        temp.put(discount[j], temp.get(discount[j])-1);
                        if(temp.get(discount[j]) == 0)
                            temp.remove(discount[j]);
                    }
                    
                }
                if(temp.isEmpty())
                    answer++;
                count++;
            }
        }
        return answer;
    }
}