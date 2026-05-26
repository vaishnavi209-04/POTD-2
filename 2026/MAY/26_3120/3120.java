class Solution {
    public int numberOfSpecialChars(String word) {
        int[] u=new int[26];
        int[] l=new int[26];

        for(char ch:word.toCharArray())
        {
            if(Character.isUpperCase(ch))
            u[ch-'A']++;
            else
            l[ch-'a']++;
        }
        int res=0;
        for(int i=0;i<26;i++)
        {
            if(u[i]!=0 && l[i]!=0)
            res++;
        }
        return res;
    }
}
//Approach 2
class Solution {
    public int numberOfSpecialChars(String word) {
        int res=0;
        Set<Character> set=new HashSet<>();

        for(char ch:word.toCharArray())
        set.add(ch);

        for(char ch='a';ch<='z';ch++)
        {
            if(set.contains(ch) && set.contains((char) (ch-'a' +'A')))
            res++;
        }
        return res;
    }
}