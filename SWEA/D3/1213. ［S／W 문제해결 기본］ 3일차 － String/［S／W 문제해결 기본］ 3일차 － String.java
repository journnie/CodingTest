import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 입력 파일 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10; // 테스트 케이스 수
        for (int tc = 0; tc < T; tc++) {
            int testcase = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
            String pattern = br.readLine().trim(); // 패턴 문자열
            String text = br.readLine().trim(); // 텍스트 문자열

            int tLen = text.length(); // 텍스트 길이
            int pLen = pattern.length(); // 패턴 길이

            int inText = 0; // 패턴 등장 횟수

            // 패턴이 텍스트 내에서 몇 번 나타나는지 확인
            for (int t = 0; t <= tLen - pLen; t++) {
                int p = 0;
                for ( p = 0; p < pLen; p++) {
                    if (text.charAt(t + p) != pattern.charAt(p)) break;
                }
                if (p == pLen) inText++; // 패턴이 일치하면 카운트 증가
            }

            System.out.printf("#%d %d\n", testcase, inText);
        }

        br.close(); // BufferedReader 닫기
    }
}