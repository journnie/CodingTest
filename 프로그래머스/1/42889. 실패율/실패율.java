import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int users = stages.length;
        int[][] status = new int[N+2][2];
        
        for(int stage : stages) {
            status[stage][0]++;
            for(int s=1; s<=stage; s++){
                status[s][1]++;
            }
        }
        
        TreeMap<Integer, Double> failure = new TreeMap<>();
        
        for(int s=1; s<=N; s++){
            double rate = 0.0;
            if(status[s][1]>0) rate = (double) status[s][0]/status[s][1];
            failure.put(s, rate);
            
        }
        
        int[] answer = failure.entrySet().stream()
                              .sorted((e1, e2) -> {
                                  int cmp = e2.getValue().compareTo(e1.getValue()); 
                                  if (cmp != 0) return cmp;
                                  return e1.getKey().compareTo(e2.getKey()); 
                              })
                              .mapToInt(Map.Entry::getKey)
                              .toArray();
        return answer;
    }
}