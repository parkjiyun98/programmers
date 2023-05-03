import java.util.*;
class Solution {
    static HashMap<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> arr = new ArrayList<>();
        
        for(int i = 0; i < orders.length; i++){
            char[] tmp = orders[i].toCharArray();
            Arrays.sort(tmp);
            orders[i] = String.valueOf(tmp);
        }
        
        for(int i = 0; i < course.length; i++){
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            
            for(int j = 0; j < orders.length; j++){
                StringBuilder sb = new StringBuilder();
                
                if(course[i] <= orders[j].length())
                    comb(orders[j], sb, 0, 0, course[i]);
            }
            
            for(int value : map.values()){
                max = Math.max(max, value);
            }
            
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(max >= 2 && entry.getValue() == max)
                    arr.add(entry.getKey());
            }
        }
        Collections.sort(arr);
        
        String[] answer = new String[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
    
    public void comb(String str, StringBuilder sb, int cnt, int idx, int n){
        //각 코스 요리의 개수만큼 조합이 되면
        if(cnt == n){
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for(int i = idx; i < str.length(); i++){
            sb.append(str.charAt(i));
            comb(str, sb, cnt+1, i+1, n);
            sb.delete(cnt, cnt+1);
        }
    }
}