import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> list = new ArrayList<>();
        boolean check = true;
        
        for(int i = 0; i < words.length; i++){
            //이전에 등장한 단어인 경우
            if(list.contains(words[i])){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                check = false;
                break;
            }
            //현재 단어 리스트에 넣기
            list.add(words[i]);
            
            //이전 끝단어와 현재 첫단어가 다른 경우
            if(i > 0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                check = false;
                break;
            }
        }
        
        if(check) 
            return new int[]{0, 0};
        return answer;
    }
}