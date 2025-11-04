//Approach 1-O(n * 51 * x log x)
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int i=0;
        int j=0;
        int n=nums.length;
        int[] res=new int[n-k+1];//given in question
        int c=0;
        int[] count=new int[51];//counting freq
        while(j<n)//sliding window
        {
            count[nums[j]]++;
            while(j-i+1==k)//needed subarray formed 
            {
                res[c++]=solve(count,x);
                count[nums[i]]--;
                i++;
            }
            j++;
        }
        return res;
    }
    public int solve(int[] arr,int x)
    {
        int res=0;
        //if freq is same then we remove lesser number
        //otherwise remove lesser frequency
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[1]==b[1])
            return a[0]-b[0];
            return a[1]-b[1];
    });
        for(int i=0;i<51;i++)
        {
           if(arr[i]>0)
           pq.offer(new int[]{i,arr[i]});
           //we only need x frequencies
           if(pq.size()>x)
           pq.poll();
        }
        while(!pq.isEmpty())
        {
            int[] num=pq.poll();
            res+=num[0]*num[1];
        }
        return res;
    }
}