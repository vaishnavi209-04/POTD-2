//Approach 1-Sorting + Greedy - O(n log n)
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long curr=mass;

        for(int wt:asteroids)
        {
            if(curr < wt)
            return false;

            curr+=wt;
        }
        return true;
    }
}