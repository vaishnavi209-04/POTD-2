//Approach 1:BS on Answers
//O(n log n)
class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0;//min diff can be 0
        int r=nums[n-1]-nums[0];//max diff can be max element-min element
        int res=-1;
        while(l<=r)
        {
        int mid=r +(l-r)/2;
        if(isValid(nums,mid,p))
        {
            res=mid;
            r=mid-1;//we have to find minimum so check for less than that 
        }
        else
        {
            l=mid+1;
        }
        }
        return res;

    }
    public boolean isValid(int[] nums,int x,int p)
    {
        int i=0;
        int pairs=0;
        int n=nums.length;
        while(i<n-1)
        {
            if(nums[i+1]-nums[i]<=x)
            {
                pairs++;
                i+=2;//indices can come only once in any pair
            }
            else
            i++;
            if(pairs>=p)//return early
            return true;
        }
        return pairs>=p;
    }
}