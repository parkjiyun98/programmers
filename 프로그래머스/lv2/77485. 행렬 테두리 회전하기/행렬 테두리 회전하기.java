class Solution {
    int[][] matrix;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        matrix = new int[rows][columns];
        
        for(int i = 0; i < rows; i++){  // 행렬 초기화
            for(int j = 0; j < columns; j++){
                matrix[i][j] = i*columns + j + 1;
            }
        }
        
        for(int i = 0; i < queries.length; i++){ // 회전하고 최솟값 answer에 저장
            answer[i] = rotate(queries[i]);
        }
        
        return answer;
    }
    
    public int rotate(int[] query){
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;
        
        int temp = matrix[x1][y1]; // 시작위치 값 임시저장
        int min = temp;  // min값 초기화
        
        for(int i = x1; i < x2; i++){ // 회전의 1번
            matrix[i][y1] = matrix[i+1][y1];
            if(min > matrix[i][y1])
                min = matrix[i][y1];
        }
        
        for(int i = y1; i < y2; i++){ // 회전의 2번
            matrix[x2][i] = matrix[x2][i+1];
            if(min > matrix[x2][i]) 
                min = matrix[x2][i];
        }
        
        for(int i = x2; i > x1; i--){ // 회전의 3번
            matrix[i][y2] = matrix[i-1][y2];
            if(min > matrix[i][y2]) 
                min = matrix[i][y2];
        }
        
        for(int i = y2; i > y1; i--){ // 회전의 4번
            matrix[x1][i] = matrix[x1][i-1];
            if(min > matrix[x1][i]) 
                min = this.matrix[x1][i];
        }
        
        matrix[x1][y1+1] = temp; // 임시저장한 값 저장
        
        return min; //최솟값 반환
    }
}