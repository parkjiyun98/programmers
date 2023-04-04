import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        for(String gem : gems){
            set.add(gem);
        }
        int distance = Integer.MAX_VALUE;
        //범위
        int left = 0;
        int right = 0;

        //정답
        int start = 0;
        int end = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        while (true) {

            if (set.size() == map.size()) {
                //크기 같은 경우 원하는 범위 좁히기
                map.put(gems[left], map.get(gems[left])-1);

                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            } else if (right == gems.length) {
                break;
            } else {
                //right 오른쪽으로 이동
                //set에 해당하는 보석들을 다 찾아야함
                //해당 보석의 개수 +1
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            if (map.size() == set.size()) {
                if (right-left < distance){
                    distance = right-left;
                    start = left+1;
                    end = right;
                }
            }

        }//while
        answer[0] = start;
        answer[1] = end;
        return answer;
    }
}