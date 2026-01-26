//Approach 1-Sorting-O(n log n)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(arr);
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++)
        {
            min=Math.min(min,arr[i+1]-arr[i]);
        }
        for(int i=0;i<n-1;i++)
        {
           List<Integer> temp=new ArrayList<>();
           boolean flag=false;
           if(arr[i+1]-arr[i]==min)
           {
            temp.add(arr[i]);
            temp.add(arr[i+1]);
            flag=true;
           }
           if(flag)
           list.add(temp);

        }
        return list;

    }
}