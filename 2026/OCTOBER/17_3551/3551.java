//Approach 1-Sort + track cycle-O(n log n)
class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int[][] arr=new int[n][2];//sum of digits,num
        for(int i=0;i<n;i++)
        {
            arr[i][0]=find(nums[i]);
            arr[i][1]=nums[i];
        }

        Arrays.sort(arr,(a,b)->{
        if(a[0]!=b[0])
        return Integer.compare(a[0],b[0]);
        return Integer.compare(a[1],b[1]);
        });

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(arr[i][1],i);//num,idx after swap
        }

        boolean[] vis=new boolean[n];
        int swaps=0;
        for(int i=0;i<n;i++)
        {
            if(vis[i])
            continue;

            int j=i;
            int cycle=0;
            while(!vis[j])
            {
                vis[j]=true;
                cycle++;
                j=map.get(nums[j]);
            }
            swaps+=Math.max(0,cycle-1);//each cycle needs a swap of cycle -1
        }
        return swaps;
    }
    public int find(int num)
    {
        int sum=0;
        while(num>0)
        {
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}