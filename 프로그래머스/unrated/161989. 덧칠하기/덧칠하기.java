class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paintIdx = 0;
        
        for (int i = 0; i < section.length; i++) {
          if (section[i] < paintIdx) {
              continue;
          }

          answer += 1;
          paintIdx = section[i] + m;
      }
        return answer;
    }
}