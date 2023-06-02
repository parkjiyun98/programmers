import java.util.*;

class Solution {
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
 
        for (int i = 0; i < 5; i++) {
            String[] temp = places[i];
 
            boolean check = true;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (temp[j].charAt(k) == 'P') {
                        if (!bfs(j, k, temp))
                            check = false;
                    }
                }
            }
            if(check == true)
                answer[i] = 1;
            else
                answer[i] = 0;
        }
 
        return answer;
    }
 
    private static boolean bfs(int x, int y, String[] s) {
        int dx[] = { -1, 1, 0, 0 };
        int dy[] = { 0, 0, -1, 1 };
 
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] { x, y });
 
        while (!q.isEmpty()) {
            int[] temp = q.poll();
 
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
 
                //탐색 범위 초과, 최초 출발점을 탐색에서 제외
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx == x && ny == y))
                    continue;
 
                //맨해튼 거리
                int m = Math.abs(nx - x) + Math.abs(ny - y);
 
                //p가 맨해튼 거리 안에 있다면
                if (s[nx].charAt(ny) == 'P' && m <= 2)
                    return false;
                //O을 발견하면 O 중심으로 다시 탐색
                else if (s[nx].charAt(ny) == 'O' && m < 2)
                    q.add(new int[] { nx, ny });
            }
        }
 
        return true;
    }
}