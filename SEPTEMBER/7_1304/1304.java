//Approach 1
class Solution {
    public int[] sumZero(int n) {
        int[] res=new int[n];
        int m=n/2;
        if(n%2!=0)
        {
          for(int i=0;i<m;i++)
          {
          res[i]=(i+1)*-1;
          res[n-i-1]=(i+1);
          }
          res[m]=0;
        }
        else
        {
           for(int i=0;i<m;i++)
          {
          res[i]=(i+1)*-1;
          res[n-i-1]=(i+1);
          } 
        }
        return res;
    }
}