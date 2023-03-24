import java.util.*;
class Solution {
    int answer = 0;
    public int solution(String begin, String target, String[] words) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        if(!list.contains(target)) return 0;
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);
        
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, boolean[] visited, int depth){
        if(begin.equals(target)){
            answer = depth;
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(visited[i]) continue;
            if(check(begin, words[i])){
                visited[i] = true;
                dfs(words[i], target, words, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean check(String s1, String s2){
        int count = 0;
        
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        }
        
        return count == 1;
    }
}