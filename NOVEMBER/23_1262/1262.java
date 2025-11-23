//Approach 1-Recursion + Memoization-O(n)
class Solution {
    Integer[][] dp;
    public int maxSumDivThree(int[] nums) {
        
        int n=nums.length;
        dp=new Integer[n][3];
        return solve(0,0,n,nums);
    }
    public int solve(int idx,int rem,int n,int[] nums)
    {
        //rem is 0 which means we found the valid subset and we are not adding anything in the end so return 0
        //if rem is not 0 that means this subset is invalid so return a very large -ve value such that Math.max(valid,invalid(-ve))= gives valid ans
        if(idx==n)
        return rem==0?0:Integer.MIN_VALUE/2;

        if(dp[idx][rem]!=null)
        return dp[idx][rem];

        int include=nums[idx]+solve(idx+1,(rem+nums[idx])%3,n,nums);
        int exclude=solve(idx+1,rem,n,nums);

        return dp[idx][rem]=Math.max(include,exclude);
    }
}