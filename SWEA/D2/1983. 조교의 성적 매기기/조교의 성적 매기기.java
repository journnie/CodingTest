import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            String[] NK = br.readLine().split(" ");
            int students = Integer.parseInt(NK[0]);
            int studentK = Integer.parseInt(NK[1])-1;

            double[] scores = new double[students];
            double[] ranks = new double[students];
            String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

            for(int student = 0; student < students; student++) {
                String[] scoresStr = br.readLine().split(" ");
                int midScore = Integer.parseInt(scoresStr[0]);
                int finScore = Integer.parseInt(scoresStr[1]);
                int assScore = Integer.parseInt(scoresStr[2]);

                double score = 0.35 * midScore + 0.45 * finScore + 0.2 * assScore;
                scores[student] = score;
                ranks[student] = score;
            }

            for (int i = 0; i < students - 1; i++) {
                for (int j = 0; j < students - 1 - i; j++) {
                    if (ranks[j] < ranks[j + 1]) {
                        double temp = ranks[j];
                        ranks[j] = ranks[j + 1];
                        ranks[j + 1] = temp;
                    }
                }
            }

            int KRank = 0;
            for(int rank = 0; rank < students; rank++) {
                if(ranks[rank] == scores[studentK]) {
                    KRank = rank;
                    break;
                }
            }

            int gradeIdx = KRank / (students / 10);
            String KGrade = grades[gradeIdx];

            System.out.printf("#%d %s\n", t, KGrade);
        }

    }
}