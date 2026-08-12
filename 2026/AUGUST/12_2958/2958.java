//Approach 1-Hashing+ Sliding Window-O(n)
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int start=0;
        int res=0;
        for(int i=0;i<n;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.get(nums[i])>k)
            {
                map.put(nums[start],map.get(nums[start])-1);
                start++;
            }
            res=Math.max(res,i-start+1);
        }
        return res;
    }
}