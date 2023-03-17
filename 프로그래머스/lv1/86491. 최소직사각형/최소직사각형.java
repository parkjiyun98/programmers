class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int xMax=0;
        int yMax=0;
        for(int i=0;i<sizes.length;i++){
            int x = Math.max(sizes[i][0],sizes[i][1]);
            int y = Math.min(sizes[i][0],sizes[i][1]);
            xMax = Math.max(xMax,x);
            yMax = Math.max(yMax,y);
        }
        answer = xMax * yMax;
        return answer;
        
    }
}