import java.util.*;
class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> array = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        /*
        char ch = 'A';
        for(int i = 1; i< 27; i++){
            map.put(ch + "", i);
            ch += 1;
        }
        */
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
            array.add(map.get(temp.substring(0, temp.length()-1)));
            map.put(temp, start++);
            i--;
        }
        int[] answer = new int[array.size()];
        for(int i = 0; i < array.size(); i++){
            answer[i] = array.get(i);
        }
        return answer;
    }
}