import java.io.*;

public class Main {
    static int[][] board = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++) {
            String[] line = br.readLine().trim().split(" ");
            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        int call = winBingo(br);
        System.out.println(call);
    }
    
    static int winBingo(BufferedReader br) throws IOException{
        int call = 0;
        for(int i = 0; i < 5; i++) {
            String[] numbers = br.readLine().trim().split(" ");
            for(int j = 0; j < 5; j++) {
                int number = Integer.parseInt(numbers[j]);
                call++;
                markOnBoard(number);
                if(isBingo()) return call;
            }
        }
        return -1;
    }

    static void markOnBoard(int number){
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(board[i][j] == number) board[i][j] = 0;
            }
        }
    }

    static boolean isBingo(){
        int bingo = 0;

        for(int i = 0; i < 5; i++) {
            int rowSum = 0;
            for(int j = 0; j < 5; j++) {
                rowSum += board[i][j];
            }
            if(rowSum == 0) bingo++;
        }

        for(int j = 0; j < 5; j++) {
            int colSum = 0;
            for(int i = 0; i < 5; i++) {
                colSum += board[i][j];
            }
            if(colSum == 0) bingo++;
        }

        int diagSum = 0;
        int oppositeDiagSum = 0;
        for(int i = 0; i < 5; i++) {
            diagSum += board[i][i];
            oppositeDiagSum += board[i][5-i-1];
        }

        if(diagSum == 0) bingo++;
        if(oppositeDiagSum == 0) bingo++;

        return (bingo >= 3);
    }
}
