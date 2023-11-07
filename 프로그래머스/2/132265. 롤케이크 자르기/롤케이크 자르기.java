import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < topping.length; i++){
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i = 0; i < topping.length; i++){
            map2.put(topping[i], map2.getOrDefault(topping[i], 0) +1);
            
            if(map.get(topping[i]) - 1 == 0)
                map.remove(topping[i]);
            else
                map.put(topping[i], map.get(topping[i]) - 1);
            
            if(map.size() == map2.size())
                answer++;
        }
        return answer;
    }
}