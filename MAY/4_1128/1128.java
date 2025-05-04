//Approach1:O(d^2)
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res=0;
        HashMap<String,Integer> map=new HashMap<>();
        for(int[] domino:dominoes)
        {
            int a=Math.min(domino[0],domino[1]);
            int b=Math.max(domino[0],domino[1]);
            String k=a+" "+b;
            res+=map.getOrDefault(k,0);
            map.put(k,map.getOrDefault(k,0)+1);
        }
        return res;
    }
}