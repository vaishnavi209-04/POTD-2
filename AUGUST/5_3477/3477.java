//Approach 1-O(n^2)
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count=0;
        int n=baskets.length;
        for(int fruit:fruits)
        {
            boolean left=true;
            for(int i=0;i<n;i++)
            {
                if(fruit<=baskets[i])
                {
                    baskets[i]=0;
                    left=false;
                    break;
                }
            }
            if(left)
            count++;
        }
        return count;
    }
}