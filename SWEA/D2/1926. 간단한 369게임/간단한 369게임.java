import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            boolean clap = clapOn369(sb, i);

            if(!clap) sb.append(Integer.toString(i)).append(" ");
        }
        System.out.println(sb);
    }

    public static boolean clapOn369(StringBuilder sb, int i){
        String number = Integer.toString(i);
        char[] threeSixNine = {'3', '6', '9'};
        boolean clap = false;

        for(char num : number.toCharArray()) {
            for(char TSN : threeSixNine) {
                if(TSN == num) {
                    sb.append("-");
                    clap = true;
                }
            }
        }
        if(clap) sb.append(" ");
        return clap;
    }

}
