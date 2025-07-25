//Approach 1-TreeSet-O(n log n)
class Solution {
    public int maxSum(int[] nums) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int num:nums)
        {
            set.add(num);
        }
        int n=set.size();
        if(set.last()<0)
        return set.last();
        
        int sum=0;
        for(int num:set.descendingSet())
        {
            if(num>0)
            sum+=num;
            else
            break;
        }
        return sum;
    }
}
//Apparoach 2-O(n)
class Solution {
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(nums[n-1]<=0)
        return nums[n-1];
        int prev=nums[n-1];
        int sum=prev;
        for(int i=n-2;i>=0;i--)
        {
            int num=nums[i];
            if(num<=0)
            return sum;
            else if(num!=prev)
            sum+=num;
            prev=num;

        }
        return sum;
    }
}