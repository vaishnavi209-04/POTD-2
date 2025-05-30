//Approach 1-DFS
//T.C-O(V+E)
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int m=edges1.length+1;
        int n=edges2.length+1;
        //make adjacency list for both trees
        List<List<Integer>> adjA=adjList(edges1,m);
        List<List<Integer>> adjB=adjList(edges2,n);
        //mark array with 0 and 1 alternatively
        //0 node has even nodes at 0
        //1 node has even nodes at 1
        int[] markA=new int[m];
        Arrays.fill(markA,-1);
        int[] markB=new int[n];
        Arrays.fill(markB,-1);
        //count no. of nodes with mark 0 and 1 as it remain same
        //0th index with nodes marked 0 count and 1th with mark 1 
        int[] countA=new int[2];
        int[] countB=new int[2];
        //start dfs from 0th node and mark it 0
        markA[0]=0;
        markB[0]=0;
        //dfs(curr,adjlist,parentnode,zerocount,onecount)
        dfs(0,adjA,-1,markA,countA);
        dfs(0,adjB,-1,markB,countB);
        //for max connect to the node with max ans
        int max=Math.max(countB[0],countB[1]);
        //calc in tree1 + max in tree2 after connecting to it
        int[] res=new int[m];
        for(int i=0;i<m;i++)
        {
           int mark=markA[i];
           res[i]=mark==0?countA[0]+max:countA[1]+max;
        }
           return res;
    }
    public List<List<Integer>> adjList(int[][] edges,int n)
    {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        list.add(new ArrayList<>());
        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        return list;
    }
    public void dfs(int curr,List<List<Integer>> adj,int parent,int[] mark,int[] count)
    {
        if(mark[curr]==0)
        count[0]++;
        else
        count[1]++;
        for(int nghbr:adj.get(curr))
        {
            if(nghbr!=parent)
            {
                mark[nghbr]=mark[curr]==0?1:0;
                dfs(nghbr,adj,curr,mark,count);
            }
        }
    }
}