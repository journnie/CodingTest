import java.io.*;
import java.util.*;

public class Solution {
    static List<Integer>[] contacts = new ArrayList[101];
    static int[] visited;
    static List<Integer> contacted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            sb.append("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            int dataNum = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            for(int i = 1; i <= 100; i++) {
                contacts[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int data = 0; data < dataNum/2; data++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                contacts[from].add(to);
            }

            visited = new int[101];

            int end = bfs(start);

            sb.append(end + "\n");
        }
        System.out.println(sb);
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1; 

        int maxContact = start;
        int maxDepth = 1;

        while (!queue.isEmpty()) {
            int from = queue.poll();
            int currentDepth = visited[from]; 

            for (int contact : contacts[from]) {
                if (visited[contact] != 0) continue;
                
                queue.add(contact);
                visited[contact] = currentDepth + 1; 

                if (visited[contact] > maxDepth) {
                    maxDepth = visited[contact];
                    maxContact = contact;
                } else if (visited[contact] == maxDepth) {
                    maxContact = Math.max(maxContact, contact);
                }
            }
        }

        return maxContact;
    }
}
