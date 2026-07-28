//Approach 1-Sorting  + Reverse -O(n log n)
//Sort first half then append the reverse of the first half
class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        String half=s.substring(0,n/2);
        char[] arr=half.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb=new StringBuilder();
        for(char ch:arr)
        sb.append(ch);

        if(n%2!=0)
        sb.append(s.charAt(n/2));

        for(int i=n/2-1;i>=0;i--)
        {
           sb.append(sb.charAt(i));
        }
        return sb.toString();
    }
}