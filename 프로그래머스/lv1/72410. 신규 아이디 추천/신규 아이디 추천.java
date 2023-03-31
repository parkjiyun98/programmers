class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase(); // 소문자로 
        answer = answer.replaceAll("[^-_.a-z0-9]", ""); //-_. 영문자 숫자만 남김 
        answer = answer.replaceAll("[.]{2,}", "."); // .2개 이상 .으로 
        answer = answer.replaceAll("^[.]|[.]$", ""); // 처음과 끝 . 제거 

        if(answer.equals("")) // 빈 문자열이라면 a 추가 
            answer += "a";
            
        if(answer.length() >= 16){ // 16자 이상이면 15자로 
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("^[.]|[.]$", ""); // 끝 . 제거 
        }
        if(answer.length() <= 2) // 2자 이하라면 3자까지 마지막 문자추가 
            while(answer.length() < 3)
                answer += answer.charAt(answer.length() - 1);

        return answer;
    }
}