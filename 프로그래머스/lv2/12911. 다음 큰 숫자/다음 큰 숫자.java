class Solution {
    public int solution(int n) {
        int answer = 0;
        int nUp = n+1;
        String nTemp = Integer.toString(n, 2);
        nTemp = nTemp.replace("0", "");
        while(true){
            String nUpTemp = Integer.toString(nUp, 2);
            nUpTemp = nUpTemp.replace("0", "");
            if(nTemp.length() == nUpTemp.length()){
                answer = nUp;
                break;
            }
            else
                nUp++;
        }
        return answer;
    }
}