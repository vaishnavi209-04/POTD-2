//Approach 1-Compute components
//T.C=O(n + q) S.C=O(n + q)
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp=new int[n];
        comp[0]=0;
        for(int i=1;i<n;i++)
        {
            if(nums[i]-nums[i-1]<=maxDiff)
            comp[i]=comp[i-1];
            else
            comp[i]=comp[i-1]+1;
        }
        boolean[] res=new boolean[queries.length];
        int i=0;
        for(int[] query:queries)
        {
            int u=query[0];
            int v=query[1];
            res[i++]=(comp[u]==comp[v]);
        }
        return res;
    }
}
//Approach 2-DSU
//T.C=O(n + q(alpha(n))) S.C=O(n)
class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        DSU(int n)
        {
            parent=new int[n];
            rank=new int[n];

            for(int i=0;i<n;i++)
            parent[i]=i;
        }
        public int find(int x)
        {
            if(parent[x]!=x)
            parent[x]=find(parent[x]);

            return parent[x];
        }
        public void union(int a,int b)
        {
            int pa=find(a);
            int pb=find(b);

            if(pa==pb)
            return ;
            if(rank[pa]>rank[pb])
            parent[pb]=pa;
            else if(rank[pa]<rank[pb])
            parent[pa]=pb;
            else
            {
               parent[pa]=pb;
               rank[pb]++;
            }
        }

    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU dsu=new DSU(n);
        for(int i=1;i<n;i++)
        {
            if(nums[i]-nums[i-1]<=maxDiff)
            dsu.union(i,i-1);
        }
        boolean[] res=new boolean[queries.length];
        int i=0;
        for(int[] query:queries)
        {
            int u=query[0];
            int v=query[1];
            res[i++]=(dsu.find(u)==dsu.find(v));
        }
        return res;
    }
}
//Approach 3-DFS
//T.C=O(n + q) S.C=O(n)
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++)
        adj[i]=new ArrayList<>();


        for(int i=1;i<n;i++)
        {
            if(nums[i]-nums[i-1]<=maxDiff)
            {
                adj[i-1].add(i);
                adj[i].add(i-1);

            }
        }

        int[] comp=new int[n];
        int component=1;
        Arrays.fill(comp,-1);

        for(int i=0;i<n;i++)
        {
            if(comp[i]==-1)
            {
                dfs(i,component,adj,comp);
                component++;
            }
        }
        boolean[] res=new boolean[queries.length];
        int i=0;
        for(int[] query:queries)
        {
            int u=query[0];
            int v=query[1];
            res[i++]=(comp[u]==comp[v]);
        }
        return res;
    }
    public void dfs(int curr,int component,List<Integer>[] adj,int[] comp)
    {
        comp[curr]=component;

        for(int nghbr:adj[curr])
        {
            if(comp[nghbr]==-1)
            dfs(nghbr,component,adj,comp);
        }
    }
}