//Approach 1-Math-O(1)
class Solution {
    public double angleClock(int hour, int minutes) {
        //360/60=6
        double minAngle=minutes * 6.0;
        //360/12=30
        //hour angle changes with min 30 degree/60 min=0.5
        double hourAngle=hour * 30.0 + minutes * 0.5;
        //diff because we need smaller angle
        double diff=Math.abs(hourAngle-minAngle);
        double res=Math.min(diff,360-diff);
        return res;
    }
}