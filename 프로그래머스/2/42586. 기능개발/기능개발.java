import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int count = 0, index = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        while(index < progresses.length) {
            for (int i = index; i < progresses.length; i++) {
                if (progresses[i] < 100) {
                    progresses[i] += speeds[i];
                }
            }
            while(progresses[index] >= 100){
                index++;
                count++;
                if(index >= progresses.length || progresses[index] < 100) {
                    queue.add(count);
                    count = 0;
                    break;
                }
            }
        }
        int[] answer = new int[queue.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = queue.remove();
        }
        
        return answer;
    }
}