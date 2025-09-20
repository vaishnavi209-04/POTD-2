//Approach 2--Binary search--O(n log n)
class Router {
    int n;
    Queue<int[]> que;
    Set<String> set;
    Map<Integer,List<Integer>> map;

    public Router(int memoryLimit) {
        n=memoryLimit;
        que=new LinkedList<>();
        set=new HashSet<>();
        map=new HashMap<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        String key=source +"_"+destination+"_"+timestamp;
        if(set.contains(key))
        return false;
        if(que.size()>=n)
        {
        int[] oldp=que.poll();
        String oldKey=oldp[0]+"_"+oldp[1]+"_"+oldp[2];
        set.remove(oldKey);
        map.get(oldp[1]).remove(0);
        }
        int[] p={source,destination,timestamp};
        que.offer(p);
        set.add(key);
        map.putIfAbsent(destination,new ArrayList<>());
        map.get(destination).add(timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        if(que.isEmpty())
        return new int[]{};

        int[] p=que.poll();
        String key=p[0]+"_"+p[1]+"_"+p[2];
        set.remove(key);
        map.get(p[1]).remove(0);
        return p;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if(!map.containsKey(destination))
        return 0;
        List<Integer> list=map.get(destination);
        int l=lowerBound(list,startTime);
        int h=upperBound(list,endTime);
        return Math.max(0,h-l);
    }
    public int lowerBound(List<Integer> list, int x) {
        int l = 0, r = list.size();
        while (l < r) 
        {
            int m = l+(r-l)/2;
            if (list.get(m) >= x)
            r = m;
            else 
            l = m + 1;
        }
        return l;
    }

    private int upperBound(List<Integer> list, int x) {
        int l = 0, r = list.size();
        while (l < r) 
        {
            int m = l+(r-l)/2;
            if (list.get(m) > x) 
            r = m;
            else 
            l = m + 1;
        }
        return l;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */