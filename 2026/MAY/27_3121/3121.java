//Approach 1-O(n)
class Solution {
    public int numberOfSpecialChars(String word) {
        int[] u=new int[26];
        int[] l=new int[26];

        for(char ch:word.toCharArray())
        {
            if(Character.isLowerCase(ch))
            {
                l[ch-'a']++;
                if(u[ch-'a']!=0)
                u[ch-'a']=-1;
            }
            else if(u[ch-'A']!=-1)
            {
                u[ch-'A']++;
            }
        }
        int res=0;
        for(int i=0;i<26;i++)
        {
            if(u[i]==-1)
            continue;
            if(u[i]!=0 && l[i]!=0)
            res++;
        }
        return res;
    }
}