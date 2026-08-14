//Approach 1:Sliding Window-O(n)
class Solution {
    public int maximumLengthSubstring(String s) {
        int[] arr=new int[26];
        int n=s.length();
        int start=0;
        int res=0;
        for(int i=0;i<n;i++)
        {
            int ch=s.charAt(i)-'a';
            arr[ch]++;
            while(arr[ch]>2)
            {
                int idx=s.charAt(start)-'a';
                arr[idx]--;
                start++;
            }
            res=Math.max(res,i-start+1);

        }
        return res;
    }
}