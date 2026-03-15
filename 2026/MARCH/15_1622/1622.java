//Approach 1-Brute Force
class Fancy {
    List<Long> list;
    int mod=1_000_000_007;
    public Fancy() {
        list=new ArrayList<>();
    }
    
    public void append(int val) {
        list.add((long)val);
    }
    
    public void addAll(int inc) {
        for(int i = 0; i < list.size(); i++)
        {
            long val=(list.get(i) + inc ) % mod;
            list.set(i, val);
        }
          
    }
    
    public void multAll(int m) {
        for(int i = 0; i < list.size(); i++)
        {
            long val=(list.get(i) * m ) % mod;
            list.set(i, val);
        }
        
    }
    
    public int getIndex(int idx) {
        
        if(idx>=list.size())
        return -1;

        return (int)(list.get(idx) % mod);
    }
}

//Approach 2-Optimal -O(log mod)
class Fancy {

    List<Long> list;
    long add = 0;
    long mul = 1;
    int mod = 1_000_000_007;

    public Fancy() {//O(1)
        list = new ArrayList<>();
    }

    public void append(int val) {
        long x = (val - add + mod) % mod;//to avoid x becoming -ve add mod before doing % mod
        x = (x * power(mul,mod-2)) % mod;//(log mod) using fermats little theorem to (1/b) % mod
        list.add(x);
    }

    public void addAll(int inc) {//O(1)
        add = (add + inc) % mod;
    }

    public void multAll(int m) {//O(1)
        mul = (mul * m) % mod;
        add = (add * m) % mod;
    }

    public int getIndex(int idx) {//O(1)
        if(idx >= list.size())
            return -1;

        long val = list.get(idx);
        return (int)((val * mul + add) % mod);
    }

    private long power(long a, long b) {
        
        if(b == 0)
        return 1;

        long half=power(a,b/2);
        long res=(half * half) % mod;

        if (b % 2 == 1) {
            res = (res * a) % mod;
        }

        return res;
    }
}