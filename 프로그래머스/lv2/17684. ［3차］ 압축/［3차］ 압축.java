import java.util.*;
class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < 26; i++){
            map.put(s.charAt(i) + "", i+1);
        }
        
        int start = 27;
        boolean check = false;
        
        for(int i = 0; i < msg.length(); i++){
            String temp = msg.charAt(i) + "";
            
            while(map.containsKey(temp)){
                i++;
                if(i == msg.length()){
                    check = true;
                    break;
                }
                temp += msg.charAt(i);
            }
            if(check){
                list.add(map.get(temp));
                break;
            }
            
            map.put(temp, start++);
            list.add(map.get(temp.substring(0, temp.length() - 1)));
            i--;
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}