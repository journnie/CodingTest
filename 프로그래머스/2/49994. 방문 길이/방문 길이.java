import java.util.*;

class Solution {
    // 좌표 안에 있는지
    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny <11;
    }
    
    // 다음 좌표를 위한 해시맵
    private static final HashMap<Character, int[]> location = new HashMap<>();
    
    // 방향 이동
    private static void initLocation() {
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('L', new int[]{-1,0});
        location.put('R', new int[]{1,0});
    }
    
    public int solution(String dirs) {
        initLocation();
        
        int x = 5, y = 5;   // 위치 초기화
        
        Set<String> answer = new HashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i)); // 이동 좌표
            int nx = x + offset[0];
            int ny = y + offset[1];
            
            if (!isValidMove(nx, ny)) continue;
            
            answer.add(x+"."+y+"."+nx+"."+ny);
            answer.add(nx+"."+ny+"."+x+"."+y);
            
            x = nx;
            y = ny;
        }

        return answer.size()/2;
    }
}