//Approach 1-Custom Sort-O(n log n)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0])
            return Integer.compare(a[0],b[0]);

            return Integer.compare(b[1],a[1]);  });
        int count=0;
        int prev=0;//largest ending point so far
        for(int[] interval:intervals)
        {// [1,4],[2,8],[3,6]
            if(interval[1]>prev)
            {
                prev=interval[1];
                count++;
            }
        }
        return count;
    }
}