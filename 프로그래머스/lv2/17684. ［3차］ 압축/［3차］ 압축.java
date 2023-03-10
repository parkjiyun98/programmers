import java.util.*;
class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> array = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        String al = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < 26; i++){
            map.put(al.charAt(i) + "", i+1);
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
                array.add(map.get(temp));
                break;
            }
            map.put(temp, start++);
            array.add(map.get(temp.substring(0, temp.length()-1)));
            i--;
        }
        int[] answer = new int[array.size()];
        for(int i = 0; i < array.size(); i++){
            answer[i] = array.get(i);
        }
        return answer;
    }
}