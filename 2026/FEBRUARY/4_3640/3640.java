//Approach 1-Recursion and Memoization-O(n)
class Solution {
    int n;
    Long[][] dp;//wrapper class
    public long maxSumTrionic(int[] nums) {
        n=nums.length;
        dp=new Long[n+1][4];
        return solve(0,0,nums);//index,trend
    }
    public long solve(int i,int trend,int[] nums)
    {
        if(i==n)
        {
            if(trend==3)//reached last trend so no elements left
            return 0;
            else//didn't reach so invalid path
            return Long.MIN_VALUE/2;//to avoid overflow by long.min+long.min
        }
        if(dp[i][trend]!=null)
        return dp[i][trend];

        long take=Long.MIN_VALUE/2;//to avoid overflow
        long skip=Long.MIN_VALUE/2;
        //don't start here 
        if(trend==0)
        skip=solve(i+1,trend,nums);
        //end trend 3 here
        if(trend==3)
        take=nums[i];

        if(i+1<n)
        {
            int curr=nums[i];
            int next=nums[i+1];
            if(trend==0 && curr<next)//start trend 1
            {
                take=Math.max(take,curr+solve(i+1,1,nums));
            }
            else if(trend==1)
            {
                if(curr<next)//continue trend 1
                {
                    take=Math.max(take,curr+solve(i+1,1,nums));
                }
                else if(next<curr)//start trend 2
                {
                    take=Math.max(take,curr+solve(i+1,2,nums));
                }
            }
            else if(trend==2)
            {
                if(curr>next)//continue trend 2
                {
                    take=Math.max(take,curr+solve(i+1,2,nums));
                }
                else if(next>curr)//start trend 3
                {
                    take=Math.max(take,curr+solve(i+1,3,nums));
                }
            }
            else if(trend==3 && curr<next)//continue trend 3
            {
                take=Math.max(take,curr+solve(i+1,3,nums));
            }
        }
        return dp[i][trend]=Math.max(take,skip);
    }
}
//Approach 2-Bottom up-O(n)
class Solution {
    public long maxSumTrionic(int[] nums) {
        int n=nums.length;
        long inf=Long.MIN_VALUE/2;

        long[][] dp=new long[n+1][4];
        for(int t=0;t<4;t++)
        {
            dp[n][t]=(t==3)?0:inf;//if on starting from idx 0 we end at any trend other than 3 it's invalid path so return a very small value
        }
        for(int i=n-1;i>=0;i--)
        {
            for(int t=0;t<4;t++)
            {
                long take=inf;
                long skip=inf;

                if(t==0)
                skip=dp[i+1][0];

                if(t==3)
                take=nums[i];

                if(i+1<n)
                {
                    int curr=nums[i];
                    int next=nums[i+1];
                    if(t==0 && curr<next)
                    take=Math.max(take,curr+dp[i+1][1]);
                    else if(t==1)
                    {
                        if(curr<next)
                        take=Math.max(take,curr+dp[i+1][1]);
                        else if(curr>next)
                        take=Math.max(take,curr+dp[i+1][2]);
                    }
                    else if(t==2)
                    {
                        if(curr>next)
                        take=Math.max(take,curr+dp[i+1][2]);
                        else if(curr<next)
                        take=Math.max(take,curr+dp[i+1][3]);
                    }
                    else if(t==3 && curr<next)
                    take=Math.max(take,curr+dp[i+1][3]);
                }
                dp[i][t]=Math.max(take,skip);
            }
        }
        return dp[0][0];//start from 0 index and 0 trend
    }
}