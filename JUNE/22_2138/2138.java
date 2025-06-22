//Approach 1-Brute Force-O(n)
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();
        int len;
        if(n%k==0)
        len=n/k;
        else
        len=n/k +1;
        String[] res=new String[len];
        int j=0;
        for(int i=0;i<n;i+=k)
        {
            if(i+k <n)
            res[j++]=s.substring(i,i+k);
            else
            res[j++]=s.substring(i,n);
        }
        
        if(res[len-1].length()<k)
        {
            StringBuilder sb=new StringBuilder(res[len-1]);
            int l=res[len-1].length();
            while(l<k)
            {
            sb.append(fill);
            l++;
            }
            res[len-1]=sb.toString();
        }
        return res;
    }
}