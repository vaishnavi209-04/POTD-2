//Approach 1:BS on answers
//T.C : O(m log m+ n log n+ min(m,n)∗log(min(m,n))∗log(min(m,n)))
//S.C: O(n)
class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int m=tasks.length;
        int n=workers.length;
        int l=0;
        int r=Math.min(m,n);//at max you can only perform the min from number of tasks or workers as 1 worker can perform only 1 task and vice versa
        Arrays.sort(tasks);// m log m
        Arrays.sort(workers);// n log n
        int res=0;
        while(l<=r)//min(m,n)
        {
          int mid=l+(r-l)/2;
          if(check(tasks,workers,pills,strength,mid))//if we can perform mid number of tasks
          {
            res=mid;//store it in result
            l=mid+1;//check if more tasks can be done
          }
          else
          {
            r=mid-1;//check for lesser number of tasks
          }
        }
        return res;
    }
    public boolean check(int[] tasks,int[] workers,int pills,int strength,int mid)//log (min(m,n ))
    {
        TreeMap<Integer,Integer> map=new TreeMap<>();//stores in asc order
        for(int i=workers.length-mid;i<workers.length;i++)//best mid workers
        {
            map.put(workers[i],map.getOrDefault(workers[i],0)+1);
        }
        for(int i=mid-1;i>=0;i--)
        {
            Integer key = map.lastKey();
            if (key >= tasks[i]) {
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) {
                    map.remove(key);
                }
            } else {
                if (pills == 0) {
                    return false;
                }
                key = map.ceilingKey(tasks[i] - strength);
                if (key == null) {
                    return false;
                }
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) {
                    map.remove(key);
                }
                --pills;
            }
        }
        return true;
    }
}