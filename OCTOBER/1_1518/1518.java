class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
       int consumed=numBottles;
       int empty=numBottles;
       while(empty>=numExchange)
       {
        consumed+=empty/numExchange;
        empty=empty%numExchange+empty/numExchange;
       }
       return consumed;
    }
}