class Solution {
    Integer[][] dp;
    public boolean stoneGame(int[] piles) {
        
        int n=piles.length;
        dp=new Integer[n][n];
        int res=solve(0,n-1,piles);
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
//Approach 2
class Solution {
    public boolean stoneGame(int[] piles) {
        //the arr is of even length
        //so alice can calculate the parity sum: even parity sum , odd parity sum 
        //and can always choose larger sum so she will always win
        return true;
    }
}