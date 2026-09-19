//Approach 1:O(n)
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        int xClosest=Math.max(x1,Math.min(xCenter,x2));
        int yClosest=Math.max(y1,Math.min(yCenter,y2));

        int dx=xClosest-xCenter;
        int dy=yClosest-yCenter;
//closest point in rectangle to circle lies within circle's radius or not
        return dx*dx+dy*dy<=radius*radius;
    }
}