//Approach 1-Brute Force -O(t+ n)
class Solution {
    int M=1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {
        int[] before=new int[26];
        for(char ch:s.toCharArray())
        {
            before[ch-'a']++;
        }
        while(t-- >0)
        {
            int[] after=new int[26];
            for(int i=0;i<26;i++)
            {
                char ch=(char)(i+'a');
                if(ch!='z')
                {
                    after[i+1]=(after[i+1] + before [i]) % M;
                }
                else
                {
                    after[0]=(after[0] + before [i]) % M;
                    after[1]=(after[1]+ before[i]) % M;
                }
            }
            before=after;//for further updation
        }
        int res=0;
        for(int num:before)
        {
            res=(res+num)%M;
        }
        return res;
    }
}