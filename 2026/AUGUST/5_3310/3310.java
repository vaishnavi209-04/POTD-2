//Approach 1-BFS-O(m+n)
class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        //step 1: build adjacency list
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            adj[i]=new ArrayList<>();
        }
        //step 2: fill adjacaceny list and mark indegree of u->v (v nodes)
        int[] inDegree=new int[n];
        for(int[] arr:invocations)
        {
            adj[arr[0]].add(arr[1]);//u to v 
            inDegree[arr[1]]++;
        }
        //step 3: use que for bfs and an array sus for telling about sus nodes
        Queue<Integer> que=new LinkedList<>();
        que.offer(k);
        boolean[] sus=new boolean[n];
        sus[k]=true;
        //step 5: apply bfs
        while(!que.isEmpty())
        {
            int u=que.poll();
            for(int v:adj[u])//all nodes called by sus nodes also become sus
            {
                inDegree[v]--;//reduce indegree from sus nodes to check if it is called by a unsus node
                if(!sus[v])
                {
                    que.offer(v);
                    sus[v]=true;
                }
            }
        }
        //step 6: check if all sus nodes can be removed or not
        boolean all=true;
        List<Integer> rem=new ArrayList<>();
        for(int i=0;i<n;i++)
        {//we can't remove a sus node if it is called by any unsus node
        //we will either remove all sus nodes or not remove any if (above case)
            if(sus[i] && inDegree[i]>0)
            {
                all=false;
                break;
            }
            else if(!sus[i])
            rem.add(i);
        }

        if(!all)//if any sus node cannot be removed return all nodes otherwise return rem unsus nodes
        {
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++)
            list.add(i);
            return list;
        }

        return rem;

    }
}
//Approach 2-DFS-O(m+n)
class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        //step 1: build adjacency list
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            adj[i]=new ArrayList<>();
        }
        //step 2: fill adjacaceny list and mark indegree of u->v (v nodes)
        int[] inDegree=new int[n];
        for(int[] arr:invocations)
        {
            adj[arr[0]].add(arr[1]);//u to v 
            inDegree[arr[1]]++;
        }
        //step 3: use dfs and an array sus for telling about sus nodes
        
        boolean[] sus=new boolean[n];
        dfs(k,adj,sus,inDegree);


        //step 6: check if all sus nodes can be removed or not
        boolean all=true;
        List<Integer> rem=new ArrayList<>();
        for(int i=0;i<n;i++)
        {//we can't remove a sus node if it is called by any unsus node
        //we will either remove all sus nodes or not remove any if (above case)
            if(sus[i] && inDegree[i]>0)
            {
                all=false;
                break;
            }
            else if(!sus[i])
            rem.add(i);
        }

        if(!all)//if any sus node cannot be removed return all nodes otherwise return rem unsus nodes
        {
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++)
            list.add(i);
            return list;
        }

        return rem;

    }
    public void dfs(int u,List<Integer>[] adj,boolean[] sus,int[] inDegree)
    {
        sus[u]=true;
        for(int v:adj[u])
        {
            inDegree[v]--;
            if(!sus[v])
            dfs(v,adj,sus,inDegree);
        }
    }
}