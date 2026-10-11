//Approach 1:Brute Force-O(n)
class Solution {
    public int sumOfSquares(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=1;i<=n;i++)
        {
            int num=nums[i-1];
            if(n%i==0)
            sum+=num*num;
        }
        return sum;
    }
}