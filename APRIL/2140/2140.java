//Approach 1:Dynamic Programming-O(n) due to memorisation
class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] dp=new long[n+1];//memorisation
        Arrays.fill(dp,-1);
        return solve(questions,n,0,dp);
    }
    public long solve(int[][] questions,int n,int i,long[] dp)
    {
        if(i>=n)
        return 0;
        if(dp[i]!=-1)
        return dp[i];
        long take=questions[i][0] +solve(questions,n,i+questions[i][1]+1,dp);//if taken then can't solve questions[i][1] and taking current so +1
        long skip=solve(questions,n,i+1,dp);//if skip then go on next
        return dp[i]=Math.max(skip,take);
    }
}