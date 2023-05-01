import java.util.*;
class Solution {
    public int solution(String dirs) {
        HashSet<String> set = new HashSet<>();
        
        int curX = 0;
        int curY = 0;
        
        for(char c : dirs.toCharArray()){
            int nextX = curX;
            int nextY = curY;
            String temp = "";
            
            if(c == 'U'){
                nextY++;
                temp += curX;
                temp += curY;
                temp += nextX;
                temp += nextY;
            }
            else if(c == 'D'){
                nextY--;
                temp += nextX;
                temp += nextY;
                temp += curX;
                temp += curY;
            }
            else if(c == 'R'){
                nextX++;
                temp += curX;
                temp += curY;
                temp += nextX;
                temp += nextY;
            }
            else{
                nextX--;
                temp += nextX;
                temp += nextY;
                temp += curX;
                temp += curY;
            }
            if(nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5)
                continue;
            
            set.add(temp);
            curX = nextX;
            curY = nextY;       
        }
        return set.size();
    }
}