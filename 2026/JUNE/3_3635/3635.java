class Solution {
    long INFINITY=(long) 1e18;
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n1=waterStartTime.length;
        int[][] waterIntervals=new int[n1][2];

        for(int i=0;i<n1;i++)
            {
                waterIntervals[i][0]=waterStartTime[i];
                waterIntervals[i][1]=waterDuration[i];
            }
        Arrays.sort(waterIntervals,Comparator.comparingInt(a->a[0]));
        int[] waterStart=new int[n1];
        int[] waterDurations=new int[n1];

        for(int i=0;i<n1;i++)
            {
                waterStart[i]=waterIntervals[i][0];
                waterDurations[i]=waterIntervals[i][1];
            }
        long[] prefixWater=new long[n1];
        long[] suffixWater=new long[n1];

        long min=INFINITY;
        for(int i=0;i<n1;i++)
            {
                min=Math.min(min,waterDurations[i]);
                prefixWater[i]=min;
            }
        min=INFINITY;
        for(int i=n1-1;i>=0;i--)
            {
                min=Math.min(min,(long) waterDurations[i]+waterStart[i]);
                suffixWater[i]=min;
            }
        int n2=landStartTime.length;
        int[][] landIntervals=new int[n2][2];

        for(int i=0;i<n2;i++)
            {
                landIntervals[i][0]=landStartTime[i];
                landIntervals[i][1]=landDuration[i];
            }
        Arrays.sort(landIntervals,Comparator.comparingInt(a->a[0]));

        int[] landStart=new int[n2];
        int[] landDurations=new int[n2];

        for(int i=0;i<n2;i++)
            {
                landStart[i]=landIntervals[i][0];
                landDurations[i]=landIntervals[i][1];
            }
        long[] prefixLand=new long[n2];
        long[] suffixLand=new long[n2];

        min=INFINITY;
        for(int i=0;i<n2;i++)
            {
                min=Math.min(min,landDurations[i]);
                prefixLand[i]=min;
            }
        min=INFINITY;
        for(int i=n2-1;i>=0;i--)
            {
                min=Math.min(min,(long) landDurations[i]+landStart[i]);
                suffixLand[i]=min;
            }
        
        long res=INFINITY;
        for(int i=0;i<n2;i++)
            {
                long curr=(long) landStart[i] +landDurations[i];
                int pos=findFirstNotLess(waterStart,(int) curr);
                if(pos<n1)
                {
                    res=Math.min(res,suffixWater[pos]);
                }
                if(pos>0)
                {
                    res=Math.min(res,curr+prefixWater[pos-1]);
                }
            }
        
        for(int j=0;j<n1;j++)
            {
                long curr=(long) waterStart[j] + waterDurations[j];
                int pos=findFirstGreater(landStart,(int) curr);
                if(pos<n2)
                {
                    res=Math.min(res,suffixLand[pos]);
                }
                if(pos>0)
                {
                    res=Math.min(res,curr+prefixLand[pos-1]);
                }
            }
        return (int) res;
    }
    public int findFirstNotLess(int[] arr,int target)
    {
        int left=0;
        int right=arr.length;
        while(left<right)
            {
                int mid=left +(right-left)/2;
                if(arr[mid]<target)
                    left=mid+1;
                else
                    right=mid;
            }
        return left;
    }
    public int findFirstGreater(int[] arr,int target)
    {
        int left=0,right=arr.length;
        while(left<right)
            {
                int mid=left+(right-left)/2;
                if(arr[mid]<=target)
                    left=mid+1;
                else
                    right=mid;
            }
        return left;
    }
}