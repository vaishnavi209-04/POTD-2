//Approach 1-O(n)
class Spreadsheet {
    int[][] arr;
    public Spreadsheet(int rows) {
        arr=new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int col=cell.charAt(0)-'A';
        int row=Integer.parseInt(cell.substring(1))-1;
        arr[row][col]=value;
    }
    
    public void resetCell(String cell) {
        int col=cell.charAt(0)-'A';
        int row=Integer.parseInt(cell.substring(1))-1;
        arr[row][col]=0;
    }
    
    public int getValue(String formula) {
       formula=formula.substring(1);
       String[] parts=formula.split("\\+");
       int sum=0;
       for(String part:parts)
       {
        if(part.isEmpty())
        continue;
        if(Character.isDigit(part.charAt(0)))
        {
            sum+=Integer.parseInt(part);
        }
        else
        {
        int col=part.charAt(0)-'A';
        int row=Integer.parseInt(part.substring(1))-1;
        sum+=arr[row][col];
        }
       }
       return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */