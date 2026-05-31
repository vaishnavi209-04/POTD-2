class Solution {
    public int minElement(int[] nums) {
        int res=Integer.MAX_VALUE;
        for(int num:nums)
        {
            int sum=find(num);
            res=Math.min(res,sum);
        }
        return res;
    }
    public int find(int n)
    {
        int sum=0;
        while(n>0)
        {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}