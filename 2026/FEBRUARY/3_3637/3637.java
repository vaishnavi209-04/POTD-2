//Approach 1-O(n)
class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n-1 && nums[i]<nums[i+1])
        i++;
        int p=i;

        if(p==0)//for strictly increasing p cannot be 0
        return false;

        while(i<n-1 && nums[i]>nums[i+1])
        i++;
        int q=i;
        
        if(q==p)//for [p...q] to be strictly decrease p and q can't be same
        return false;

        while(i<n-1 && nums[i]<nums[i+1])
        i++;
        int flag=i;

        if(flag!=n-1 || flag==q)//flag have to be n-1 & for [q..n-1] to be strictly inc q and flag can't be same
        return false;

        return true;
    }
}