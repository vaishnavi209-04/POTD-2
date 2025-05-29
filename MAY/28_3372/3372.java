//Approach 1:BFS
//T.C-O(n^2)
//S.C-O(n)
class Solution {
    //in total you have to make k+1 connections from a node in which one is counted to itself
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) 
    {
        int[] dist1=findDist(edges1,k);//one connection to itself
        int[] dist2=findDist(edges2,k-1);//one connection to itself and one connection between two trees for connecting them
        //we will connect every node of tree1 with that node which gives us max distance in tree2 so find maxdist in dist2 array
        int max=Arrays.stream(dist2).max().getAsInt();
        for(int i=0;i<dist1.length;i++)
        {
            dist1[i]+=max;
        }
        return dist1;//it has the final distance within tree1 and tree2
    }
    public int[] findDist(int[][] edges,int limit)
    {
        //nodes start from 0 to edges.length 
        int n=edges.length+1;
        //adjacency list
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            //node is index itself in list and the list inside is the nodes connected to it
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            res[i]=bfs(i,adj,limit,n);
        }
        return res;
    }
    public int bfs(int curr,List<List<Integer>> adj,int limit,int n)
    {
        Queue<int[]> que=new LinkedList<>();
        que.offer(new int[]{curr,0});//distance of curr node to itself is 0
        boolean[] vis=new boolean[n];
        vis[curr]=true;
        int count=0;
        while(!que.isEmpty())
        {
            int node=que.peek()[0];
            int dist=que.peek()[1];
            que.poll();
            if(dist>limit)
            continue;
            count++;
            for(int nghbr:adj.get(node))
            {
                if(!vis[nghbr])
                {
                    que.offer(new int[]{nghbr,dist+1});
                    vis[nghbr]=true;
                }
            }
        }
        return count;
    }
}