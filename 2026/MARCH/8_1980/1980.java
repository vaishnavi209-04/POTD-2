//Approach 1-Backtracking-O(2^n)
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> check=new HashSet<>();
        for(String num:nums)
        check.add(num);
        StringBuilder sb=new StringBuilder();
        String[] res=new String[1];
        solve(0,nums.length,check,sb,res);
        return res[0];
    }
    public void solve(int index,int n,Set<String> check,StringBuilder sb,String[] res)
    {
        if(index==n)
        {
            if(!check.contains(sb.toString()))
            {
                res[0]=sb.toString();
            }
            return;
        }
           sb.append('0');
           solve(index+1,n,check,sb,res);
           if(res[0]!=null)
           return;
           sb.deleteCharAt(sb.length()-1);
           sb.append('1');
           solve(index+1,n,check,sb,res);
           if(res[0]!=null)
           return;
           sb.deleteCharAt(sb.length()-1);
    }
}
//Approach 2-Simple conversion-O(n^2)-no need to check to 2^n-1 in loop just check upto n
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set=new HashSet<>();
        int n=nums.length;
        for(String num:nums)
        {
            set.add(Integer.parseInt(num,2));//converting binary string into decimal before adding to set
        }
        String res="";
        for(int i=0;i<=n;i++)
        {
          if(!set.contains(i))
          {
            res=Integer.toBinaryString(i);//converting integer to binary string 
            while(res.length()<n)
            {
                res="0"+res;//to make it equal with size n
            }
            return res;
          }
        }
        return "";
    }
}
//Approach 3-Matching Character-O(n)
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
           sb.append(nums[i].charAt(i)=='0'?"1":"0");
        }
        return sb.toString();
    }
}