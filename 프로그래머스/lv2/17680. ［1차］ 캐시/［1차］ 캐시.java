import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0)
            return cities.length * 5;
        Queue<String> q = new LinkedList<>();
        for(String c : cities){
            String city = c.toUpperCase();
            if(q.contains(city)){
                answer++;
                q.remove(city);
                q.offer(city);
            }
            else{
                if(q.size() < cacheSize)
                    q.offer(city);
                else{
                    q.poll();
                    q.offer(city);
                }   
                answer += 5;
            }
        }
        return answer;
    }
}