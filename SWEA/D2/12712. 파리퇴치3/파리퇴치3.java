import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= T; t++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			// 파리 배열 생성
			int[][] flies = new int[N][N];
			for(int line = 0; line < N; line++) {
				String[] flyLine = br.readLine().split(" ");
				for(int fly = 0; fly < N; fly++) {
					flies[line][fly] = Integer.parseInt(flyLine[fly]);
				}
			}
			
			// 십자 살충제
			int maxCross = 0;
			int currentCross;
			// 가로
			for(int row = 0; row < N; row++) {			
				for(int col = 0; col < N; col++) {
					currentCross = flies[row][col];
					for(int i=1; i<M; i++) {
						if((col+i) < N) currentCross += flies[row][col+i]; //우
						if((col-i) >= 0) currentCross += flies[row][col-i]; // 좌
						if((row+i) < N) currentCross += flies[row+i][col]; // 하
						if((row-i) >= 0) currentCross += flies[row-i][col]; // 상
					}
					maxCross = Math.max(maxCross, currentCross);
				}
			}
			// X자 살충제
			int maxX = 0;
			int currentX;
			// 가로
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) {
					currentX = flies[row][col];
					for(int i=1; i<M; i++) {
						if((row-i) >= 0 && (col-i) >= 0) currentX += flies[row-i][col-i]; // 좌상
						if((row-i) >= 0 && (col+i) < N) currentX += flies[row-i][col+i]; // 우상
						if((row+i) < N && (col-i) >= 0) currentX += flies[row+i][col-i]; // 좌하
						if((row+i) < N && (col+i) < N) currentX += flies[row+i][col+i]; // 우상

					}
					maxX = Math.max(maxX, currentX);
				}
			}
			
			System.out.printf("#%d %d\n", t, Math.max(maxX, maxCross));			

		}
	}

}
