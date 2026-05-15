//Approach 1- Brute Force-O(n)
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            if(nums[i]<nums[i-1])
            return nums[i];
        }
        return nums[0];
    }
}
//Approach 2- Binary Search-O(log n)
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int mid;
        int ans=nums[0];
        while(low<=high)
        {
          mid=low+(high-low)/2;
          if(nums[low]<=nums[high])//array is fully sorted
          {
            ans=Math.min(ans,nums[low]);
            break;
          }
          if(nums[mid]<nums[low])//mid is the breaking point
          {
            ans=Math.min(ans,nums[mid]);
            high=mid-1;
          }
          else//sorted portion 
          {
          low=mid+1;
          ans=Math.min(ans,nums[low]); 
          }
        }
        return ans;
    }
}