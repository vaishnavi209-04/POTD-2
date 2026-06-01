//Approach 1-Sorting + Greedy - O(n log n)
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res=0;
        int n=cost.length;
        for(int i=n-1;i>=0;i--)
        {
           res+=cost[i--];
           if(i<0)
           break;
           res+=cost[i--];
        }
        return res;
    }
}