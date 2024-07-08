class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int y = x;
        while(y > 0){
            sum += y % 10;
            y /= 10;
        }

        if(x % sum == 0)
            return true;
        else
            return false;
    }
}