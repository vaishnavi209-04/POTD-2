// Approach 1 - Graph - O(c + m + q log c)
class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        // Adjacency list for graph representation
        List<List<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<=c;i++)
            adj.add(new ArrayList<>());          // Create list for each station

        // Build the undirected graph
        for(int[] connection:connections)
        {
            int u=connection[0];
            int v=connection[1];

            adj.get(u).add(v);                   // Add v as neighbour of u
            adj.get(v).add(u);                   // Add u as neighbour of v
        }

        boolean[] vis=new boolean[c+1];          // To mark visited stations
        int[] id=new int[c+1];                   // Component ID of each station
        HashMap<Integer,TreeSet<Integer>> map=new HashMap<>();
                                                 // ComponentID → sorted online stations

        // Find all connected components using DFS
        for(int i=1;i<=c;i++)                   // Try each station
        {
            if(!vis[i])                          // If not assigned a component yet
            {
                int cId=i;                       // Use smallest station in component as ID
                map.put(cId,new TreeSet<>());    // Create TreeSet for this component
                dfs(i,adj,cId,id,map,vis);       // DFS will fill component stations
            }
        }

        List<Integer> res=new ArrayList<>();

        // Process each query
        for(int[] query:queries)
        {
            int type=query[0];                   // 1 or 2
            int x=query[1];                      // station number
            int xId=id[x];                       // which component this station belongs to

            TreeSet<Integer> set=map.get(xId);   // all online stations in this component

            if(type==1)                          // Query type 1: find representative
            {
                if(set!=null && set.contains(x)) // If x is online, return x
                    res.add(x);
                else if(set!=null && !set.isEmpty())
                    res.add(set.first());        // else return smallest online station
                else
                    res.add(-1);                 // no online stations left
            }
            else                                  // Query type 2: turn x offline
            {
                if(set!=null)
                    set.remove(x);               // Remove x from online set
            }
        }

        // Convert List<Integer> → int[]
        return res.stream().mapToInt(i -> i).toArray();
    }

    // DFS marks entire connected component
    public void dfs(int node,List<List<Integer>> adj,int cId,
                    int[] id,HashMap<Integer,TreeSet<Integer>> map,boolean[] vis)
    {
        vis[node]=true;                          // Mark current node visited
        map.computeIfAbsent(cId,k-> new TreeSet<>()).add(node);
                                                 // Add node to this component's TreeSet

        id[node]=cId;                             // Store component ID

        for(int nghbr:adj.get(node))              // Explore all neighbours
        {
            if(!vis[nghbr])                       // Visit unvisited neighbour
                dfs(nghbr,adj,cId,id,map,vis);
        }
    }
}
