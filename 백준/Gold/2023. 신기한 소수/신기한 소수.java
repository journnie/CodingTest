import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String wowPrime = "";
        getWowPrime(N, wowPrime);

    }

    static void getWowPrime(int N, String wowPrime) {
        if (N == 0) {
            if(isPrime(wowPrime)) {
                System.out.println(wowPrime);
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            char c = (char) ((char) i + '0');
            if(isPrime(wowPrime+c))
                getWowPrime(N-1,wowPrime+c);
        }
    }

    static boolean isPrime(String wowPrime) {
        int wowPrimeNum = Integer.parseInt(wowPrime);
        if (wowPrimeNum == 1) return false;
        for (int i = 2; i <= Math.sqrt(wowPrimeNum); i++) {
            if (wowPrimeNum % i == 0) return false;
        }
        return true;
    }
}
