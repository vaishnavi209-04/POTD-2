//Approach 1:DP + Memorisation-O(n * target)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums)
        {
            sum+=num;
        }
        if(sum%2!=0)//since the sum of two subsets must be equal it should be even 
        return false;
        int target=sum/2;
        Boolean[][] dp=new Boolean[nums.length][target+1];//Use wrapper class of boolean=Boolean for using null as default values to check for memorisation in dp
        return solve(nums,0,target,dp);
    }
    public boolean solve(int[] nums,int i,int remaining,Boolean[][] dp)
    {
       if(remaining==0)//target achieved
       return true;
       if(i>=nums.length || remaining <0)//target can't be achieved
       return false;
       if(dp[i][remaining]!= null)//already calculated earlier
       return dp[i][remaining];
       return dp[i][remaining]=solve(nums,i+1,remaining-nums[i],dp) || solve(nums,i+1,remaining,dp);
       //take or not take
    }
}