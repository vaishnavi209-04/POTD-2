class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n= nums.length;
        int temp[]= nums.clone();
        Arrays.sort(temp);

        int groupNumber=0;
        Map<Integer,Integer> mapGroup= new HashMap<>();
        mapGroup.put(temp[0],groupNumber); 
        Map<Integer,LinkedList<Integer>> map2 = new HashMap<>(); // stores the elements
        map2.putIfAbsent(groupNumber,new LinkedList<>());
        map2.get(groupNumber).add(temp[0]);

        for(int i=1;i<n;i++){
            if(Math.abs(temp[i]-temp[i-1])>limit){
                groupNumber++;
            }

            mapGroup.put(temp[i],groupNumber);
            map2.putIfAbsent(groupNumber,new LinkedList<>());
            map2.get(groupNumber).add(temp[i]);

        }

        int res[]= new int[n];
        for(int i=0;i<n;i++){
            int group= mapGroup.get(nums[i]);
            res[i]= map2.get(group).pollFirst();
        }

        return res;    
    }
}