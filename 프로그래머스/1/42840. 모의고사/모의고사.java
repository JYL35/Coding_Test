import java.util.ArrayList;
import java.lang.Math;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == student1[i % 5]) score1++;
            if(answers[i] == student2[i % 8]) score2++;
            if(answers[i] == student3[i % 10]) score3++;
        }
        
        int highScore = Math.max(score1, Math.max(score2, score3));
        
        if(highScore == score1) answer.add(1);
        if(highScore == score2) answer.add(2);
        if(highScore == score3) answer.add(3);
        
        return answer;
    }
}