class Solution {
    public int countTriples(int n) {
        int count=0;
        for(int i=n;i>=3;i--)
        {
            for(int j=i-1;j>=1;j--)
            {
                for(int k=i-1;k>=1;k--)
                {
                    if(k*k + j*j == i*i)
                    count++;
                }
            }
        }
        return count;
    }
}