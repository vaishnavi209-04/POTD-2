class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max=0;
        int curr_max=0;
        for(int num:nums)
        {
            if(num>max)
            {
                curr_max=max;
                max=num;
            }
            else
            {
                curr_max=Math.max(curr_max,num);
            }

        }
        return (curr_max-1)*(max-1);
    }
}