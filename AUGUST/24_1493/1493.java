//Approach 1-O(n)
class Solution {
    public int longestSubarray(int[] nums) {
        int i=0;
        int j=0;
        int n=nums.length;
        int zeroes=0;
        int res=-1;
        while(j<n)
        {
           if(nums[j]==0)//if new element in window is 0 then inc count of zeroes
           zeroes++;
           while(zeroes>1)//count of zeroes >1 
           {
            zeroes-=(nums[i]==0?1:0);//reduce window
            i++;
           }
           res=Math.max(res,j-i);//compare size of window
           j++;
        }
        return res;
    }
}