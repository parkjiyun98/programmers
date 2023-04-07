import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int index = 0;
        int time = 0;
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        while(count < jobs.length){
            while(index < jobs.length && jobs[index][0] <= time)
                pq.add(jobs[index++]);
            if(pq.isEmpty())
                time = jobs[index][0];
            else{
                int[] temp = pq.poll();
                answer += time + temp[1] - temp[0];
                time += temp[1];
                count++;
            }
        }
        return answer / jobs.length;
    }
}