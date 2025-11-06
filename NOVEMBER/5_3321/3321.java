//Approach 1-Hashing
//T.C -> O(n log x)
//S.C -> O(n)
class Solution {
    long sum=0;
    //store in sorted manner and can check anytime whether the value is present or not
    TreeSet<int[]> set=new TreeSet<>((a,b)-> a[0]==b[0] ? a[1]-b[1]:a[0]-b[0]);//smaller first
    TreeSet<int[]> rem=new TreeSet<>((a,b)-> a[0]==b[0] ? a[1]-b[1]:a[0]-b[0]);//remaining
    public long[] findXSum(int[] nums, int k, int x) {
        //number,freq
        Map<Integer,Integer> map=new HashMap<>();
        int i=0,j=0;
        int n=nums.length;
        long[] res=new long[n-k+1];
        int c=0;
        while(j<n)
        {
            //remove old freq
            if(map.getOrDefault(nums[j],0)>0)
            {
                removeFromSet(new int[]{map.get(nums[j]),nums[j]},x);
            }
            //update new freq
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            insertInSet(new int[]{map.get(nums[j]),nums[j]},x);
            //sliding window
            if(j-i+1==k)
            {
                res[c++]=sum;
                //remove freq of ith element and update maps
                removeFromSet(new int[]{map.get(nums[i]),nums[i]},x);
                map.put(nums[i],map.get(nums[i])-1);
                //key exists but freq is 0
                if(map.get(nums[i])==0)
                map.remove(nums[i]);
                else//update decreased freq
                insertInSet(new int[]{map.get(nums[i]),nums[i]},x);
                i++;
            }
            j++;//inc size of window
        }
        return res;
    }
    public void insertInSet(int[] arr,int x)
    {
        //if main set has size<x or the new value has greater freq than smallest freq of main set
        if(set.size()<x || compare(arr,set.first())>0)
        {
            //add the new value and remove the smallest and update every data structure acc.
            set.add(arr);
            sum+=1L* arr[0]* arr[1];
            if(set.size()>x)
            {
                int[] smallest=set.first();
                sum-=1L* smallest[0]* smallest[1];
                set.remove(smallest);
                rem.add(smallest);
            }
        }
        else
            rem.add(arr);
    }
    public void removeFromSet(int[] arr,int x)
    {
    //if the value to be removed is present in main set then removes it and returns true in if
        if(set.remove(arr))
        {//remove the new value and update acc.
            sum-=1L* arr[0]* arr[1];
            if(!rem.isEmpty())
            {
                int[] largest=rem.last();
                rem.remove(largest);
                set.add(largest);
                sum+=1L* largest[0]* largest[1];
            }
        }
        else//if not present in main then remove from remaining acc.
            rem.remove(arr);
    }
    //compare new value to old value (freq,num)
    //return value with larger freq if same then return larger num
    public int compare(int[] arr1,int[] arr2)
    {
        if(arr1[0]!=arr2[0])
        return Integer.compare(arr1[0],arr2[0]);

        return Integer.compare(arr1[1],arr2[1]);
    }
}