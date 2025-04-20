//Approach 1:HashMap + Maths-O(n)
class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ans:answers)
        {
            map.put(ans,map.getOrDefault(ans,0)+1);
        }
        int total=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int x=entry.getKey();
            int count=entry.getValue();
            int groupSize=x+1;
            int group=(int)Math.ceil((double)count/groupSize);
            total+=groupSize*group;
        }
        return total;
    }
}
//Approach 2:Frequency Array + Maths-O(n)
class Solution {
    public int numRabbits(int[] answers) {
        int[] arr=new int[1001];
        for(int ans:answers)
        {
            arr[ans]++;
        }
        int total=0;
        for(int i=0;i<1001;i++)
        {
            if(arr[i]!=0)
            {
            int group=(int)Math.ceil((double)arr[i]/(i+1));
            total+=(i+1)*group;
            }
        }
        return total;
    }
}