//Approach 1:O(n)
class Solution {
    public int stoneGameVIII(int[] stones) {
        int sum=0;
        for(int stone:stones)//calculate sum of all stones
        {
            sum+=stone;
        }
        int n=stones.length;
        int dp=sum;

        for(int i=n-2;i>=1;i--)
        {
            sum-=stones[i+1];//alice takes all stone upto i so calculate sum upto i 
            dp=Math.max(dp,sum-dp);//difference after alice takes till i or the bigger i
        }
        return dp;
    }
}