//Approach 1-O(n^2)
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int res=0;
       
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=i;j<n;j++)
            {
                if(nums[j]==target)
                count++;
                else 
                count--;
                if(count>0)//found another subarray
                res++;
            }
        }
        return res;
    }
}
//Approach 2-Prefix Sum + HashMap-O(n^2)
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int count=0;

        int prefix=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        for(int num:nums)
            {
                if(num==target)
                    prefix+=1;
                else
                    prefix-=1;
                
                for(int key:map.keySet())
                    {//previous sum - curr sum = curr subarray sum -> prefix-key>0 (required condition)
                        if(key<prefix)
                            count+=map.get(key);
                    }
                map.put(prefix,map.getOrDefault(prefix,0)+1);
            }
        return count;
    }
}