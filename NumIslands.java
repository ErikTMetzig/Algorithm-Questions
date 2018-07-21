class NumIslands {
    
    public int numIslands(char[][] grid) {
        
        //handle bad input
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        //use a holder array to mark islands as visited
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        
        int numIslands = 0;
        
        //iterate through grid, find if island is visited, increment and fill if not
        for(int i = 0; i < grid.length; i++)    {
            
            for(int j = 0; j < grid[0].length; j++)     {
                
                if(grid[i][j] == '1' && visited[i][j] == false)  {
                    
                    numIslands++;
                    visitIsland(grid, visited, i, j);
                }
            }
        }
        
        return numIslands;
    }
    
    //helper function that recursively fills an island as visited
    public void visitIsland(char[][] grid2, boolean passer[][], int yPos, int xPos) {
        
        //make visitd
        passer[yPos][xPos] = true;
        
        //try going left
        if(xPos > 0 && grid2[yPos][xPos - 1] == '1' && passer[yPos][xPos - 1] == false)
            visitIsland(grid2, passer, yPos, xPos - 1);
        
        //try going right
        if(xPos < passer[0].length - 1 && grid2[yPos][xPos + 1] == '1' && passer[yPos][xPos + 1] == false)
            visitIsland(grid2, passer, yPos, xPos + 1);
        
        //try going down
        if(yPos > 0 && grid2[yPos - 1][xPos] == '1' && passer[yPos - 1][xPos] == false)
            visitIsland(grid2, passer, yPos - 1, xPos);
        
        //try going up
        if(yPos < passer.length - 1 && grid2[yPos + 1][xPos] == '1' && passer[yPos + 1][xPos] == false)
            visitIsland(grid2, passer, yPos + 1, xPos);
        
        return;
    }
}