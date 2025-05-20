//Approach 1:Difference Array 
//T.C-O(q+n)
//S.C-O(n)
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int q=queries.length;
        int[] diffArr=new int[n];//in this at (query[0])th index we increment and at query[1]+1)th index we decrement;
        for(int[] query:queries)
        {
            int start=query[0];
            int end=query[1]+1;
            diffArr[start]++;
            if(end<n)//it is not out of bounds
            diffArr[end]--;
        }
        int[] cumArr=new int[n];//in this we will store the number of operations we are going to perform on each index in nums
        int cumSum=0;
        for(int i=0;i<n;i++)
        {
           cumSum+=diffArr[i];
           cumArr[i]=cumSum;
        }
        for(int i=0;i<n;i++)
        {
            if(cumArr[i]<nums[i])
            return false;
        }
        return true;
    }
}