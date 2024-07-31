class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int middle = s.length() / 2;
        if(s.length() % 2 != 0){
            answer.append(s.charAt(middle));
        } else{
            answer.append(s.charAt(middle -1));
            answer.append(s.charAt(middle));
        }
        return answer.toString();
    }
}