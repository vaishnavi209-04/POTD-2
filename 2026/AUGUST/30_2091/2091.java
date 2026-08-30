//Approach 1:There are 3 ways to delete both 
//First way: delete both from front end
//Second way: delete both from last end
//Third way: delete one from front end and other from last end
//T.C=O(n)
class Solution {
    public int minimumDeletions(int[] nums) {

        int n=nums.length;
        int maxIdx=0;
        int minIdx=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>nums[maxIdx])
            maxIdx=i;

            if(nums[i]<nums[minIdx])
            minIdx=i;
        }
        //store the index near front in l and index near end in r
        int l=Math.min(maxIdx,minIdx);
        int r=Math.max(maxIdx,minIdx);
        //for first method 
        int left=r+1;
        //for second method
        int right=n-l;
        //for third method
        int both=l+1+n-r;

        return Math.min(left,Math.min(right,both));

        
    }
}