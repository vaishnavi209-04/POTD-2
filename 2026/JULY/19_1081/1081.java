//Approach 1-Stack-O(n)
class Solution {
    public String smallestSubsequence(String s) {
        int n=s.length();
        
        int[] last=new int[26];
        boolean[] vis=new boolean[26];
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++)//store the last index of each character present in string s
        {
            char ch=s.charAt(i);
            last[ch-'a']=i;
        }

        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            //already in the stack
            if(vis[ch-'a'])
            continue;
//if stack is not empty and stack.top has bigger character than curr and that bigger character will come later then pop it to make lexicographically smaller string
            while(sb.length()>0 && sb.charAt(sb.length()-1)>ch && last[sb.charAt(sb.length()-1)-'a']>i)
            {
                vis[sb.charAt(sb.length()-1)-'a']=false;
                sb.deleteCharAt(sb.length()-1);
            }
            
            sb.append(ch);
            vis[ch-'a']=true;

        }
        return sb.toString();
    }
}