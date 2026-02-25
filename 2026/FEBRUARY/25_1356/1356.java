//Approach 1-PriorityQueue-O(n log n)
class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->{
                if(a[0]==b[0])
                return Integer.compare(a[1],b[1]);

                return Integer.compare(a[0],b[0]);
            }
        );
        for(int num:arr)
        {
            int count=Integer.bitCount(num);
            pq.offer(new int[]{count,num});
        }
        int n=arr.length;
        int[] res=new int[n];
        int i=0;
        while(!pq.isEmpty())//O(n)
        {
            res[i++]=pq.poll()[1];//O(log n)
        }
        return res;
    }
}