//Approach 1-Recursion + Memoization - O(n ^2)
class Solution {
    Integer[] dp;
    int n;
    public int maximumJumps(int[] nums, int target) {
        n=nums.length;
        dp=new Integer[n];
        return solve(0,nums,target);
    }
    public int solve(int i,int[] nums,int t)
    {
        if(i==n-1)
        return 0;

        if(dp[i]!=null)
        return dp[i];

        int res=-1;

        for(int j=i+1;j<n;j++)
        {
            if(Math.abs(nums[j]-nums[i])<=t)
            {
                int next=solve(j,nums,t);
                
                if(next!=-1)
                res=Math.max(res,1+next);
            }
        }

        return dp[i]=res;
    }
}
//Approach 2-Bottom up-O(n^2)
class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;
        int[] dp=new int[n];
        //mark all indices unreachable
        Arrays.fill(dp,-1);
        //start from index 0 so jumps=0
        dp[0]=0;

        for(int i=1;i<n;i++)
        {   //check all prev indices
            for(int j=0;j<i;j++)
            {//valid jump and prev index is reachable
                if(Math.abs(nums[j]-nums[i])<=target && dp[j]!=-1)
                {
                   //update max jumps
                   dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
        }
        return dp[n-1];
    }
}