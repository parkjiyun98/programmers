class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for(int i = 0 ; i < m ; i++) {
			map[i] = board[i].toCharArray();
		}
        while(true) {
			int count = check(m, n, map);
			if(count == 0) break;
			answer += count;
			
			drop(m, n, map);
		}
        return answer;
    }
    public void drop(int m, int n, char[][] map) {
		for(int j = 0 ; j < n ; j++) {
			for(int i = m - 1 ; i >= 0 ; i--) {
				if(map[i][j] == 'x') {
					for(int x = i - 1 ; x >= 0 ; x--) {
						if(map[x][j] != 'x') {
							map[i][j] = map[x][j];
							map[x][j] = 'x';
							break;
						}
					}
				}
			}
		}
	}

    public int check(int m, int n, char[][] map) {
		int count = 0;
		boolean[][] check = new boolean[m][n];
		
		for(int i = 0 ; i < m - 1 ; i++) {
			for(int j = 0 ; j < n - 1 ; j++) {
				if(map[i][j] == 'x') continue;
				checkFour(map, check, i, j);
			}
		}
		
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(check[i][j]) {
					count++;
					map[i][j] = 'x';
				}
			}
		}
		
		return count;
	}
    public void checkFour(char[][] map, boolean[][] check, int x, int y) {
		char block = map[x][y];
		
		for(int i = x ; i < x + 2 ; i++) {
			for(int j = y ; j < y + 2 ; j++) {
				if(map[i][j] != block) return;
			}
		}
		
		for(int i = x ; i < x + 2 ; i++) {
			for(int j = y ; j < y + 2 ; j++) {
				check[i][j] = true;
			}
		}
	}
}