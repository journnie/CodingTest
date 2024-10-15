class Solution {
    public int[] solution(int brown, int yellow) {
        int i;
        int j = 0;

        for(i = 1; i <= yellow; i++) {
            if (yellow % i != 0) continue;

            j = yellow / i;

            if((i + j) * 2 + 4 == brown) break;
        }

        int width = Math.max(i, j) + 2;
        int height = Math.min(i, j) + 2;

        return new int[]{width, height};
    }
}