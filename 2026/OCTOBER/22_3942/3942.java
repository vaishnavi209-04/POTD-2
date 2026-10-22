//Approach 1-Case analysis-O(n)
class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int zero=-1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)//find idx of zeroth position
            {
                zero=i;
                break;
            }
        }

        boolean right=true;
        boolean left=true;
        for(int i=1;i<n;i++)
        {
            int prevR=(zero+i-1)%n;
            int currR=(zero+i)%n;
            if(nums[prevR]>nums[currR])//not sorted in right direction
            right=false;

            int prevL=(zero-(i-1)+n)%n;
            int currL=(zero-i+n)%n;
            if(nums[prevL]>nums[currL])//not sorted in left direction
            left=false;

        }

        int res=Integer.MAX_VALUE;

        if(right)
        {
            res=Math.min(res,zero);
            res=Math.min(res,n-zero+2);//Rotate in the opposite direction using a reverse–rotate–reverse strategy; the two reversals cost +2
        }

        if(left)
        {
            res=Math.min(res,zero+2);//Rotate to the opposite end, then use two reversals to restore the required order
            res=Math.min(res,n-zero);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}