//Approach 1:BS on answers + TreeMap(working as multiset here)
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
    public boolean check(int[] tasks,int[] workers,int pills,int strength,int mid)//O(mid log mid)
    {//in worst case mid will be min(m,n) => O(min(m,n)*log(min(m*n)))
        TreeMap<Integer,Integer> map=new TreeMap<>();//stores in asc order
        for(int i=workers.length-mid;i<workers.length;i++)//best mid workers
        {
            map.put(workers[i],map.getOrDefault(workers[i],0)+1);//strength of workers and their count
        }
        for(int i=mid-1;i>=0;i--)//O(mid)
        //every task in treemap is O(log mid)-> getting, removing, lastKey,ceiling Key,etc
        {
            Integer key = map.lastKey();//keys are stored in asc order so lastKey is giving is the largest value=strongest worker in best mid workers
            if (key >= tasks[i]) {
                map.put(key, map.get(key) - 1);//if worker's strength is greater than task's
                if (map.get(key) == 0) {
                    map.remove(key);
                }
            } else {
                if (pills == 0) {//if no pills left then return false 
                    return false;
                }
                key = map.ceilingKey(tasks[i] - strength);//ceilingKey gives the value greater than or equal to tasks's strength -strength can be added by pill because we are going to use pill
                if (key == null) {//if no such key exists return false
                    return false;
                }
                map.put(key, map.get(key) - 1);//we are using the pill now so reduce the key's count
                if (map.get(key) == 0) {//if key's count is 0
                    map.remove(key);
                }
                --pills;//reduce pills' count
            }
        }
        return true;
    }
}
//Approach 2:BS on answers + Monotonic queue
//T.C : O(m log m+ n log n+ min(m,n)∗log(min(m,n))
//S.C: O(min(m,n))
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
    public boolean check(int[] tasks,int[] workers,int pills,int strength,int mid)//O(mid)
    {
        Deque<Integer> taskList=new ArrayDeque<>();//all it's tasks are O(1)
        int taskIdx=0;
        for(int i=workers.length-mid;i<workers.length;i++)
        {
            int w=workers[i];
            while(taskIdx< mid && tasks[taskIdx]<=w+strength)//put all the tasks which can be done by workers after eating pills and without pills included already
            {
            taskList.addLast(tasks[taskIdx]);
            taskIdx++;
            }
            if(taskList.isEmpty())//if no such task exists
            return false;
            if(taskList.peekFirst()<=w)//if curr worker can do the task easily then remove the easiest task
            {
            taskList.pollFirst();
            }
            else//to maximise the use of pill match the worker with hardest task
            {
                if(pills==0)
                return false;
                pills--;
                taskList.pollLast();
            }
        }
        return true;
    }
}
