import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String x = clothes[i][1];
            map.put(x, map.getOrDefault(x, 1) + 1);
        }

        for (String x : map.keySet()) {
            answer *= map.get(x);
        }

        return answer-1;
    }
}