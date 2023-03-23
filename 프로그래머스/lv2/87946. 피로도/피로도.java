class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        return dfs(k, dungeons, visited, 0);
    }
    
    public int dfs(int k, int[][] dungeons, boolean[] visited, int count){
        for(int i = 0; i < dungeons.length; i++){
            if(k >= dungeons[i][0] && !visited[i]){
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
        answer = Math.max(count, answer);
        return answer;
    }   
}