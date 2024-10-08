import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count;
    static int[] array;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        array = new int[N+1];
        MakeSet();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        count = 0;
        for(int i = 2; i <= N; i++){
            if(find(1) == find(i)) count++;
        }

        System.out.println(count);
    }

    static void MakeSet() {
        for(int i = 0; i <= N; i++) {
            array[i] = i;
        }
    }

    static int find(int x) {
        if (array[x] != x) {
            array[x] = find(array[x]); // 부모를 루트로 갱신
        }
        return array[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            array[rootB] = rootA; // rootB의 부모를 rootA로
        }
    }
}
