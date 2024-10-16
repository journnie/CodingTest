class Solution {
    static boolean[] visited;
    static int maxCount;

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        maxCount = -1;
        explore(k, 0, dungeons);
        return maxCount;
    }

    public static void explore(int hp, int count, int[][] dungeons) {
        maxCount = Math.max(maxCount, count);
        if(count == dungeons.length) return;

        for(int d = 0; d < dungeons.length; d++) {
            if(visited[d] || hp < dungeons[d][0]) continue;
            visited[d] = true;
            explore(hp - dungeons[d][1], count+1, dungeons);
            visited[d] = false;
        }

    }
}