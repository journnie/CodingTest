import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String[] NMK = br.readLine().split(" ");
            int numCustomers = Integer.parseInt(NMK[0]);
            int makingTime = Integer.parseInt(NMK[1]);
            int breadPerTime = Integer.parseInt(NMK[2]);

            String[] customerStr = br.readLine().split(" ");
            int[] customers = new int[numCustomers+1];
            for(int customer = 0; customer < numCustomers; customer++){
                customers[customer+1] = Integer.parseInt(customerStr[customer]);
            }
            Arrays.sort(customers);

            boolean availability = false;
            for(int customer = 1; customer <= numCustomers; customer++){
                int currentTime = customers[customer];
                int bread = (currentTime/makingTime)*breadPerTime;
                // 손님이 도착하기 전에 붕어빵 준비 되어있어야 함
                availability = (bread >= customer);
                if(!availability) break;
            }
            
            String possibility = (availability)? "Possible": "Impossible";
            System.out.printf("#%d %s\n", t, possibility);
        }
    }
}
