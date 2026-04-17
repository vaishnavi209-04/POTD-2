//Approach 1-Hashing-O(n log c)
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int res=n+1;
    
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(nums[i]))
            {
                res=Math.min(res,i-map.get(nums[i]));
            }
            map.put(reverse(nums[i]),i);
        }
        return res==n+1?-1:res;
    }
    public int reverse(int num)
    {
        int x=0;
        while(num>0)
        {
            int d=num%10;
            x=x*10+d;
            num/=10;
        }
        return x;
    }
}