//Approach 1-DFS
//T.C-O(V+E)
//S.C-O(n)
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int[] dist1=new int[n];//dfs from node 1
        int[] dist2=new int[n];//dfs from node 2
        //node 1 se node 2 nhi jayege so infinite manlo(highest) and vice versa
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);

        boolean[] vis1=new boolean[n];
        boolean[] vis2=new boolean[n];
        //dist of node to itself is 0
        dist1[node1]=0;
        dist2[node2]=0;
        dfs(edges,node1,vis1,dist1);
        dfs(edges,node2,vis2,dist2);

        int minNode=-1;
        int minDistTillNow=Integer.MAX_VALUE;
        //minimize the max of both distances for each node
        for(int i=0;i<n;i++)
        {
            if(dist1[i]!=Integer.MAX_VALUE && dist2[i]!=Integer.MAX_VALUE)
            {
            int max=Math.max(dist1[i],dist2[i]);
            if(max<minDistTillNow)
            {
                minDistTillNow=max;
                minNode=i;
            }
            }
        }
        return minNode;
    }
    public void dfs(int[] edges,int u,boolean[] vis,int[] dist)
    {
       vis[u]=true;
       int v=edges[u];
       if(v!=-1 && !vis[v])
       {
        dist[v]=1+dist[u];
        dfs(edges,v,vis,dist);
       }
    }
}
//Approach 2-BFS
//T.C-O(V+E)
//S.C-O(n)
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int[] dist1=new int[n];//bfs from node 1
        int[] dist2=new int[n];//bfs from node 2
        //node 1 se node 2 nhi jayege so infinite manlo(highest) and vice versa
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);

        bfs(edges,node1,dist1);
        bfs(edges,node2,dist2);

        int minNode=-1;
        int minDistTillNow=Integer.MAX_VALUE;
        //minimize the max of both distances for each node
        for(int i=0;i<n;i++)
        {
            if(dist1[i]!=Integer.MAX_VALUE && dist2[i]!=Integer.MAX_VALUE)
            {
            int max=Math.max(dist1[i],dist2[i]);
            if(max<minDistTillNow)
            {
                minDistTillNow=max;
                minNode=i;
            }
            }
        }
        return minNode;
    }
    public void bfs(int[] edges,int node,int[] dist)
    {
       int n=edges.length;
       Queue<Integer> que=new LinkedList<>();
       que.offer(node);
       boolean[] vis=new boolean[n];
       dist[node]=0;
       vis[node]=true;
       while(!que.isEmpty())
       {
        int u=que.poll();
        int v=edges[u];
        if(v!=-1 && !vis[v])
        {
            vis[v]=true;
            dist[v]=1+dist[u];
            que.offer(v);
        }
       }
    }
}