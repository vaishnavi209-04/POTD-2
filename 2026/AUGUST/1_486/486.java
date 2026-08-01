//Approach 1-Recursion + Memoization -O(n^2)
//we have to calc diff in score if our diff>=opponent we win
class Solution {
    Integer[][] dp;
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        dp=new Integer[n][n];
        int res=solve(0,n-1,nums);
        return res>=0;
    }
    public int solve(int i,int j,int[] nums)
    {
        if(i==j)
        return nums[i];

        if(dp[i][j]!=null)
        return dp[i][j];
        //now opponent can pick optimally from (i+1,j)
        int left=nums[i]-solve(i+1,j,nums);
        int right=nums[j]-solve(i,j-1,nums);

        return dp[i][j]=Math.max(left,right);
    }
}