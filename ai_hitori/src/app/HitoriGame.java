package app;

import java.util.Arrays;

/**
 * HitoriGame
 * The state for a game of hitori
 */
public class HitoriGame {

    /* All it really needs is a NxN array of numbers ranging from 1..N and then some way to validate the solution
       No gameplay logic! That goes into HitoriPlayer */
    private HitoriCell[][] cells;
    private int size;

    public HitoriGame(int size, HitoriCell[][] cells)
    {
        this.size = size;
        this.cells = cells;
    }

    public void markCellBlack(int row, int col, boolean black)
    {
        cells[row][col].black = black;
    }

    public void markCellMustBeWhite(int row, int col, boolean mustBeWhite)
    {
        cells[row][col].mustBeWhite = mustBeWhite;
    }

    public void print()
    {
        for (HitoriCell[] rows : cells) {
            for (HitoriCell cell : rows) {
                if(cell.black)
                    System.out.print("X ");
                else
                    System.out.print(cell.number + " ");
            }
            System.out.println("");
        }
    }

    private Boolean checkRows()
    {
        int[] numCounts = new int[size];
        for (HitoriCell[] rows : cells) {
            Arrays.fill(numCounts, 0);
            for (HitoriCell cell : rows) {
                if(!cell.black)
                {    
                    numCounts[cell.number - 1] += 1;
                    if(numCounts[cell.number - 1] > 1) 
                    {
                        System.out.println("Too many " + cell.number + "s in row");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private Boolean checkCols()
    {
        int[] numCounts = new int[size];
        for(int col = 0; col < size; col++)
        {
            Arrays.fill(numCounts, 0);
            for(int row = 0; row < size; row++)
            {
                HitoriCell cell = cells[row][col];
                if(!cell.black)
                {
                    numCounts[cell.number - 1] += 1;
                    if(numCounts[cell.number - 1] > 1) 
                    {
                        System.out.println("Too many " + cell.number + "s in col");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private Boolean checkBlackSquares()
    {
        boolean wasPrevBlack = false;
        //Rows
        for (HitoriCell[] rows : cells) {
            wasPrevBlack = false;
            for (HitoriCell cell : rows) {
                if(cell.black && wasPrevBlack) return false;
                else if (cell.black) wasPrevBlack = true;
                else wasPrevBlack = false;
            }
        }
        //Cols
        for(int col = 0; col < size; col++)
        {
            wasPrevBlack = false;
            for(int row = 0; row < size; row++)
            {
                HitoriCell cell = cells[row][col];
                if(cell.black && wasPrevBlack) return false;
                else if (cell.black) wasPrevBlack = true;
                else wasPrevBlack = false;
            }
        }

        return true;
    }

    private Boolean checkValidConnections()
    {
    	Boolean check = true;
    	 //Rows
        for (int row = 0; row < size; row++) {
        	for(int col = 0; col < size; col++)
            {
                if(!checkSide(row, col)) {
                	return false;
                }
            }
           
        }
        //Cols
        
        //Check if all white spaces are connected to all other white spaces
        return true;
    }
    private Boolean checkSide(int row, int col) 
    {
    	if(row != 0 ) {
    		if(!cells[row-1][col].black) {
    			return true;
    		}
    	}
    	if(row != size-1) {
    		if(!cells[row+1][col].black) {
    			return true;
    		}
    	}
    	if(col != 0) {
    		if(!cells[row][col-1].black) {
    			return true;
    		}
    	}
    	if(col != size-1) {
    		if(!cells[row][col+1].black) {
    			return true;
    		}
    	}
    	return false;
    }

    public Boolean isValidSolution()
    {
        if(checkRows() && checkCols())
        {
            if(!checkBlackSquares()) return false;
            if(!checkValidConnections()) return false;
        }
        else
        {
            return false;
        }
        return true;
    }
}