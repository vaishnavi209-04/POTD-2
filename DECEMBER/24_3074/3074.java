//Approach 1-O(n+ m log m)
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int count=0;
        Arrays.sort(capacity);
        int sum=0;

        for(int ap:apple)
        {
            sum+=ap;
        }
        for(int i=capacity.length-1;i>=0;i--)
        {
            if(sum<=0)
            break;
            sum-=capacity[i];
            count++;
        }
        return count;
    }
}