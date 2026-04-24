class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left=0;
        int dash=0;
        for(char ch:moves.toCharArray())
        {
            if(ch=='L')
            left++;
            else if(ch=='_')
            dash++;
            else
            left--;
        }
        if(left>=0)
            left+=dash;
        else
            left-=dash;
        
        return Math.abs(left);
    }
}