import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] WH = br.readLine().split(" ");
        String[] PQ = br.readLine().split(" ");
        int w = Integer.parseInt(WH[0]);
        int h = Integer.parseInt(WH[1]);
        int p = Integer.parseInt(PQ[0]);
        int q = Integer.parseInt(PQ[1]);
        int t = Integer.parseInt(br.readLine());

        p = (p + t) % (2 * w);
        if(p > w) p =  2 * w - p;
        q = (q + t) % (2 * h);
        if(q > h) q = 2 * h - q;

        System.out.print(p + " " + q);
    }
}
