//Approach 1- Recursion + Sorting--O(n^2)
class Solution {
    public String makeLargestSpecial(String s) {
        List<String> special=new ArrayList<>();
        int sum=0;
        int start=0;
        int n=s.length();
        for(int i=0;i<n;i++)//O(n)
        {
            sum+=s.charAt(i)=='1'?1:-1;
            if(sum==0)
            {
                String inner=s.substring(start+1,i+1);//T(n-2)
                special.add("1"+makeLargestSpecial(inner)+"0");
                start=i+1;
            }
        }
        Collections.sort(special,Collections.reverseOrder());//if m special string parts then m log m
        String res="";
        for(String str:special)//O(n)
        {
            res+=str;//string concatenation is O(n)
        }
        return res;
    }
}