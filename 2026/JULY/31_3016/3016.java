//Approach 1:Greedy Sorting-O(n)
class Solution {
    public int minimumPushes(String word) {
        int[] arr=new int[26];
        for(char ch:word.toCharArray())
        {
            arr[ch-'a']++;
        }
        
        Arrays.sort(arr);
        for(int i=0;i<=12;i++)
        {
            int temp=arr[i];
            arr[i]=arr[26-i-1];
            arr[26-i-1]=temp;
        }

        int ans=0;
        for(int i=0;i<26;i++)
        {
            if(arr[i]==0)
            break;

            ans+=(i/8 +1) * arr[i];
        }

        return ans;    

    }
}