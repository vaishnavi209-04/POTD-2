//Approach 1 - (Binary Search + DSU)
//T.C : O((n+e)log(maxStrength))
//S.C : O(n+e), n = number of nodes, e = number of edges
class Solution {
    int[] parent;
    int[] rank;
    public int maxStability(int n, int[][] edges, int k) {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }
        
        int max=-1;
        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            int s=edge[2];
            int m=edge[3];

            if(m == 1)//we must include so check for cycle
            {
                if(find(u)==find(v))
                return -1;

                union(u,v);
            }

            max=Math.max(max,s);
        }

        int res=-1;
        int l=1;
        int r=2 * max;
        while(l<=r)//O(log maxStrength)
        {
            int mid= l +(r-l)/2;
            if(check(n,edges,k,mid))//O((n+e) alpha(n)) alpha(n) is mostly constant
            {
                res=mid;
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return res;
    }
    public boolean check(int n,int[][] edges,int k,int mid)//O(n + e)
    {
        for(int i=0;i<n;i++)//re initialise as we are constructing a new spanning tree in every check
        {
            parent[i]=i;
            rank[i]=1;
        }

        List<int[]> list=new ArrayList<>();//edges which can be upgraded
        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            int s=edge[2];
            int m=edge[3];

            if(m==1)//must be connected
            {
                if(s < mid)//strength must be mid at min for all edges connecting in spanning tree
                return false;

                union(u,v);
            }
            else// for m==0
            {
                if(s >=  mid)
                union(u,v);
                else if( 2*s >=mid)//can update and add
                {
                    list.add(new int[]{u,v});
                }
            }
        }

        for(int[] edge:list)
        {
            int u=edge[0];
            int v=edge[1];

            if(find(u)!=find(v))//not connected
            {
                if(k<=0)
                return false;

                union(u, v);
                k--;
            }
        }
        int root=find(0);
        for(int i=1;i<=n-1;i++)
        {
            if(find(i)!=root)//any component left which can't be added in spanning tree
            return false;
        }
        return true;
    }
    public int find(int x)
    {
        if(parent[x]==x)
        return x;

        return parent[x]=find(parent[x]);
    }
    public void union(int x,int y)
    {
        int parentX=find(x);
        int parentY=find(y);
        if(parentX==parentY)
        return ;

        if(rank[parentX] > rank[parentY])
        {
            parent[parentY]=parentX;
        }
        else if(rank[parentX] < rank[parentY])
        {
            parent[parentX]=parentY;
        }
        else
        {
            parent[parentY]=parentX;
            rank[parentX]++;
        }

    }
}