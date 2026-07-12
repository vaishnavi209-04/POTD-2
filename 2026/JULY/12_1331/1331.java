//Approach 1: Sorting + Copying + Hashing -O(n log n)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0)
        return new int[0];

        int[] arr2=Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr);
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(arr[0],1);
        int n=arr.length;
        for(int i=1;i<n;i++)
        {
            int prev=map.get(arr[i-1]);
            if(arr[i]>arr[i-1])
            prev++;

            map.put(arr[i],prev);
        }
        int[] rank=new int[n];

        for(int i=0;i<n;i++)
        {
            int num=arr2[i];
            rank[i]=map.get(num);
        }

        return rank;
    }
}
//Approach 2: Treeset + Hashing -O(n log n)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        if(n==0)
        return new int[0];

        HashMap<Integer,Integer> map=new HashMap<>();
        TreeSet<Integer> set=new TreeSet<>();
        for(int num:arr)
        set.add(num);
        
        int rank=1;
        for(int num:set)
        {
            map.put(num,rank);
            rank++;
        }

        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            res[i]=map.get(arr[i]);
        }
        return res;
    }
}