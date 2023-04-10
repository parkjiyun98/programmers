class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.charAt(0) >= 97 && s.charAt(0) <= 122){
            String temp = s.charAt(0) + "";
            temp = temp.toUpperCase();
            answer += temp;
        }
        else{
            String temp = s.charAt(0) + "";
            answer += temp;
        }
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) == ' '){
                if(s.charAt(i) >= 97 && s.charAt(i) <= 122){
                    String temp = s.charAt(i) + "";
                    temp = temp.toUpperCase();
                    answer += temp;
                }
                else{
                    String temp = s.charAt(i) + "";
                    answer += temp;
                }
            }
            else{
                String temp = s.charAt(i) + "";
                temp = temp.toLowerCase();
                answer += temp;
            }
        }
        return answer;
    }
}