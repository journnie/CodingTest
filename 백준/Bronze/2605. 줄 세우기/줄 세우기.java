import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");

        List<Integer> line = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(tokens[i]);
            line.add(line.size() - number, i + 1);
        }

        for (int student : line) {
            System.out.print(student + " ");
        }
    }
}