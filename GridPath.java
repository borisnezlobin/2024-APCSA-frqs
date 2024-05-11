public class GridPath {
    /** Initialized in the constructor with distinct values that never change */
    private int[][] grid;


    // constructor written by me
    public GridPath(int[][] g){
        grid = g;
    }

    /**
    * Returns the Location representing a neighbor of the grid element at row and col,
    * as described in part (a)
    * Preconditions: row is a valid row index and col is a valid column index in grid.
    * row and col do not specify the element in the last row and last column of grid.
    */
    public Location getNextLoc(int row, int col)
    {
        // I don't remember what I wrote in this condition exactly, so this is a guess
        if(row == grid.length - 1){
            return new Location(row, col + 1);
        }
        if(col == grid[row].length - 1){
            return new Location(row + 1, col);
        }

        int bottom = grid[row + 1][col];
        int right = grid[row][col + 1];

        if(bottom < right) return new Location(row + 1, col);
        else return new Location(row, col + 1);
    }

    
    /**
    * Computes and returns the sum of all values on a path through grid, as described in
    * part (b)
    * Preconditions: row is a valid row index and col is a valid column index in grid.
    * row and col do not specify the element in the last row and last column of grid.
    */
    public int sumPath(int row, int col)
    {
        int sum = grid[row][col];
        Location next = new Location(row, col);

        while(next.getRow() != grid.length - 1 || next.getCol() != grid[0].length - 1){
            next = getNextLoc(next.getRow(), next.getCol());
            sum += grid[next.getRow()][next.getCol()];
        }

        return sum;
    }
    // There may be instance variables, constructors, and methods that are not shown

    public static void main(String[] args){
        int[][] grid = new int[][]{
            { 12, 3, 4, 13, 5 },
            { 11, 21, 2, 14, 16 },
            { 7, 8, 9, 15, 0 },
            { 10, 17, 20, 19, 1 },
            { 18, 22, 30, 25, 6 }
        };

        GridPath gp = new GridPath(grid);
        System.out.println(gp.getNextLoc(0, 0)); // "(0, 1)"
        System.out.println(gp.getNextLoc(1, 3)); // "(2, 3)"
        System.out.println(gp.getNextLoc(2, 4)); // "(3, 4)"
        System.out.println(gp.getNextLoc(4, 3)); // "(4, 4)"


        int[][] grid2 = new int[][] {
            { 12, 30, 40, 25, 5 },
            { 11, 3, 22, 15, 43 },
            { 7, 2, 9, 4, 0 },
            { 8, 33, 18, 6, 1 }
        };
        GridPath gp2 = new GridPath(grid2);
        System.out.println(gp2.sumPath(1, 1)); // 19
    }
}

// not written by me
class Location {
    private int theRow;
    private int theCol;

    public Location(int r, int c)
    {
        theRow = r;
        theCol = c;
    }

    public int getRow(){ return theRow; }
    public int getCol(){ return theCol; }

    public String toString(){ return "(" + theRow + ", " + theCol + ")"; }
}