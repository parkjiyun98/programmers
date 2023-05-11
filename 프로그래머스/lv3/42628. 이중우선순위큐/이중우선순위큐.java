import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        for (String operation : operations) {
            String[] arr = operation.split(" ");

            if (arr[0].equals("I")) {
                maxQ.add(Integer.parseInt(arr[1]));
                minQ.add(Integer.parseInt(arr[1]));
            }

            if (arr[0].equals("D")) {
                if (!maxQ.isEmpty()) {
                    if (arr[1].equals("1")) {
                        int max = maxQ.peek();
                        maxQ.remove(max);
                        minQ.remove(max);

                    } else {
                        int min = minQ.peek();
                        maxQ.remove(min);
                        minQ.remove(min);
                    }
                }
            }

        }
        if (!maxQ.isEmpty()) {
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();

        }
        return answer;
    }
}