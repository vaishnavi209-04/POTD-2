//Approach 1-Brute Force-O(n1*n2)
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int res=0;
        int n1=nums1.length;
        int n2=nums2.length;
        for(int i=0;i<n1;i++)
        {
            int j=i;
            while(j<n2 && nums1[i]<=nums2[j])
            {
                res=Math.max(res,j-i);
                j++;
            }
        }
        return res;
    }
}
//Approach 2-Binary Search-O(n1*log n2)
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int res=0;
        int n1=nums1.length;
        int n2=nums2.length;
        for(int i=0;i<n1;i++)
        {
            int j=i;
            int val=binarySearch(nums2,j,n2-1,nums1[i]);
            if(val==-1)
            continue;
            res=Math.max(res,val-i);
        }
        return res;
    }
    public int binarySearch(int[] nums,int l,int r,int x)
    {
        int res=-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]>=x)
            {
                res=mid;
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }

        }
        return res;
    }
}
//Approach 3-Two pointer-O(n1+n2)
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int res=0;
        while(i<nums1.length && j<nums2.length)
        {
           if(nums1[i]<=nums2[j])
           {
            res=Math.max(res,j-i);
            j++;
           }
           else
           {
            i++;
           }

        }
        return res;
        
    }
}