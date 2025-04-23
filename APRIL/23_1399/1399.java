//Approach 1:HashMap-O(n^2)
class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;//maximum count of group elements
        int count=0;//count of groups with maximum elements
        for(int i=1;i<=n;i++)
        {
            int sum=digitSum(i);//calculating digit sum of every element from 1 to n
            map.put(sum,map.getOrDefault(sum,0)+1);//storing count for each digit sum for grouping
            if(map.get(sum)==max) //count of max size group
            count++;
            else if(map.get(sum)>max)//refresh for an even bigger size
            {
                max=map.get(sum);
                count=1;
            }
        }
        return count;
    }
    public int digitSum(int n)
    {
        int sum=0;
        while(n>0)
        {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}