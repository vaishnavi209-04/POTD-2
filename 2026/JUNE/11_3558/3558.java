//Approach 1-MaxDepth(DFS)-O(n) + Power exponentiation-O(log n)
class Solution {
    long mod=1_000_000_007;
    public int assignEdgeWeights(int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();

        int n=edges.length+1;
        for(int i=0;i<=n;i++)
        adj.add(new ArrayList<>());

        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int d=maxDepth(adj,1,-1);
        return (int)power(2,d-1);
    }
    public int maxDepth(List<List<Integer>> adj,int root,int parent)
    {
        int max=0;
        for(int nghbr:adj.get(root))
        {
            if(nghbr==parent)
            continue;
            max=Math.max(max,maxDepth(adj,nghbr,root)+1);
        }
        return max;
        
    }
    public long power(int a,int b)
    {
        if(b==0)
        return 1;

        long half=power(a,b/2);
        long res=(half*half)%mod;
        if(b%2==1)
        {
            res=(res*a)%mod;
        }
        return res;
    }
}