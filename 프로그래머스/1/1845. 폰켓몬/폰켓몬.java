import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> monsters = new HashSet<>();
        for (int num : nums) {
            monsters.add(num);
        }

        int maxSelect = nums.length / 2;

        return Math.min(monsters.size(), maxSelect);
    }
}