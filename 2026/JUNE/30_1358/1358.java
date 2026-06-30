//Approach 1-O(n)
class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int l=0;
        int r=0;
        int[] freq=new int[3];
        int res=0;

        while(r<n)
        {
            char ch=s.charAt(r);
            freq[ch-'a']++;
            while(isValid(freq))//contains a valid subarray 
            {
                res+=n-r;//start to r all are valid subarrays
                char left=s.charAt(l);//start shrinking window from left
                freq[left-'a']--;
                l++;
            }
            r++;
        }
        return res;

    }
    public boolean isValid(int[] arr)
    {
        return arr[0]>0 && arr[1]>0 && arr[2]>0;
    }
}