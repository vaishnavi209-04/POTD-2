//Approach 1-Sorting-O(n log n)
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res=0;
        for(int cost:costs)
        {
            coins-=cost;
            if(coins>=0)
            res++;
            else 
            break;
        }
        return res;
    }
}