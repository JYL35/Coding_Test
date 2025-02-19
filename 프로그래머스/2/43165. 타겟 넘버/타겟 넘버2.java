import java.util.*;

class Solution {
    
    public int solution(int[] numbers, int target) {
        int answer = DFS(numbers, 0, 0, target);
        
        return answer;
    }
    
    public static int DFS(int[] numbers, int sum, int index, int target) {
        if(index == numbers.length) {
            if(sum == target) return 1;
            return 0;
        }
        return DFS(numbers, sum+numbers[index], index+1, target) +
            DFS(numbers, sum-numbers[index], index+1, target);
    }
}
