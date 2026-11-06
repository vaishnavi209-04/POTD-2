//Approach 1-Sorting + HashMap + Sliding Window-O(l log l + q log q)
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs,(a,b)->Integer.compare(a[1],b[1]));//sort on basis of time
        
        int m=queries.length;
        int[][] q=new int[m][2];//time,idx
        for(int i=0;i<m;i++)
        {
            q[i][0]=queries[i];
            q[i][1]=i;
        }

        Arrays.sort(q,(a,b)->Integer.compare(a[0],b[0]));//sort on basis of time
        int[] res=new int[m];
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        
        for(int i=0;i<m;i++)
        {
            int start=q[i][0]-x;
            int end=q[i][0];

            while(r<logs.length && logs[r][1]<=end)//put servers into window
            {
                map.put(logs[r][0],map.getOrDefault(logs[r][0],0)+1);
                r++;
            }

            while(l<r && logs[l][1]<start)//remove outdated servers from window
            {
                map.put(logs[l][0],map.get(logs[l][0])-1);

                if(map.get(logs[l][0])==0)
                map.remove(logs[l][0]);

                l++;
            }
            res[q[i][1]]=n-map.size();
        }
        return res;
    }
}