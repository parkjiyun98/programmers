import java.util.*;
class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        s = s.substring(2,s.length());
        s = s.substring(0,s.length()-2).replace("},{","#");
        String str[] = s.split("#");
        Arrays.sort(str, (String s1, String s2) -> s1.length() - s2.length());
        for(int i = 0; i < str.length; i++){
            String[] temp = str[i].split(",");
            for(int j = 0; j < temp.length; j++){
                int number = Integer.parseInt(temp[j]);
                if(!result.contains(number))
                    result.add(number);
            }
        }
        //Integer[] answer = result.toArray(new int[0]);
        //int[] answer = result.stream().toArray(int[]::new);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}