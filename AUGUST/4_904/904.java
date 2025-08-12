//Approach 1-Sliding Window-O(n)
class Solution {
    public int totalFruit(int[] fruits) {
        int i=0;
        int n=fruits.length;
        int j=0;
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        while(j<n)
        {
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            if(map.size()<=2)//we have only 2 buckets
            {
                res=Math.max(res,j-i+1);//no of trees taken
            }
            else
            {
                map.put(fruits[i],map.getOrDefault(fruits[i],0)-1);//remove count of that fruit
                if(map.get(fruits[i])<=0)//remove fruit if it is <=0
                map.remove(fruits[i]);
                i++;//start with new basket
            }
            j++;//new tree
        }
        return res;
    }
}