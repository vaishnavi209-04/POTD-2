//Approach 1-O(1)
class Solution {
    public int countOdds(int low, int high) {
        int count=high-low+1;
        if(count%2==0)
        return count/2;
        else
        {
            if(high%2==0 && low%2==0)
            return count/2;
            else
            return (count+1)/2;
        }
    }
}