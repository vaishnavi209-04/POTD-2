//Approach-Array-O(n)
class Solution {
    public int numOfSubarrays(int[] arr) {
        int sum=0;
        int evenCount=1;//a single odd element is also a subarray
        int oddCount=0;
        int res=0;
        int mod=1000000007;
        for(int num:arr)
        {
        sum+=num;
        if(sum%2==0)//odd+even=odd
        {
        evenCount++;
        res=(res+oddCount)%mod;
        }
        else//even+odd=odd
        {
        oddCount++;
        res=(res+evenCount)%mod;
        }
        }
        return res%mod;
    }
}