import java.util.*;

class Solution {
    static List<Integer> primeNumbers;
    static List<String> combinations;
    static int[] numbersArr;
    static boolean[] visited;
    
    public int solution(String numbers) {
        numbersArr = new int[numbers.length()];
        for (int i = 0; i < numbersArr.length; i++) {
            numbersArr[i] = numbers.charAt(i) - '0';
        }
        primeNumbers = new ArrayList<>();
        combinations = new ArrayList<>();
        visited = new boolean[numbers.length()];
        String numbersStr = "";

        combination(numbersStr, numbers, 0);

        for(String numStr : combinations) {
            isPrime(numStr);
        }

        return primeNumbers.size();

    }

    public void combination(String numbersStr, String numbers, int count) {
        if(count >= numbers.length()) return;

        for (int i = 0; i < numbersArr.length; i++) {
            if(visited[i]) continue;
            String newNumber = numbersStr + numbers.charAt(i);
            visited[i] = true;
            combinations.add(newNumber);
            combination(newNumber, numbers, count + 1);
            visited[i] = false;
        }
    }

    public void isPrime(String numberStr) {
        int number = Integer.parseInt(numberStr);

        if (number < 2) return;

        for(int num:primeNumbers){
            if(number == num) return;
        }

        for(int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return;
        }
        primeNumbers.add(number);
    }

}