//Approach 1-O(d)
class Solution {
    public boolean checkDivisibility(int n) {
        int num=n;
        int sum=0;
        int p=1;
        while(num>0)
        {
            sum+=num%10;
            p*=num%10;
            num/=10;
        }
        int total=sum+p;
        return n%total==0;
    }
}