//Approach 1-Heap 
//T.c- O(q log q)+ O(n * (q log q))
class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n=nums.length;
        int q=queries.length;
        //putting ending index of queries in maxheap
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        //pastqueries used are put in past minheap
        PriorityQueue<Integer> past=new PriorityQueue<>();
        //sorting queries on basis of starting index
        Arrays.sort(queries,(a,b)->Integer.compare(a[0],b[0]));//O(q log q)
        int usedQuery=0;
        int j=0;
        for(int i=0;i<n;i++)//O(n)
        {
            //putting ending of query with starting at i in maxheap
            while(j<q && queries[j][0]==i)//O(q)
            {
               maxHeap.offer(queries[j][1]);
               j++;
            }
            //nums[i] has got processed past queries every time so decrease
            nums[i]-=past.size();
            while(nums[i]>0 && !maxHeap.isEmpty() && maxHeap.peek()>=i)//O(q)
            {
                int curr=maxHeap.poll();//O(log q)
                past.offer(curr);//we used it
                nums[i]--;
                usedQuery++;
            }
            //if nums[i] is still not 0 then it can never be 0 as queries is sorted if curr index is not getting 0 then in future current index will stop getting affected by queries
            if(nums[i]>0)
            return -1;
            //remove the past queries used if the curr index is already at the ending of the min query in past
            while(!past.isEmpty() && past.peek()==i)//O(q log q)
            past.poll();
        }
        return q-usedQuery;
    }
}