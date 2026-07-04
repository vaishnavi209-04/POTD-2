//Approach 1-BFS-O(n + e)
class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++)
        adj.add(new ArrayList<>());

        for(int[] road:roads)//adjacency list
        {
            int u=road[0];
            int v=road[1];
            int d=road[2];
            adj.get(u).add(new int[]{v,d});
            adj.get(v).add(new int[]{u,d});
        }
        boolean[] vis=new boolean[n+1];
        Queue<Integer> que=new LinkedList<>();
        //start from 1 and find min distance between all connected nodes of 1
        que.offer(1);
        vis[1]=true;
        
        int res=Integer.MAX_VALUE;
        while(!que.isEmpty())
        {
            int u=que.poll();
            for(int[] arr:adj.get(u))
            {
                int v=arr[0];
                int d=arr[1];
                res=Math.min(res,d);
                if(!vis[v])
                {
                    que.offer(v);
                    vis[v]=true;
                }
            }
        }
        return res;
    }
}