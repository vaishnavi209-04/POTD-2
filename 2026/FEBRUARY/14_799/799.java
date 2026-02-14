//Approach 1-Recursion + Memoization-O(query_row^2)
class Solution {
    Double[][] dp;
    
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        dp=new Double[query_row+1][query_glass+1];
        //what if the target glass gets more than its fill so we will return that which will be incorrect as the glass would only get fill=1.0 rest will spill down
        return Math.min(1.0,solve(poured,query_row,query_glass));
        
    }
    public double solve(int poured,int i,int j)
    {
        if(i<0 || j<0 || i<j)
        return 0.0;

        if(dp[i][j]!=null)
        return dp[i][j];

        if(i==0 && j==0)//the top glass
        return poured;
        //the curr glass gets filled by got-1.0 and rest spills both sides so divide by 2
        double leftUp=(solve(poured,i-1,j-1)-1)/2.0;
        double rightUp=(solve(poured,i-1,j)-1)/2.0;
        //what if the above glass was empty or not full so it will return -ve which we should not add
        return dp[i][j]=(leftUp<0?0:leftUp) + (rightUp<0?0:rightUp);
    }
}
//Approach 2-Bottom up-(query_row^2)
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp=new double[query_row+2][query_row+2];
        dp[0][0]=(double)poured;

        for(int i=0;i<=query_row;i++)
        {
            for(int j=0;j<=i;j++)
            {
                double extra=(dp[i][j]-1)/2.0;
                if(extra>0)
                {
                    dp[i+1][j+1]+=extra;
                    dp[i+1][j]+=extra;
                }
            }
        }
        return Math.min(1.0,dp[query_row][query_glass]);
    }
}