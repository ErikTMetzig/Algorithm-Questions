class ZeroMatrix {
    
    public void setZeroes(int[][] matrix) {
        
        //handle bad input
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        
        //perform the check for the first row and column of matrix, use those rows for vals
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        
        //find if there's a zero in first row
        for(int i = 0; i < matrix[0].length; i++)  {
            
            if(matrix[0][i] == 0)   {
                
                firstRowHasZero = true;
                break;
            }
        }
        
        //find if there's a zero in first col
        for(int j = 0; j < matrix.length; j++)  {
            
            if(matrix[j][0] == 0)   {
                
                firstColHasZero = true;
                break;
            }
        }
       
        //iterate through matrix, set tag of row and col to 0
        for(int k = 1; k < matrix.length; k++)   {
           
           for(int m = 1; m < matrix[0].length; m++)    {
               
               if(matrix[k][m] == 0)    {
                   
                   matrix[k][0] = 0;
                   matrix[0][m] = 0;
               }
           }
       }
        
        //set each zeroed row to 0
        for(int h = 1; h < matrix.length; h++)  {
            
            if(matrix[h][0] == 0)
                for(int w = 1; w < matrix[0].length; w++)
                    matrix[h][w] = 0;
        }
        
        //set each zeroed col = 0
        for(int e = 1; e < matrix[0].length; e++)  {
            
            if(matrix[0][e] == 0)
                for(int y = 1; y < matrix.length; y++)
                    matrix[y][e] = 0;
        }
        
        //handle first row
        if(firstRowHasZero)
            for(int x = 0; x < matrix[0].length; x++)
                matrix[0][x] = 0;
        
        //handle first col
        if(firstColHasZero)
            for(int q = 0; q < matrix.length; q++)
                matrix[q][0] = 0;
    
        return;
    }
}