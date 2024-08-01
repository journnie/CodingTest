import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] unclear = new int[N+1]; // 각 스테이지에 도달했으나 클리어하지 못한 사용자 수
        int[] trials = new int[N+1]; // 각 스테이지에 도달한 사용자 수
        double[][] failureRate = new double[N][2]; // 스테이지 번호와 실패율을 저장할 배열

        // 각 스테이지에 도달한 사용자 수와 아직 클리어하지 못한 사용자 수 계산
        for (int user : stages) {
            if (user <= N) unclear[user]++;
            for (int stage = 1; stage <= Math.min(user, N); stage++) {
                trials[stage]++;
            }
        }

        // 각 스테이지의 실패율 계산
        for (int stage = 1; stage <= N; stage++) {
            failureRate[stage - 1][0] = stage; // 스테이지 번호 저장
            if (trials[stage] == 0) {
                failureRate[stage - 1][1] = 0; // 해당 스테이지에 도달한 사용자가 없으면 실패율 0
            } else {
                failureRate[stage - 1][1] = (double) unclear[stage] / trials[stage]; // 실패율 계산
            }
        }

        // 실패율을 기준으로 정렬 (실패율이 같다면 스테이지 번호 기준으로 오름차순 정렬)
        Arrays.sort(failureRate, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (Double.compare(o2[1], o1[1]) == 0) {
                    return Double.compare(o1[0], o2[0]); // 스테이지 번호 오름차순 정렬
                } else {
                    return Double.compare(o2[1], o1[1]); // 실패율 내림차순 정렬
                }
            }
        });

        // 정렬된 스테이지 번호를 결과 배열에 저장
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failureRate[i][0];
        }

        return answer;
    }
}