class Solution {
    public int maxFreqSum(String s) {
        int vowelCount=0;
        int consCount=0;
        int[] arr=new int[26];
        for(char ch:s.toCharArray())
            {
                arr[ch-'a']++;
            }
        for(int i=0;i<26;i++)
            {
                char ch=(char)(i+'a');
                if(ch=='a' || ch=='e' ||ch=='i'||ch=='o'||ch=='u')
                {
                    vowelCount=Math.max(vowelCount,arr[i]);
                }
                else
                {
                    consCount=Math.max(consCount,arr[i]);
                }
            }
        return vowelCount+consCount;
    }
}