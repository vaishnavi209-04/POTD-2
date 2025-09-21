//Approach 1-Design
//T.C-O(e log e + log m + log n)
class MovieRentingSystem {

    class Movie{

        int shop;
        int movie;
        int price;

        Movie(int shop, int movie, int price)
        {
            this.shop=shop;
            this.movie=movie;
            this.price=price;
        }
    }
    //unrented movies with cheaper price and if price is same them smaller shop
    Comparator<Movie> UNRENTED=(a,b)-> a.price!=b.price ? a.price-b.price : a.shop-b.shop;
    //rented movies with cheaper price and if price is same smaller shop if it is also same then smaller movie
    Comparator<Movie> RENTED=(a,b)-> a.price!=b.price? a.price-b.price : (a.shop!=b.shop? a.shop-b.shop : a.movie-b.movie);

    Map<Integer,TreeSet<Movie>> unrented;
    TreeSet<Movie> rented;
    Map<List<Integer>, Movie> lookup;

    public MovieRentingSystem(int n, int[][] entries)//O(e log e)
    {

        unrented= new HashMap<>();
        rented= new TreeSet<>(RENTED);
        lookup= new HashMap<>();


        for(int[] e : entries){
            int shop=e[0];
            int movie=e[1];
            int price=e[2];

            Movie m= new Movie(shop,movie,price);

            unrented.computeIfAbsent(movie,k->new TreeSet<>(UNRENTED));
            unrented.get(movie).add(m);
            lookup.put(Arrays.asList(shop,movie),m);
        }
        
    }
    
    public List<Integer> search(int movie)//O(1) 
    {

        List<Integer> ans= new ArrayList<>();
        if(!unrented.containsKey(movie)) 
        return ans;

        //we need to return top 5 copies
        TreeSet<Movie> set= unrented.get(movie);
        int count=0;

        for(Movie m: set)
        {
            ans.add(m.shop);
            count++;
            if(count==5) 
            break;
        }

        return ans;    
    }
    
    public void rent(int shop, int movie) //O(log m + log n)
    {

        Movie m= lookup.get(Arrays.asList(shop,movie));
        unrented.get(movie).remove(m);
  
        rented.add(m);

        
    }
    
    public void drop(int shop, int movie) //O(log m + log n)
    {
        
        Movie m= lookup.get(Arrays.asList(shop,movie));
        unrented.get(movie).add(m);

        rented.remove(m);
    }
    
    public List<List<Integer>> report() //O(1)
    {

        List<List<Integer>> ans= new ArrayList<>();
        int count=0;

        for(Movie m: rented)
        {
            ans.add(Arrays.asList(m.shop,m.movie));
            count++;
            if(count==5)
            break;
        }
        return ans;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */