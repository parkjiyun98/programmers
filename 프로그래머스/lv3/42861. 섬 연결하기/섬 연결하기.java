import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] set = new int[n];
        for(int i = 0; i < n; i++){
            set[i] = i;
        }
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        for(int i = 0; i < costs.length; i++){
            if(find(set, costs[i][0]) != find(set, costs[i][1])){
                set[find(set, costs[i][1])] = find(set, costs[i][0]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
    
    public int find(int[] set, int node){
        if(set[node] == node){
            return node;
        }
        return find(set, set[node]);
    }
}