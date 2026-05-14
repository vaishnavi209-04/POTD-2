//Approach 1
class Solution {
    public boolean isGood(int[] nums) {
        int max=0;
        for(int num:nums)
        {
            max=Math.max(max,num);
        }
        int[] count=new int[max+1];
        for(int num:nums)
        {
            count[num]++;
        }
        for(int i=1;i<=max;i++)
        {
            if(count[i]==2 && i==max)
            return true;
            if(count[i]!=1)
            return false;
        }
        return false;
    }
}