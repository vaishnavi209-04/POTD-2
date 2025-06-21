//Approach 2-Modified Brute force-O(n)
class Solution {
    public int minimumDeletions(String word, int k) {
        int[] arr=new int[26];
        for(char ch:word.toCharArray())
        {
            arr[ch-'a']++;
        }
        int res=Integer.MAX_VALUE;
        for(int num:arr)
        {
            if(num==0)
            continue;
            int min=0;//for current character count
            int maxFreq=num;//assume this is the most frequent character's count
            for(int x:arr)
            {
                //some other count is less than most freq char so reduce it for min deletions
                if(x<maxFreq)
                min+=x;
                //to make it k special remove extra characters from x to make it equal to maxFreq+k
                //no need for abs as we already checked for j>i
                //without abs it becomes j-i<=k
                //j>k+i--condition we want
                else if(x>maxFreq+k)
                min+=x-maxFreq-k;
            }
            //min after assuming every character as most frequent
            res=Math.min(res,min);
        }
        return res;
    }
}