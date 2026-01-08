//Approach 1-Dp-O(m*n)
class Solution {
    int m;
    int n;
    Integer[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        m=nums1.length;
        n=nums2.length;
        dp=new Integer[m][n];
        return solve(0,0,nums1,nums2);
    }
    public int solve(int i,int j,int[] nums1,int[] nums2)
    {
        if(i>=m || j>=n)
        return Integer.MIN_VALUE;

        if(dp[i][j]!=null)
        return dp[i][j];

        int take=nums1[i]*nums2[j];
        int next=solve(i+1,j+1,nums1,nums2);
        //now this is neccessary to check because if we do directly take + solve(i+1,j+1,nums1,nums2)
        //which we were doing earlier then it will create wrong value because take(some no)+ Integer.MIN_VALUE which will return an integer which will be greater than take so it will return wrong res
        int takeBoth=(next==Integer.MIN_VALUE)?take:take+next;

        int res=Math.max(Math.max(take,takeBoth),
        Math.max(solve(i+1,j,nums1,nums2),solve(i,j+1,nums1,nums2)));

        return dp[i][j]=res;
    }
}