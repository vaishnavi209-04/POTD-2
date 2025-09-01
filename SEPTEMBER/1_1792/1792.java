//Approach 1-
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n=classes.length;
        PriorityQueue<double[]> que=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        for(int i=0;i<n;i++)
        {
            double pr=(double)classes[i][0]/classes[i][1];
            double newpr=(double)(classes[i][0]+1)/(classes[i][1]+1);
            double delta=newpr-pr;
            que.offer(new double[]{delta,i});
        }
       while(extraStudents-->0)
       {
         double[] curr=que.poll();
         int index=(int)curr[1];
         classes[index][0]++;
         classes[index][1]++;
         double pr=(double)classes[index][0]/classes[index][1];
            double newpr=(double)(classes[index][0]+1)/(classes[index][1]+1);
            double delta=newpr-pr;
            que.offer(new double[]{delta,index});
       }
       double result=0.0;
       for(int i=0;i<n;i++)
       result+=(double)classes[i][0]/classes[i][1];
       return result/n;
  }
}