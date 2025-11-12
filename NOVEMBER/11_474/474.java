//Approach 1-Memoization + Recursion Dp
//T.C-O(l*m*n)
//S.C-O(l*m*n)
class Solution {
    Integer[][][] dp;
    int l;
    int[][] count;
    public int findMaxForm(String[] strs, int m, int n) {
        l=strs.length;
        dp=new Integer[l+1][m+1][n+1];

        count=new int[l][2];
        for(int i=0;i<l;i++)
        {
            String s=strs[i];
            int zero=0;
            int one=0;
            for(char ch:s.toCharArray())
            {
                if(ch=='0')
                zero++;
                else
                one++;
            }
            count[i][0]=zero;
            count[i][1]=one;
        }
        return solve(strs,0,0,0,m,n);
    }
    public int solve(String[] strs,int idx,int zeros,int ones,int m,int n)
    {
        if(idx>=l)
        return 0;
        //max capacity satisfied no need to check further
        if(zeros==m && ones ==n)
        return 0;

        //capacity out of bounds
        if(zeros>m || ones >n)
        return 0;

        if(dp[idx][zeros][ones]!=null)
        return dp[idx][zeros][ones];

        int newZeros=count[idx][0];
        int newOnes=count[idx][1];

        int take=0;
        int skip=0;
        //take
        if(zeros+newZeros <=m && ones+newOnes<=n)
        {
            take= 1 + solve(strs,idx+1,zeros+newZeros,ones+newOnes,m,n);
        }
        //not take
        skip=solve(strs,idx+1,zeros,ones,m,n);

        return dp[idx][zeros][ones]=Math.max(take,skip);
    }
}