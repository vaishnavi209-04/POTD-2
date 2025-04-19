class Solution {
     public long jugad(int []nums,int targetSum){
        int n=nums.length;
        int left=0; int right=n-1;  long ans=0;
        while(left<right){
            if(nums[left]+nums[right]<=targetSum){
                ans+=(right-left);
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
    
        Arrays.sort(nums);
        long ansuar1ofupper=jugad(nums,upper);
        long ansuar2oflower=jugad(nums,lower-1);
        return ansuar1ofupper-ansuar2oflower;
    
    }
}
