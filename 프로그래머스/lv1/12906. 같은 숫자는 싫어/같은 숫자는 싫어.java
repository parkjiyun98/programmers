import java.util.*;

import java.util.*;
public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int x = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != x) {
                list.add(arr[i]);
                x = arr[i];
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        //return list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}