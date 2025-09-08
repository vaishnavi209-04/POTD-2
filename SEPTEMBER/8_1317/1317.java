//Approach 1-Brute Force-O(n)
class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] res=new int[2];
        for(int i=1;i<=n/2;i++)
        {
            if(isValid(i) && isValid(n-i))
            {
                res[0]=i;
                res[1]=n-i;
                break;
            }
        }
        return res;
    }
    public boolean isValid(int n)
    {
        while(n>0)
        {
            int d=n%10;
            if(d==0)
            return false;
            n/=10;
        }
        return true;
    }
}