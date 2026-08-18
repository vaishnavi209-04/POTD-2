//Approach 1:O(n)
class Solution {
    public int largestInteger(int[] nums, int k) {
        boolean first=true;
        boolean last=true;
        int n=nums.length;

        if(k==1)
        {
            Map<Integer,Integer> map=new HashMap<>();
            int max=-1;
            for(int num:nums)
            {
               map.put(num,map.getOrDefault(num,0)+1); 
            }

            for(int num:nums)
            {
                if(map.get(num)==1)
                max=Math.max(max,num);
            }

            return max;
        }

        if(k==n)
        {
            int max=-1;
            for(int num:nums)
            {
                max=Math.max(max,num);
            }

            return max;

        }

        for(int i=1;i<n;i++)
        {
           if(nums[i]==nums[0])
           {
            first=false;
            break;
           }
        }

        for(int i=0;i<n-1;i++)
        {
            if(nums[i]==nums[n-1])
            {
                last=false;
                break;
            }
        }

        if(first && last)
        return Math.max(nums[0],nums[n-1]);

        if(first)
        return nums[0];

        if(last)
        return nums[n-1];

        return -1;
    }
}