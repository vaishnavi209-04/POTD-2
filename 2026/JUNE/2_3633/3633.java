//Approach 1-O(n1*n2)
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minTime=Integer.MAX_VALUE;
        int n1=landStartTime.length;
        int n2=waterStartTime.length;
        for(int i=0;i<n1;i++)
            {
                for(int j=0;j<n2;j++)
                    {
                        int landEnd=landStartTime[i]+landDuration[i];
                        int startWater=Math.max(landEnd,waterStartTime[j]);
                        int time1=startWater+waterDuration[j];
                        
                        int waterEnd=waterStartTime[j]+waterDuration[j];
                        int startLand=Math.max(waterEnd,landStartTime[i]);
                        int time2=startLand+landDuration[i];

                        minTime=Math.min(minTime,Math.min(time1,time2));
                    }
            }
        return minTime;
    }
}