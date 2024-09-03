import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder(100);
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int[][] adjMatrix = new int[N+1][N+1];
		for(int m = 0 ; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
		
		DFS(adjMatrix, new boolean[N+1], V);
		sb.append("\n");
		BFS(adjMatrix, new boolean[N+1], V);
		
		System.out.println(sb);
	
	}
	
	static void DFS(int[][] adjMatrix, boolean[] visited, int curr) {
		visited[curr] = true;
		sb.append(curr).append(" ");
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && adjMatrix[curr][i] == 1) {
				DFS(adjMatrix, visited, i);
			}
		}
	}
	
	static ArrayDeque<Integer> q = new ArrayDeque<>();
	static void BFS(int[][] adjMatrix, boolean[] visited, int curr) {
		q.offer(curr);
		visited[curr] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			sb.append(current).append(" ");
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && adjMatrix[current][i]==1) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	
}
