//Approach 1-Sliding Window-O(n)
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums)
        set.add(num);
        int distinct=set.size();
        int n=nums.length;
        int i=0;
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int j=0;j<n;j++)
        {
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()==distinct)
            {
            res+=n-j;
            map.put(nums[i],map.get(nums[i])-1);
            if(map.get(nums[i])==0)
            {
                map.remove(nums[i]);
            }
            i++;
            }
        }
        return res;
    }
}