//Approach 1
//O(n)
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long res=0;
        long minLoss=Integer.MAX_VALUE;
        int count=0;
        for(int num:nums)
        {
            int xor=num ^ k;
            if(xor >num)
            {
            res+=xor;
            count++;//kitne pair ban skte hai vo pata krne ke liye
            }
            else
            res+=num;
            minLoss=Math.min(minLoss,Math.abs(xor-num));
        }
        //saare pair ban rhe hai to max sum already ho jayega 
        //saare nhi ban rhe to min loss wala num lege jo already calc kr chuke hai 
        //eg: 78 ^ 6= 72 && 44 ^ 6=42
        //78+42=120 
        //72+44=116
        //(78-72)=6
        //(44-42)=2
        //2<6
        //so subtract 2 as we add num not xor for that number
        res= count%2==0?res:res-minLoss;
        return res;
    }
}
//Approach 2-Greedy
//T.C-O(n log n)
//S.C-O(n)
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum=0;
        int n=nums.length;
        List<Integer> profit=new ArrayList<>();
        for(int num:nums)
        {
            sum+=(long)num;
            profit.add((num ^ k)- num);
        }
        //this same function can work for arrays if we use Integer in place of int
        Collections.sort(profit,Collections.reverseOrder());
        for(int i=0;i<n-1;i+=2)
        {
            long pair=profit.get(i)+profit.get(i+1);
            if(pair>0)//if profit is there then add xor values-num (as we already added num earlier)
            {
                sum+=pair;
            }
        }
        return sum;
    }
}