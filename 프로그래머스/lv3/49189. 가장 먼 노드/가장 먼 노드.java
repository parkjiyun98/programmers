import java.util.*;
class Solution {
    boolean[][] map;
    boolean[] visited;
    public int solution(int n, int[][] edge) {
        int answer =  0;
        visited = new boolean[n + 1];
        map = new boolean[n+1][n+1];
        
        for(int i = 0;i< edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            map[a][b] = true;
            map[b][a] = true;
        }
        answer = bfs(edge);
        return answer;
    }
    public int bfs(int[][] edge){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        
        int size = 0;
        
        while (!queue.isEmpty()) {
            size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                for (int j = 1; j < visited.length; j++) {
                    if (!visited[j] && map[current][j]) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
        }
        
        return size;
    }
}