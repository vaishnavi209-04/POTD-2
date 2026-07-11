//Approach 1-BFS-O(n + e)
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());

        for(int[] edge:edges)//make adjacency list
        {
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                List<Integer> component=new ArrayList<>();
                Queue<Integer> que=new LinkedList<>();
            
                que.offer(i);
                vis[i]=true;
                while(!que.isEmpty())//make component 
                {
                    int u=que.poll();
                    component.add(u);
                    for(int v:adj.get(u))
                    {
                        if(!vis[v])
                        {
                            que.offer(v);
                            vis[v]=true;
                        }
                    }
                }
                boolean complete=true;
                for(int node:component)
                {//if any node in component is connected to any other node outside of component
                    if(adj.get(node).size()!=component.size()-1)
                    {
                        complete=false;
                        break;
                    }
                }
                if(complete)//count only complete components
                count++;

            }
        }
        return count;
    }
}
//Approach 2-Adjacency List-O(n + eloge)
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
           adj.add(new ArrayList<>());
           adj.get(i).add(i);
        }
        

        for(int[] edge:edges)//make adjacency list
        {
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        HashMap<List<Integer>,Integer> map=new HashMap<>();
        for(List<Integer> list:adj)
        {
            Collections.sort(list);//unique lists
            map.put(list,map.getOrDefault(list,0)+1);
        }
        int count=0;
        for(Map.Entry<List<Integer>,Integer> entry:map.entrySet())
        {//for a complete component of k vertices, each node should have k neighbours(including itself)
            if(entry.getKey().size()==entry.getValue())
            count++;
        }
        return count;
    }
}
//Approach 3-DFS-O(n + e)
//for a complete graph: for n vertices there must be n(n-1)/2 unique edges
//but in an undirected graph we are counting an edge twice so we must have here n(n-1) unique edges
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
           adj[i]=new ArrayList<>();
        }
        

        for(int[] edge:edges)//make adjacency list
        {
            int u=edge[0];
            int v=edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        
        int count=0;
        Set<Integer> vis=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            if(vis.contains(i))
            continue;

            int[] arr=new int[2];//arr[0]=vertices count arr[1]=total edges count
            dfs(i,adj,vis,arr);
            if(arr[0] *( arr[0]-1)==arr[1])
            count++;
        }
        return count;
    }
    public void dfs(int curr,List<Integer>[] adj,Set<Integer> vis,int[] arr)
    {
        vis.add(curr);
        arr[0]++;
        arr[1]+=adj[curr].size();

        for(int nghbr:adj[curr])
        {
            if(!vis.contains(nghbr))
            dfs(nghbr,adj,vis,arr);
        }
    }
}
//Approach 4-DSU-O(n + e alpha(n))
//for a complete graph: for n vertices there must be n(n-1)/2 unique edges
//but in an undirected graph we are counting an edge twice so we must have here n(n-1) unique edges
class Solution {
    class DSU{
        int[] parent;
        int[] size;
        DSU(int n)
        {
            parent=new int[n];
            size=new int[n];

            Arrays.fill(parent,-1);
            Arrays.fill(size,1);
        }
        int find(int x)
        {
            if(parent[x]==-1)
            return x;

            return parent[x]=find(parent[x]);
        }

        void union(int a,int b)
        {
            int pa=find(a);
            int pb=find(b);

            if(pa==pb)
            return;

            if(size[pa]>size[pb])
            {
                parent[pb]=pa;
                size[pa]+=size[pb];
            }
            else
            {
                parent[pa]=pb;
                size[pb]+=size[pa];
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        DSU dsu=new DSU(n);
        for(int[] edge:edges)
        {
            dsu.union(edge[0],edge[1]);
        }

        Map<Integer,Integer> map=new HashMap<>();
        for(int[] edge:edges)
        {
            int p=dsu.find(edge[0]);
            map.put(p,map.getOrDefault(p,0)+1);
        }

        int count=0;
        for(int i=0;i<n;i++)
        {
            if(dsu.find(i)==i)//if the curr node is parent of the component
            {
                int nodes=dsu.size[i];
                int e= nodes*(nodes-1)/2;//expected edges
                if(map.getOrDefault(i,0)==e)
                count++;
            }
        }
        return count;
    }
}