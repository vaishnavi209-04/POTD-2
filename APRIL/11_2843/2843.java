//Approach 1-O(N)
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++)
        {
            if(i<10 || i==10000)
            continue;
            else if(i>=100 && i<1000)
            continue;
            String str=String.valueOf(i);
            int n=str.length();
            int sum1=0,sum2=0;
            for(int j=0;j<n/2;j++)
            {
                sum1+=str.charAt(j)-'0';
                sum2+=str.charAt(n-j-1)-'0';
            }
            if(sum1==sum2)
            count++;
        }
        return count;
    }
}