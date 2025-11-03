//Approach 1-
//O(n)
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int prev = 0;
        int res = 0;
        int n = colors.length();
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(prev)) {
                res += Math.min(neededTime[i], neededTime[prev]);
                if (neededTime[i] > neededTime[prev])
                    prev = i;
            } else
                prev = i;
        }
        return res;
    }
}