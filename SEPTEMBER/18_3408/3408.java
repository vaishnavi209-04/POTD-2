//Approach 1-O(log n)
//we are not removing from pq because of tle
class TaskManager {
    class Task{
        int user;
        int id;
        int p;
        Task(int user,int id,int p)
        {
            this.user=user;
            this.id=id;
            this.p=p;
        }
    }

    PriorityQueue<Task> pq;
    Map<Integer,Task> map;

    public TaskManager(List<List<Integer>> tasks) {
        pq=new PriorityQueue<>((a,b)->
        {
            if(a.p!=b.p)
            return b.p-a.p;
            return b.id-a.id;
        });
        map=new HashMap<>();

        for(List<Integer> temp:tasks)
        {
           Task t=new Task(temp.get(0),temp.get(1),temp.get(2));
           map.put(temp.get(1),t);
           pq.add(t);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task t=new Task(userId,taskId,priority);
        pq.add(t);
        map.put(taskId,t);
    }
    
    public void edit(int taskId, int newPriority) {

        Task oldTask=map.get(taskId);
        Task newTask=new Task(oldTask.user,taskId,newPriority);
        pq.add(newTask);
        map.put(taskId,newTask);
    }
    
    public void rmv(int taskId) {
        Task t=map.remove(taskId);
    }
    
    public int execTop() {
        while(!pq.isEmpty())
        {
        Task t=pq.poll();
        //in map some values can get overwrite but in pq we are not removing so we need to check exact
        if(map.get(t.id)==t)
        {
           map.remove(t.id);
           return t.user;
        }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */