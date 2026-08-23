//Approach 1:O(n)
class Solution {
    public boolean sumGame(String num) {
        int left=0;
        int l=0;
        int n=num.length();
        for(int i=0;i<n/2;i++)
        {
            char ch=num.charAt(i);
            if(ch=='?')
            l++;
            else
            left+=ch-'0';
        }
        int right=0;
        int r=0;
        for(int i=n/2;i<n;i++)
        {
            char ch=num.charAt(i);
            if(ch=='?')
            r++;
            else
            right+=ch-'0';
        }
        //alice gets one chance more than bob to influence the sum
        if((l+r)%2==1)
        return true;
        //if there are even ? then 
        return (right-left)!=(l-r)*9/2;
    }
}