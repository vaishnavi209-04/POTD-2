class Solution {
    public String addBinary(String a, String b) {
      int n1=a.length()-1;
      int n2=b.length()-1;
      int carry=0;
      int sum=0;
      int base=2;
      StringBuilder result=new StringBuilder();
      while(n1>=0 || n2>=0 ||carry!=0) 
      {
         sum=carry;
         if(n1>=0)
         {
            sum+=a.charAt(n1--)-'0';   
         }
         if(n2>=0)
         {
            sum+=b.charAt(n2--)-'0';   
         }
         result.append(sum%base);
         carry=sum/base;
      }
      return result.reverse().toString();
    }
}