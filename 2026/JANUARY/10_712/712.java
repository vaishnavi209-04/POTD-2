//Approach 1-Recursion + Memoization-O(m*n)
class Solution {
    Integer[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        dp=new Integer[s1.length()][s2.length()];
        return solve(s1,s2,0,0);
    }
    public int solve(String s1,String s2,int i,int j)
    {
        if(i>=s1.length() && j>=s2.length())//both strings finished
        return 0;

        if(i>=s1.length())//s1 finished but s2 left so delete all left characters of s2
        {
            int sum=0;
            for(int k=j;k<s2.length();k++)
            sum+=s2.charAt(k);
            return sum;
        }

        if(j>=s2.length())//s2 finished but s1 left so delete all left characters of s1
        {
            int sum=0;
            for(int k=i;k<s1.length();k++)
            sum+=s1.charAt(k);
            return sum;
        }

        if(dp[i][j]!=null)
        return dp[i][j];

        int res;
        if(s1.charAt(i)==s2.charAt(j))//character matches so no deletion move ahead
        {
            res=solve(s1,s2,i+1,j+1);
        }
        else//min(delete char of s1,delete char of s2)
        {
            res=Math.min(s1.charAt(i) + solve(s1,s2,i+1,j),s2.charAt(j) +  solve(s1,s2,i,j+1));
        }

        return dp[i][j]=res;
    }
}