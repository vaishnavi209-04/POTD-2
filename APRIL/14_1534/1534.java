//Approach 1:Brute Force-O(n^3)
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n=arr.length;
        int res=0;
        for(int i=0;i<n-2;i++)
        {
            for(int j=i+1;j<n-1;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if(Math.abs(arr[i]-arr[j])<=a && Math.abs(arr[j]-arr[k])<=b &&Math.abs(arr[i]-arr[k])<=c )
                    res++;
                }
            }
        }
        return res;
    }
}
//Approach 2:Brute Force with slight change-O(n^3)
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n=arr.length;
        int res=0;
        for(int i=0;i<n-2;i++)
        {
            for(int j=i+1;j<n-1;j++)
            {
                if(Math.abs(arr[i]-arr[j])<=a)
                {
                for(int k=j+1;k<n;k++)
                {
                    if(Math.abs(arr[j]-arr[k])<=b &&Math.abs(arr[i]-arr[k])<=c )
                    res++;
                }
                }
            }
        }
        return res;
    }
}