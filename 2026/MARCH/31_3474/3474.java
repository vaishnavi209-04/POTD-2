//Approach 1-O(m * n)
class Solution {
    public String generateString(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        char[] arr=new char[n+m-1];
        Arrays.fill(arr,'#');
        //fill for T=> we must have str2 from T 
        for(int i=0;i<n;i++)
        {
            if(str1.charAt(i)=='T')
            {
                for(int j=i;j<i+m;j++)
                {//the index is already filled and it does not match str2 
                    if(arr[j]!='#' && arr[j]!=str2.charAt(j-i))
                    return "";

                    arr[j]=str2.charAt(j-i);//fill str2 from curr T index
                }
            }
        }
        //fill empty with 'a'
        boolean[] change=new boolean[m+n-1];
        for(int i=0;i<n+m-1;i++)
        {
            if(arr[i]=='#')
            {
                change[i]=true;//we can change this later to remove F violation
                arr[i]='a';
            }
        }
        
        //check for F=> we can't have str2 from F index
        for(int i=0;i<n;i++)
        {
            if(str1.charAt(i)=='F')
            {
                if(same(str2,arr,i,m))//String from F is same as str2
                {
                    boolean changed=false;//did we change anything 
                    //start from right to left to change lexicographically smaller string
                    for(int k=i+m-1;k>=i;k--)
                    {
                    if(change[k]==true)//can change
                    {
                       arr[k]='b';//b is second smallest
                       changed=true;
                       break;
                    }
                    }
                    if(!changed)//we can't change anything
                    return "";
                }
            }
        }
        return new String(arr);
    }
    public boolean same(String s,char[] arr,int i,int m)
    {
        StringBuilder sb=new StringBuilder();
        for(int j=i;j<i+m;j++)
        {
            sb.append(arr[j]);
        }
        if(sb.toString().equals(s))
        return true;

        return false;
    }
}