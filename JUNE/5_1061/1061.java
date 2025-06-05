//Approach 1-Dfs
//T.C- O(m (V+E))
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        List<List<Character>> adj=new ArrayList<>();//adj list
        int n=s1.length();
        int m=baseStr.length();
        for(int i=0;i<26;i++)
        adj.add(new ArrayList<>());//initialize
        for(int i=0;i<n;i++)
        {//adj list 
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            adj.get(ch1-'a').add(ch2);
            adj.get(ch2-'a').add(ch1);
        }
        String res="";
        for(int i=0;i<m;i++)
        {
            char ch=baseStr.charAt(i);
            boolean[] vis=new boolean[26];
            char min=dfs(adj,ch,vis);
            res+=min;
        }
        return res;
    }
    public char dfs(List<List<Character>> adj,char ch,boolean[] vis)
    {
        vis[ch-'a']=true;
        char min=ch;
        for(char c:adj.get(ch-'a'))
        {
            if(!vis[c-'a'])
            min=(char)Math.min(min,dfs(adj,c,vis));
        }
        return min;
    }
}