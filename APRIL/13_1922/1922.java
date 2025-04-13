//Approach 1:Brute force-O(n)
//TLE
class Solution {
    public int countGoodNumbers(long n) {
        long oddIndices=n/2;
        long evenIndices=(n+1)/2;
        int mod=1000000007;
        long res=1;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            res=(res*5)%mod;//0,2,4,6,8
            else
            res=(res*4)%mod;//2,3,5,7
        }
        
        return (int)res;
    }
}
//Approach 2:Optimum Approach
//Fast/Binary exponentiation instead of pow
//If we need Math.pow(a,b) and b is very large then use fast exponentiation method-O(logv2 b)
class Solution {
    int mod=1000000007;
    public int countGoodNumbers(long n) {
        long oddIndices=n/2;
        long evenIndices=(n+1)/2;
        long res=(findPower(4,oddIndices)*findPower(5,evenIndices))%mod;//even position has choices-0,2,4,6,8 and odd position has choices-2,3,5,7
        return (int)res;
    }
    public long findPower(int a,long b)
    {
        if(b==0)
        return 1;
        long half=findPower(a,b/2);//we know that (a^b/2)^2=(a^b)
        long res=(half*half)%mod;//eg-(3^12)=(3^6)^2
        if(b%2==1)//eg-(3^13)=3*(3^12)
        res=(res*a)%mod;
        return res;
    }
}