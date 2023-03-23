import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        int count = 0;
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < record.length; i++){
            String[] temp = record[i].split(" ");
            if(temp[0].equals("Leave"))
                continue;
            else if(temp[0].equals("Enter"))
                map.put(temp[1], temp[2]);
            else{
                map.put(temp[1], temp[2]);
                count++;
            }
        }
        String[] answer = new String[record.length - count];
        int index = 0;
        
        for(int i = 0; i < record.length; i++){
            String[] temp = record[i].split(" ");
            String name = map.get(temp[1]);
            
            if(temp[0].equals("Enter"))
                answer[index++] = name + "님이 들어왔습니다.";
            else if(temp[0].equals("Leave"))
                answer[index++] = name + "님이 나갔습니다.";
        }
        
        return answer;
        
    }
}