//Approach 1-Floyd Warshal -O(m+n)
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        long[][] adj=new long[26][26];
        for(long[] arr:adj)
        Arrays.fill(arr,Long.MAX_VALUE);//adj matrix

        floydWarshal(adj,original,changed,cost);//find shortest path cost from s to t for every char

        long res=0;
        int n=source.length();
        for(int i=0;i<n;i++)
        {
            char ch1=source.charAt(i);
            char ch2=target.charAt(i);
            if(ch1==ch2)//same no need to change
            continue;
            if(adj[ch1-'a'][ch2-'a']==Long.MAX_VALUE)//no valid path so can't change 
            return -1;
            res+=adj[ch1-'a'][ch2-'a'];//shortest path cost
        }
        return res;
    }
    public void floydWarshal(long[][] adj,char[] original,char[] changed,int[] cost)
    {
        int n=original.length;
        for(int i=0;i<n;i++)//fill adj matrix with original cost
        {
            int s=original[i]-'a';
            int t=changed[i]-'a';
            adj[s][t]=Math.min(adj[s][t],(long)cost[i]);
        }

        for(int k=0;k<26;k++)
        {
            for(int i=0;i<26;i++)
            {
                for(int j=0;j<26;j++)
                {
                    if(adj[i][k]==Long.MAX_VALUE || adj[k][j]==Long.MAX_VALUE)//to avoid overflow
                    continue;
                    adj[i][j]=Math.min(adj[i][j], adj[i][k] + adj[k][j]);//go from i to j via k
                }
            }
        }
    }
}