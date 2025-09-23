import java.util.HashMap; 

class Solution {
    public int[] solution(int N, int[] stages) {
        // 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        int[] cleared = new int[N+2]; // 몽땅 클리어한 사람은 N+1 stage
        int[] stays = new int[N+2]; // 클리어 못한 사람
        
        HashMap<Integer, Double> failure = new HashMap<>();
        
        int total = stages.length;
        
        // 각 스테이지별 도달한 플레이어 수
        for(int stage :  stages) {
            for (int s = 1; s <= stage; s++) {
                cleared[s]++;
            }
            
            stays[stage]++;
            
        }
        
        for(int s = 1; s <= N; s++) {
            if(cleared[s] == 0) {
                failure.put(s, 0.0);
            }
            else {
                failure.put(s, (stays[s]*1.0)/cleared[s]);
            }
            

        }
        
        
        
        return failure.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}