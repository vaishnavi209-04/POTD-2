class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int[] prefixN=new int[n+1];
        int[] suffixY=new int[n+1];
        prefixN[0]=0;
        suffixY[n]=0;
        for(int i=1;i<=n;i++)
        {
            if(customers.charAt(i-1)=='N')
            prefixN[i]=prefixN[i-1]+1;
            else
            prefixN[i]=prefixN[i-1];
        }
        for(int i=n-1;i>=0;i--)
        {
            if(customers.charAt(i)=='Y')
            suffixY[i]=suffixY[i+1]+1;
            else
            suffixY[i]=suffixY[i+1];
        }
        int penalty=Integer.MAX_VALUE;
        int minHour=0;
        for(int i=0;i<=n;i++)
        {
            if(penalty>prefixN[i]+suffixY[i])
            {
            penalty=prefixN[i]+suffixY[i];
            minHour=i;
            }
        }
        return minHour;
    }
}