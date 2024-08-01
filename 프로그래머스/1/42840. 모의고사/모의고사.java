import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[][] students = new int[3][];
        int[] scores = new int[3];

        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = { 2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        students[0] = student1;
        students[1] = student2;
        students[2] = student3;

        for (int i = 0; i < answers.length; i++){
            for(int s = 0; s < 3; s++) {
                int[] student = students[s];
                if(answers[i] == student[i%student.length]) scores[s]++;
            }
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        List<Integer> answer = new ArrayList<>();
        for(int s = 0; s < 3; s++) {
            int score = scores[s];
            if(score == maxScore) answer.add(s+1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}