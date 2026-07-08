//Approach 1-2 pass -O(log n)
class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long num=0;
        while(n>0)
        {
           int d=n%10;
           sum+=d;
           n/=10;
           if(d==0)
           continue;
           num=num*10+d; 
        }
        long res=0;
        while(num>0)
        {
           long d=num%10;
           res=res*10+d;
           num/=10;
        }
        return res*sum;
    }
}
//Approach 2-1 pass -O(log n)
class Solution {
    public long sumAndMultiply(int n) {
       long num=0;
       String s=Integer.toString(n);
       long sum=0;
       for(char ch:s.toCharArray())
       {
        int d=ch-'0';
        sum+=d;
        if(d==0)
        continue;
        num=num*10+d;
       }
       return num*sum;
    }
}