//Approach 1-2 pass
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int  n=nums.length;
        int[] res=new int[n];
        int k=0;
        int less=0,equal=0;
        for(int num:nums)
        {
            if(num<pivot)
            less++;
            else if(num==pivot)
            equal++;
        }
        int i=0;
        int j=less+equal;
        while(i<=j)
        {
            if(k>=n)
            break;
            if(nums[k]<pivot)
            {
                res[i++]=nums[k++];
            }
            else if(nums[k]>pivot)
            {
                res[j++]=nums[k++];
            }
            else
            {
                res[less++]=nums[k++];
            }
        }
        return res;
    }
}
//Approach 2-pointers
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int  n=nums.length;
        int[] res=new int[n];
        int i=0;
        int j=n-1;
        int i_=0;
        int j_=n-1;
        while(i<n && j>=0 )
        {
            if(nums[i]<pivot)
            {
                res[i_++]=nums[i];
            }
            if(nums[j]>pivot)
            {
                res[j_--]=nums[j];
            }
            i++;
            j--;
        }
        while(i_<=j_)
        {
            res[i_++]=pivot;
        }
        return res;
    }
}