//Approach 1:Greedy-O(n)
class Solution {
    public int minInsertions(String s) {
        int res=0;
        int open=0;
        int n=s.length();
        int idx=0;
        while(idx<n)
        {
            char ch=s.charAt(idx);
            if(ch=='(')
            {
                open++;
                idx++;
            }
            else
            {
                if(open>0)
                open--;
                else
                res++;
                if(idx+1<n && s.charAt(idx+1)==')')
                idx+=2;
                else
                {
                    res++;
                    idx++;
                }
            }
        }
        res+=open*2;
        return res;
    }
}