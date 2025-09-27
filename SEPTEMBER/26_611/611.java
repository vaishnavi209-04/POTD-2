//Approach 1-Brute Force-O(n^3)
//sum of 2 sides should be greater than the third side
class Solution {
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<=n-3;i++)
        {
            for(int j=i+1;j<=n-2;j++)
            {
                for(int k=j+1;k<=n-1;k++)
                {
                    if((nums[i]+nums[j]>nums[k]) && (nums[i]+nums[k]>nums[j]) && (nums[j]+nums[k]>nums[i]))
                    count++;
                }
            }
        }
        return count;
    }
}

//Approach 2-Binary search-O(n^2 * log n)
//sum of 2 sides should be greater than the third side
class Solution {
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        if(n<3)
        return 0;
        int res=0;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++)
        {
            if(nums[i]==0)
            continue;
            for(int j=i+1;j<n-1;j++)
            {
                int sum=nums[i]+nums[j];
                int l=j+1;
                int r=n-1;
                int count=0;
                while(l<=r)
                {
                    int mid=l+(r-l)/2;
                    if(nums[mid]<sum)
                    {
                    count=mid;
                    l=mid+1;
                    }
                    else
                    r=mid-1;
                }
                if(count!=0)
                res+=count-j;
            }
        }
        return res;
    }
}

//Approach 3-Two pointers-O(n^2)
//sum of 2 sides should be greater than the third side
class Solution {
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        if(n<3)
        return 0;
        Arrays.sort(nums);
        int res=0;
        for(int k=n-1;k>=2;k--)
        {
            int i=0;
            int j=k-1;
            while(i<j)
            {//we don't need to check for other 3 conditions as array is sorted
            if(nums[i]+nums[j]>nums[k])
            {
                res+=j-i;
                j--;
            }
            else
            i++;
            }
        }
        return res;
    }
}