//Approach 1:Sorting + Two Pointer- O(n log n)
class Solution {
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int res=0;
        //we have to satisfy a+b>c
        for(int c=2;c<n;c++)
        {
            int left=0;
            int right=c-1;
            while(left<right)
            {
                if(nums[left]+nums[right]>nums[c])
                {
                res+=right-left;//if min+ max is greater than all will be greater between them with max paired with elements (min,.....) here max got fixed too
                right--;
                }
                else
                left++;
            }
        }
        return res;
    }
}