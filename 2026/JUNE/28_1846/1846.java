//Approach 1-Sorting + Greedy-O(n log n)
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int res=1;//arr should start with 1 
        //ideally the largest num can be n which is size of arr= [1,2,3,4]
        //but we can only decrease any num not increase
        //sp keep on increasin res until it is less than num of arr after sorting
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>=res+1)
            res++;
        }
        return res;
        
    }
}
//Approach 2-Optimal-O(n)
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        int[] freq=new int[n+1];
        //count freq of each num in arr and treat every num > n as n because we can decrease it to n
        for(int num:arr)
        {
            freq[Math.min(num,n)]++;
        }
        int res=1;
        //if there are more spots than the num then we can't dec we have to find greater 
        //but if there are less spots than the num then we can dec it to n 
        for(int i=2;i<=n;i++)
        {
            res=Math.min(i,res+freq[i]);
        }
        return res;
    }
}