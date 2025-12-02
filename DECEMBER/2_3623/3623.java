//Approach 1-Maths + Hashing -O(N)
class Solution {
    public int countTrapezoids(int[][] points) {
        //store y co-ordinate,its' freq
        //for two lines to make horizontal trapezoids we need points with same y co-ordinate
        HashMap<Integer,Integer> map=new HashMap<>();
        long res=0;
        long total=0;
        int mod=1_000_000_007;
        for(int[] point:points)
        {
           map.put(point[1],map.getOrDefault(point[1],0)+1);
        }
        //n points make n*(n-1)/2 pairs
        //now new pair can make pairs with prev pairs also so total*pairs and then update total
        for(int num:map.values())
        {
            long pairs=((long)num*(num-1))/2;
            res=(res + total*pairs)%mod;
            total=(total+ pairs)%mod;
        }
        return (int)res;
    }
}