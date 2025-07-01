//Approach 1-Brute Force-O(n^2)
class Solution {
    public int possibleStringCount(String word) {
        int res=0;
        char[] arr=word.toCharArray();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            char prev=arr[i];
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]==prev)
                {
                res++;
                i++;
                }
                else
                break;
            }
        }
        return res+1;
    }
}
//Approach 2-Optimal-O(n)
class Solution {
    public int possibleStringCount(String word) {
        int res=0;
        char prev=word.charAt(0);
        int n=word.length();
        for(int i=1;i<n;i++)
        {
            char ch=word.charAt(i);
            if(ch==prev)
            res++;
            else
            prev=ch;
        }
        return res+1;
    }
}