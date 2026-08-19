//Approach 1:Hashing-O(m)
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        for(int[] arr:reservedSeats)
        {
            int row=arr[0];
            int seat=arr[1];
            map.putIfAbsent(row,new HashSet<>());
            map.get(row).add(seat);
        }
        //row with no occupied seat will have 2 groups each
        int res=(n-map.size())*2;
        for(HashSet<Integer> set:map.values())
        {
            boolean left=!set.contains(2) && !set.contains(3) && 
            !set.contains(4) && !set.contains(5);
            boolean middle=!set.contains(4) && !set.contains(5) &&
            !set.contains(6) && !set.contains(7);
            boolean right=!set.contains(6) && !set.contains(7) && 
            !set.contains(8) && !set.contains(9);

            if(left && right)
            res+=2;
            else if(left || middle || right)
            res+=1;
        }
        return res;
    }
}