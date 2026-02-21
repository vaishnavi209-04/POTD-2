class Solution {
    public int countPrimeSetBits(int left, int right) {
        int res=0;
        for(int i=left;i<=right;i++)
        {
            int n=Integer.bitCount(i);
            if(isPrime(n))
            res++;
        }
        return res;
    }
    public boolean isPrime(int n)
    {
        if(n==1)
        return false;

        for(int i=2;i<=n/2;i++)
        {
            if(n%i==0)
            return false;
        }
        return true;
    }
}