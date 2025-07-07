//Approach 1-Sorting + Priority Queue
//T.C-O(n log n)-sorting + O(maxDay log n)-pq
class Solution {
    public int maxEvents(int[][] events) {
        int maxDay=0;
        int n=events.length;
        for(int[] event:events)
        {
            maxDay=Math.max(maxDay,event[1]);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Arrays.sort(events,(a,b)-> a[0]-b[0]);//sort on the basis of start day
        int res=0;
        for(int i=1,j=0;i<=maxDay;i++)//i=1 as days start from 1 & j is index so it starts from 0
        {
            while(j<n && events[j][0]<=i)//if starting day lies on curr day or before curr day
            {
                pq.offer(events[j][1]);//push ending day in que
                j++;
            }
            while(!pq.isEmpty() && pq.peek()<i)//if ending day is also less than curr day 
            pq.poll();//then this day is not curr day
            if(!pq.isEmpty())
            {
                pq.poll();//this day is curr day
                res++;
            }
        }
        return res;
    }
}