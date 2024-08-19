import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] arr = br.readLine().toCharArray(); // 창고의 상태
		
		int robot = 0; // 로봇의 인덱스
		int box = 0; // 박스의 인덱스
		int goal = 0; // 목표 지점 인덱스
		
		for (int i = 0; i < 10; i++) {
			if (arr[i] == '@') {
				robot = i;
			} else if (arr[i] == '#') {
				box = i;
			} else if (arr[i] == '!') {
				goal = i;
			}
		}
		
		int count = 0;
		if (robot < box && goal < box) { // 박스를 오른쪽으로 밀 때, 목표 지점이 왼쪽이라면
			count = -1;
		} else if (robot > box && goal > box) { // 박스를 왼쪽으로 밀 때, 목표 지점이 오른쪽이라면
			count = -1;
		} else { // 박스를 목표 지점까지 갈 수 있다면
			count = Math.abs(robot - goal) - 1;
		}
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}
}