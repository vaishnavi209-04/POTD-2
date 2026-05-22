//Approach 1-Binary Search
//O(log v2 n)
//rotated sorted array hai to ek hi breaking point hoga isliye do parts krege to dono me se ek to sorted hoga 100 %
class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int mid;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(nums[mid]==target)
            return mid;
            if (nums[low] <= nums[mid]) //first half part is sorted
            { 
                if (nums[low] <= target && target < nums[mid]) //lying in first half
                {
                    high = mid - 1; 
                } else {//lying in second half
                    low = mid + 1; 
                }
            } 
            else //second half part is sorted
            { 
                if (nums[mid] < target && target <= nums[high])//lying in second half
                 {
                    low= mid + 1; 
                } else//lying in first half
                {
                    high = mid - 1; 
                }
            }
        }

        return -1; 
    }
}