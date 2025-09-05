//Approach 1-Maths intuition
class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        int t=0;
        while(true)
        {
            long val=(long)num1-(long)t*num2;
            if(val<0)
            return -1;//something Power of 2 can never be -ve
            long bits=Long.bitCount(val);
            if(bits<=t && t<=val)
            return t;
            t++;
        }
    }
}
//Approach 2-Bounding t-log(num1) for bitcount
class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int t=1;t<=36;t++)
        {
            long val=(long)num1-(long)t*num2;
            if(val<0)
            return -1;
            long bits=Long.bitCount(val);
            if(bits<=t && t<=val)
            return t;
        }
        return -1;
    }
}