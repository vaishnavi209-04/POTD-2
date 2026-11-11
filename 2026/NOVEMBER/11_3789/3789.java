//Approach 1:Greedy-O(1)
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long total=0;
        if(cost1+cost2<=costBoth)
        {
            total=1L*cost1*need1+1L*cost2*need2;
        }
        else
        {
            int count=Math.min(need1,need2);
            total=1L*count*costBoth;
            need1-=count;
            need2-=count;

            if(need1>0)
            {
                total+=1L*need1*Math.min(cost1,costBoth);
            }else if(need2>0)
            {
                total+=1L*need2*Math.min(cost2,costBoth);
            }
        }
        return total;
    }
}