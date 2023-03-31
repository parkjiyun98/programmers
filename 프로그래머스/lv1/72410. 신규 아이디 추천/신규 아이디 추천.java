class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase().replaceAll("[^\\w\\-_.]", "");
        answer = answer.replaceAll("\\.{2,}", ".").replaceAll("^[.]|[.]$","");
        if(answer.length()>15){
            answer = answer.substring(0,15);
        }

        answer = answer.replaceAll("[.]$", "");

        if(answer.equals("")){
            answer = "aaa";
            return answer;
        }

        if(answer.length()<=2){
            while (answer.length()<3){
                answer += answer.charAt(answer.length()-1);
            }
        }
        return answer;
    }
}