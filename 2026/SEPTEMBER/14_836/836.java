//Approach 1:O(n)
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //when they don't overlap: case 1 : they are beside each other
        //case 2: they are in a column
        if(rec1[2]<=rec2[0] || rec2[2]<=rec1[0])
        return false;

        if(rec1[3]<=rec2[1] || rec2[3]<=rec1[1])
        return false;

        return true;
    }
}