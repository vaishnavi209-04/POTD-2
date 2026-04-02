//Approach 1-Recursion + Memoization -O(m * n *3)
class Solution {
    int m;
    int n;
    Integer[][][] dp;
    public int maximumAmount(int[][] coins) {

        m=coins.length;
        n=coins[0].length;
        dp=new Integer[m][n][3];
        return solve(0,0,coins,2);
    }
    public int solve(int i,int j,int[][] coins,int save)
    {
       if(i==m-1 && j==n-1)//reached last cell
       {
        if(coins[i][j]<0 && save > 0)//last cell has a thief but ability is left
        return dp[i][j][save]= 0;

        return dp[i][j][save]= coins[i][j];//return last cell money
       }
        
       if(dp[i][j][save]!=null)
       return dp[i][j][save];

       int right=Integer.MIN_VALUE;
       int down=Integer.MIN_VALUE;
       if(j+1 < n)// exploring right direction
       {
        if(coins[i][j]<0)//encountered a thief
        {
            if(save > 0)//ability is left
            {
                right=Math.max(solve(i,j+1,coins,save-1),coins[i][j] + solve(i,j+1,coins,save));//want to neutralize or not
            }
            else
            {
              right=coins[i][j] + solve(i,j+1,coins,save);//save not left
            }
        }
        else
        {
            right=coins[i][j] + solve(i,j+1,coins,save);//no thief
        }
       }

       if(i+1 < m)//exploring down direction
       {
        if(coins[i][j]<0)//encountered a thief
        {
            if(save > 0)//ability left
            {
                down=Math.max(solve(i+1,j,coins,save-1),coins[i][j] + solve(i+1,j,coins,save));//want to neutralize or not
            }
            else
            {
              down=coins[i][j] + solve(i+1,j,coins,save);//save not left
            }
        }
        else
        {
            down=coins[i][j] + solve(i+1,j,coins,save);//no thief
        }
       }
       return dp[i][j][save] = Math.max(right,down);

    }
}
//Approach 2-Bottom up -O(m * n *3)
class Solution {
    public int maximumAmount(int[][] coins) {

        int m=coins.length;
        int n=coins[0].length;
        int[][][] dp=new int[m][n][3];
        for(int[][] arr:dp)
        {
            for(int[] a:arr)
            {
                Arrays.fill(a,Integer.MIN_VALUE);
            }
        }
        //base case
        if(coins[0][0]<0)
        {
            dp[0][0][2]=coins[0][0];//take
            dp[0][0][1]=0;//neutralize
        }
        else
        dp[0][0][2]=coins[0][0];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<3;k++)
                {
                    if(dp[i][j][k]==Integer.MIN_VALUE)//because we start with already reached cells
                    continue;

                    if(j+1 < n)//right
                    {
                        int val=coins[i][j+1];
                        dp[i][j+1][k]=Math.max(dp[i][j+1][k],val + dp[i][j][k]);//take

                        if(val<0 && k>0)
                        {
                            dp[i][j+1][k-1]=Math.max(dp[i][j+1][k-1],dp[i][j][k]);//neutralize
                        }
                    }

                    if(i+1 < m)//down
                    {
                        int val=coins[i+1][j];
                        dp[i+1][j][k]=Math.max(dp[i+1][j][k],val + dp[i][j][k]);//take

                        if(val<0 && k>0)
                        {
                            dp[i+1][j][k-1]=Math.max(dp[i+1][j][k-1],dp[i][j][k]);//neutralize
                        }
                    }
                }
            }
        }
        int res=Integer.MIN_VALUE;
        for(int k=0;k<3;k++)
        {
            res=Math.max(res,dp[m-1][n-1][k]);//we can have saves 0,1,2
        }
        return res;
        

    }
}
