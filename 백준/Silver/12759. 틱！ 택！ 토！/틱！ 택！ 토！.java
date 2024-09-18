import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Main {
    static int N, firstPlayer, secondPlayer, wins, turn;
    static boolean onGame;
    static int[][] board;
    // 상좌 상 상우 우 우하 하 좌하 좌
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = 3;
        firstPlayer = Integer.parseInt(br.readLine());
        secondPlayer = (firstPlayer == 1)? 2: 1;

        wins = 0;
        board = new int[N+1][N+1];
        onGame = true;
        for(turn = 1; turn <= 9; turn++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(turn % 2 == 1){
                board[x][y] = 1;
            }
            else {
                board[x][y] = -1;
            }
            if(turn > 4) inARow();
            if(!onGame) break;
        }


        System.out.println(wins);

    }

    static int sumRow, sumCol, sumDiag, sumRDiag;
    static void inARow() {

        sumDiag = 0;
        sumRDiag = 0;
        for(int i = 1; i <= N; i++) {
            sumRow = 0;
            sumCol = 0;
            for(int j = 1; j <= N; j++) {
                sumRow += board[i][j];
                sumCol += board[j][i];
                if(check()) break;
            }
            sumDiag += board[i][i];
            sumRDiag += board[i][N-i+1];
            if(check()) break;

        }

        if(turn == 9) {
            onGame = false;
            return;
        }
        
    }

    static boolean check() {
        if(sumRow == 3 || sumCol == 3 || sumDiag == 3 || sumRDiag == 3){
            onGame = false;
            wins = firstPlayer;
            return true;
        }

        if(sumRow == -3 || sumCol == -3 || sumDiag == -3 || sumRDiag == -3){
            onGame = false;
            wins = secondPlayer;
            return true;
        }
        return false;
    }

}
