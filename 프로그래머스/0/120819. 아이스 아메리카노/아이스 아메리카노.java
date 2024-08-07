class Solution {
    public int[] solution(int money) {
        int priceOfAmericano = 5500;
        int maxCups = money / priceOfAmericano; 
        int remainingMoney = money % priceOfAmericano; 
        return new int[] {maxCups, remainingMoney};
    }
}