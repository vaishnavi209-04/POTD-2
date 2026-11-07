//Approach 1: Priority Queue-O(m log m + n log n)
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> available=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])
            return Integer.compare(a[0],b[0]);//wt,idx

            return Integer.compare(a[1],b[1]);
        });
        PriorityQueue<int[]> busy=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])
            return Integer.compare(a[0],b[0]);//freeTime,wt,idx
            if(a[1]!=b[1])
            return Integer.compare(a[1],b[1]);

            return Integer.compare(a[2],b[2]);
        });

        int n=servers.length;
        int m=tasks.length;
        int[] res=new int[m];
        for(int i=0;i<n;i++)//initially all servers are available
        {
            available.offer(new int[]{servers[i],i});
        }

        long time=0;
        for(int i=0;i<m;i++)
        {
            time=Math.max(time,i);
            while(!busy.isEmpty() && busy.peek()[0]<=time)//remove free servers from busy queue
            {
                int[] server=busy.poll();
                available.offer(new int[]{server[1],server[2]});
            }
            if(available.isEmpty())//choose the earliest free time server from busy queue if no server is avail
            {
                time=busy.peek()[0];
                while(!busy.isEmpty() && busy.peek()[0]<=time)
                {
                int[] server=busy.poll();
                available.offer(new int[]{server[1],server[2]});
                }

            }
            int[] server=available.poll();//if server is avail
            int wt=server[0];
            int idx=server[1];

            res[i]=idx;
            busy.offer(new int[]{(int)(time+tasks[i]),wt,idx});
        }
        return res;
    }
}