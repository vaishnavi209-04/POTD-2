//Approach 1:O(n root n)
class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp=new boolean[n+1];
        //base case: dp[0]=false;
        for(int i=1;i<=n;i++)
        {//for i-j*j to be>=0 loop will be till i only
            for(int j=1;j*j<=i;j++)
            {//If after removing j*j stones we reach a losing state, then current state is winning
            //If I can make my opponent enter a losing position, I win.
                if(!dp[i-j*j])
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}