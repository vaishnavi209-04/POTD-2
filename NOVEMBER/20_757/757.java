//Approach 1-Sorting + Greedy -O(n log n)
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        //sort in inc of ending intervals if end is same then in dec order of starting
        Arrays.sort(intervals,(a,b)->{
            if(a[1]==b[1])
            return Integer.compare(b[0],a[0]);
            return Integer.compare(a[1],b[1]);
        });
        //take last 2 numbers of first interval so that we can check if they come in other intervals and we have to take 2 numbers for curr also so this is the optimised approach
        int secondLast=intervals[0][1]-1;
        int last=intervals[0][1];
        int n=intervals.length;
        int count=2;
        for(int i=1;i<n;i++)
        {
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];
            //if secondlast is greater then last will also be so no need to check
            if(secondLast>=currStart)
            continue;
            else if(last>=currStart)//check whether last is also small or not
            {
            count++;
            secondLast=last;
            last=currEnd;
            }
            else
            {
            count+=2;
            secondLast=currEnd-1;
            last=currEnd;
            }
        }
        return count;
    }
}