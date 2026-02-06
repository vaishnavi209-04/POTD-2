//Approach 1-Binary Search-O(n log n)
class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int res=n-1;
        for(int i=0;i<n;i++)
            {
                int left=i;
                int right=n-1;
                int temp=i;
                while(left<=right)
                    {
                        int mid= left +(right-left)/2;
                        if(nums[mid]<= (long) nums[i]*k)
                        {
                            temp=mid;
                            left=mid+1;
                        }
                        else
                            right=mid-1;
                    }
                int removals=i +(n-1-temp);
                res=Math.min(res,removals);
            }
        return res;
    }
}