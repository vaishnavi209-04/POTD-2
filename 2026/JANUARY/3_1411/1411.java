//Approach 1-Recursion + Memoization -O(n*12*12*3)
class Solution {
    //all possible states for first row
    String[] states={"RYG","RGY","RYR","RGR","GRY","GYR","GYG","GRG","YGY","YRY","YRG","YGR"};
    int mod=1_000_000_007;
    Integer[][] dp;//memoization
    
    public int numOfWays(int n) {
        dp=new Integer[n][12];
        int res=0;
        for(int i=0;i<12;i++)
        {
            res=(res + solve(n-1,i))%mod;//find for n-1 rows
        }

        return res;
    }
    public int solve(int n,int prev)
    {
        if(n==0)
        return 1;

        if(dp[n][prev]!=null)
        return dp[n][prev];
        
        int res=0;
        String last=states[prev];//prev row

        for(int curr=0;curr<12;curr++)
        {
            if(curr==prev)
            continue;

            boolean same=false;
            String currSt=states[curr];//curr row
            
            for(int col=0;col<3;col++)
            {
                if(last.charAt(col)==currSt.charAt(col))//check for color between curr and prev row
                {
                    same=true;
                    break;
                }
            }
            if(!same)
           {
                res=(res + solve(n-1,curr))%mod;
           }
        }

        return dp[n][prev]=res;
    }
}