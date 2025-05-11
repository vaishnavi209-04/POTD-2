class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        boolean res=false;
        int n=arr.length;
        for(int i=0;i<=n-3;i++)
        {
            if(isOdd(arr[i])  && isOdd(arr[i+1]) && isOdd(arr[i+2]))
            return true;
        }
        return res;
    }
    public boolean isOdd(int n)
    {
        return n%2!=0;
    }
}