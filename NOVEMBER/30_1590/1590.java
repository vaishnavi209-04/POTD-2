//Approach 1-Prefix+HashMap-O(n)
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        int sum=0;
        //(a+b)%p=(a%p+b%p)%p
        for(int num:nums)
        {
            sum=(sum+num)%p;
        }
        int target=sum%p;
        if(target==0)
        return 0;
        int res=n;
        HashMap<Integer,Integer> map=new HashMap<>();//stores remainder,index
        map.put(0,-1);
        int curr=0;
        for(int i=0;i<n;i++)
        {
            curr=(curr+nums[i])%p;
            int remain=(curr-target+p)%p;
            if(map.containsKey(remain))
            res=Math.min(res,i-map.get(remain));
            map.put(curr,i);
        }
        return res==n?-1:res;
    }
}