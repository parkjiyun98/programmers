import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        int count = 0;
        int time = 0;
        int index = 0;
        while(count < jobs.length){
            while(index < jobs.length && jobs[index][0] <= time)
                q.add(jobs[index++]);
            if(q.isEmpty())
                time = jobs[index][0];
            else{
                int[] temp = q.poll();
                answer += time + temp[1] - temp[0];
                time += temp[1];
                count++;
            }
        }
        return answer / jobs.length;
    }
}