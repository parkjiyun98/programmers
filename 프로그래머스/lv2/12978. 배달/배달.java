class Solution {
    static final int INF = 500001;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N+1][N+1];
        
        // 무한대로 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j) continue;
                map[i][j] = INF;
            }
        }
        
        //간선 정보 저장(이중 배열)
        for(int i = 0; i < road.length; i++){
            int x = road[i][0];
            int y = road[i][1];
            int z = road[i][2];
            
            if(map[x][y] > z){
                map[x][y] = z;
                map[y][x] = z;
            }
        }
        
        int[] arr = new int[N+1];
        
        for(int i = 2; i <= N; i++){
            if(arr[i] == 0)
                arr[i] = INF;
            else
                arr[i] = map[1][i];
        }
        
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        
        for (int i = 1; i <= N - 1; i++) { // n-1번 반복

            // extract-min
            // arr 중에 방문하지 않았고 가장 작은 값을 가지는 인덱스 찾기
            int min_idx = 1;
            int min_value = INF;
            for (int j = 2; j <= N; j++) {
                if (!visited[j] && arr[j] < min_value) {
                    min_value = arr[j];
                    min_idx = j;
                }
            }

            visited[min_idx] = true;

            // 거쳐가는게 더 빠른지 확인
            for (int j = 2; j <= N; j++) {
                if (arr[j] > arr[min_idx] + map[min_idx][j])
                    arr[j] = arr[min_idx] + map[min_idx][j];
            }
        }
        
        for (int i = 1; i <= N; i++){
            if(arr[i] <= K) 
                answer++;
        }

        return answer;
    }
}