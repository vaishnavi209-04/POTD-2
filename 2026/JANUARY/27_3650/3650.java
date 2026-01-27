class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] adj=new ArrayList[n];
        List<int[]>[] revAdj=new ArrayList[n];
        for(int i=0;i<n;i++)
            {
                adj[i]=new ArrayList<>();
                revAdj[i]=new ArrayList<>();
            }
        for(int[] edge:edges)
            {
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];
                adj[u].add(new int[]{v,w});
                revAdj[v].add(new int[]{u,w});
            }
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty())
            {
                long[] curr=pq.poll();
                long d=curr[0];
                int u=(int) curr[1];
                if(d>dist[u])
                    continue;
                for(int[] nghbr:adj[u])
                    {
                        int v=nghbr[0];
                        int w=nghbr[1];
                        if(d+w<dist[v])
                        {
                            dist[v]=d+w;
                            pq.offer(new long[]{dist[v],v});
                        }
                    }
                for(int[] nghbr:revAdj[u])
                    {
                        int v=nghbr[0];
                        int w=nghbr[1];
                        if(d +2L*w<dist[v])
                        {
                            dist[v]=d +2L*w;
                            pq.offer(new long[]{dist[v],v});
                        }
                    }
            }
        long res=dist[n-1];
        return res==Long.MAX_VALUE?-1:(int)res;
    }
}