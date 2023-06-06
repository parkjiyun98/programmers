class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        Long width = Long.valueOf(w);
        Long height = Long.valueOf(h);
        
        answer = width * height - (width + height - getGCD(width, height));
        return answer;
    }
    
    //최대 공약수
    private long getGCD(long x, long y){
        long small = x;
        long big = y;
        if (y < x) {
            big = y;
            small = x;
        }
        
        long temp = 0;
        while (small > 0) {
            temp = big % small;
            
            big = small;
            small = temp;
        }
        
        return big;
    }
}