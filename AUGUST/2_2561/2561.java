//Approach 1-Hashing+Sorting+Greedy
//T.C-O(n log n)
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        //keeps cost and its overall count
        HashMap<Integer,Integer> map=new HashMap<>();
        //min from basket1 and basket2
        int min=Integer.MAX_VALUE;
        int n=basket1.length;
        //increment count for basket1
        for(int i=0;i<n;i++)
        {
            map.put(basket1[i],map.getOrDefault(basket1[i],0)+1);
            min=Math.min(min,basket1[i]);
        }
        //decrement count for basket2
        for(int i=0;i<n;i++)
        {
            map.put(basket2[i],map.getOrDefault(basket2[i],0)-1);
            min=Math.min(min,basket2[i]);
        }
        //stores costs needed to get swapped
        ArrayList<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            int cost=entry.getKey();
            int count=entry.getValue();
            //cost is balanced in both baskets
            if(count==0)
            continue;
            //cost can't be divided in both baskets so not possible case
            if(count%2!=0)
            return -1;
            //eg:if there are two 2s then you only need to swap one 2
            //map can have -ve values too so use abs
            for(int i=1;i<=Math.abs(count)/2;i++)
            {
                list.add(cost);
            }
        }
        //sort in asc order for min swapping cost
        Collections.sort(list);
        int l=list.size();
        long res=0;
        //we will swap first half of list with second half
        //there are two ways of swapping 
        //swap largest of basket1 with smallest of basket2 and vice versa or indirect swapping
        //in indirect swapping we first swap with min element of basket1 and then min element of basket2 so min*2 cost 
        for(int i=0;i<l/2;i++)
        {
            res+=Math.min(list.get(i),2*min);
        }
        return res;
    }
}