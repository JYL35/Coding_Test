import java.util.*;

class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        recursive(numbers, 0, 0, target);
        
        return answer;
    }
    
    public static void recursive(int[] numbers, int sum, int index, int target) {
        if(index == numbers.length - 1) {
            if(sum + numbers[index] == target) answer++;
            if(sum - numbers[index] == target) answer++;
        }
        else {
            recursive(numbers, sum+numbers[index], index+1, target);
            recursive(numbers, sum-numbers[index], index+1, target);
        }
    }
}