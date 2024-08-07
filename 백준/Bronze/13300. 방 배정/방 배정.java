import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] students = new int[7][3]; // 학년 여 남
        // N(총학생), K(최대인원)
        String[] NK = br.readLine().trim().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        for (int i = 0; i < N; i++) {
            // S(여: 0 남: 1), Y(학년)
            String[] student = br.readLine().trim().split(" ");
            int gender = Integer.parseInt(student[0]);
            int year = Integer.parseInt(student[1]);
            students[year][gender+1]++;
        }

        int totalRooms = 0;
        for (int year = 0; year < students.length; year++) {
            for (int gender = 0; gender < students[year].length; gender++) {
                int extraroom = 1;
                if(students[year][gender]%K == 0) extraroom = 0;
                totalRooms += students[year][gender]/K + extraroom;
            }
        }
        System.out.println(totalRooms);

    }
}
