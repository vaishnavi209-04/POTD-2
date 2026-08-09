//Approach 1:Recursion + Memoization-O(n^3)
class Solution {

    Integer[][] dp;
    int n;
    public int stoneGameII(int[] piles) {
        n=piles.length;
        
        dp=new Integer[n][n+1];
        int[] suffix=new int[n+1];
        //precompute rem from each index
        for(int i=n-1;i>=0;i--)
        {
            suffix[i]=suffix[i+1]+piles[i];
        }
        
        return solve(0,1,suffix); 
    }
    public int solve(int i,int take,int[] suffix)
    {   //if can take remaining all piles
        if(i+2*take>=n)
        return suffix[i];

        if(dp[i][take]!=null)
        return dp[i][take];

        int best=0;
        for(int x=1;x<=2*take;x++)//dp has n^2 states and work done inside each state here is n so n^3
        {//calculate opponents piles
            int bob=solve(i+x,Math.max(take,x),suffix);
        //for alice rem-bub
            int curr=suffix[i]-bob;
            best=Math.max(best,curr);
            
        }
        return dp[i][take]=best;
    }
}