//Approach 1-O(n)
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int i=0;
        int n=nums.length;
        long res=0;
        while(i<n)
        {
            if(nums[i]==0)//start of a subarray with 0
            {
                long count=0;
                while(i<n && nums[i]==0 )//subarray only has 0
                {
                    i++;
                    count++;
                }
            res+=count *(count+1)/2;// formula for subarray-eg:[0,0]-no of subarray=3
            }
            else
            i++;
        }
        return res;
    }
}
//Approach 2-Observation
//O(n)
// array-> no of subarray
// [0]-> 1
// [00]->3 (1+2)
// [000]->6 (3+3)
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res=0;
        int i=0;
        int n=nums.length;
        int count=0;
        while(i<n)
        {
            if(nums[i]==0)
            count++;
            else
            count=0;
            i++;
            res+=count;
        }
        return res;
    }
}