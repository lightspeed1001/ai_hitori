package app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * HitoriGame
 * The state for a game of hitori
 */
public class HitoriGame {

    /* All it really needs is a NxN array of numbers ranging from 1..N and then some way to validate the solution
       No gameplay logic! That goes into HitoriPlayer */
    private HitoriCell[][] cells;
    private int size;
    private Map<HitoriCell, HitoriGame> successorStates;

    public HitoriGame(int size, HitoriCell[][] cells)
    {
        this.size = size;
        this.cells = cells;
        successorStates = new HashMap<HitoriCell,HitoriGame>();
    }
    public HitoriGame(HitoriGame other)
    {
    	this.size = other.size;
        this.cells = new HitoriCell[other.size][other.size];
        successorStates = new HashMap<HitoriCell,HitoriGame>();
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                this.cells[row][col] = new HitoriCell(other.cells[row][col]);
            }
        }
    }
    public void AddSuccessorState(HitoriCell point, HitoriGame successor)
    {
        successorStates.put(point, successor);
    }
    public Map<HitoriCell, HitoriGame> GetSuccessorStates()
    {
        return successorStates;
    }

    public HitoriCell[][] getBoard() {
    	return cells;
    }
    public void markCellBlack(int row, int col, boolean black)
    {
        cells[row][col].setBlack(black);
    }

    public void markCellMustBeWhite(int row, int col, boolean mustBeWhite)
    {
        cells[row][col].setWhite(mustBeWhite);
    }

    public void print()
    {
        for (HitoriCell[] rows : cells) {
            for (HitoriCell cell : rows) {
                if(cell.isBlack() && cell.mustBeWhite()) System.out.print("!" + cell.getNumber()+"!");
                else if(cell.isBlack())
                    System.out.print(" X ");
                // else if(cell.mustBeWhite())
                //     System.out.print("(" + cell.getNumber()+")");
                else
                    System.out.print(" " + cell.getNumber() + " ");
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
                if(!cell.isBlack())
                {    
                    numCounts[cell.getNumber() - 1] += 1;
                    if(numCounts[cell.getNumber() - 1] > 1) 
                    {
                        // System.out.println("Too many " + cell.getNumber() + "s in row");
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
                if(!cell.isBlack())
                {
                    numCounts[cell.getNumber() - 1] += 1;
                    if(numCounts[cell.getNumber() - 1] > 1) 
                    {
                        // System.out.println("Too many " + cell.getNumber() + "s in col");
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
                if(cell.isBlack() && wasPrevBlack) return false;
                else if (cell.isBlack()) wasPrevBlack = true;
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
                if(cell.isBlack() && wasPrevBlack) return false;
                else if (cell.isBlack()) wasPrevBlack = true;
                else wasPrevBlack = false;
            }
        }

        return true;
    }

    private Set<HitoriCell> getNonBlackSquares()
    {
        Set<HitoriCell> retSet = new HashSet<HitoriCell>();
        for (HitoriCell[] rows : cells) {
            for (HitoriCell cell : rows) {
                if(!cell.isBlack()) retSet.add(cell);
            }
        }
        return retSet;
    }

    private boolean isDuplicate(HitoriCell c)
    {
        for (HitoriCell[] row : cells) {
            for (HitoriCell other : row) {
                if(!other.isBlack() && c.getNumber() == other.getNumber() && (c.getX() == other.getX() ^ c.getY() == other.getY())) return true;
            }
            
        }

        return false;
    }

    public Set<HitoriCell> getPossibleBlackCells()
    {
        Set<HitoriCell> retSet = new HashSet<HitoriCell>();
        Set<HitoriCell> nonBlacks = getNonBlackSquares();
        for (HitoriCell cell : nonBlacks) {
            if(cell.mustBeWhite()) continue;
            if(isDuplicate(cell)) retSet.add(cell);
        }
        return retSet;
    }

    private Set<HitoriCell> getReachableCells(HitoriCell c)
    {
        Set<HitoriCell> reachables = new HashSet<HitoriCell>();
        if(c.beenVisited() || c.isBlack()) return reachables;
        c.setVisited(true);
        reachables.add(c);
        
        int x = c.getX(), y = c.getY();
        if(x != 0) reachables.addAll(getReachableCells(cells[x-1][y]));
        if(x != size - 1) reachables.addAll(getReachableCells(cells[x+1][y]));
        if(y != 0) reachables.addAll(getReachableCells(cells[x][y-1]));
        if(y != size - 1) reachables.addAll(getReachableCells(cells[x][y+1]));

        // reachables.addAll(getReachableCells(c));
        return reachables;
    }

    private void resetVisitedCells()
    {
        for (HitoriCell[] rows : cells) {
            for (HitoriCell cell : rows) {
                cell.setVisited(false);
            }
        }
    }

    private Boolean checkValidConnections()
    {
        Set<HitoriCell> nonBlacks = getNonBlackSquares();
        Set<HitoriCell> reachables = getReachableCells(nonBlacks.iterator().next());
        resetVisitedCells();
        return nonBlacks.equals(reachables);
    }

    public String str()
    {
        String derp = "";
        for (HitoriCell[] rows : cells) {
            for (HitoriCell cell : rows) {
                if(cell.isBlack() && cell.mustBeWhite()) derp += ("!" + cell.getNumber());
                else if(cell.isBlack())
                    derp += ("X");
                else if(cell.mustBeWhite())
                    derp += ("(" + cell.getNumber());
                else
                    derp +=(cell.getNumber());
            }
        }
        return derp;
    }
    public Boolean isValidMaker() {
    	 if(!checkBlackSquares()) 
         {
             // System.out.println(("Adjacent black squares"));
             return false;
         }
         if(!checkValidConnections()) 
         {
             // System.out.println("Unreachable white squares");
             return false;
         }
         return true;
    }

    public Boolean isValidSolution()
    {
        //This can be consolidated into one line, but we have it like this for debugging purposes
        if(checkRows() && checkCols())
        {
            // System.out.println("Rows and cols ok");
            if(!checkBlackSquares()) 
            {
                // System.out.println(("Adjacent black squares"));
                return false;
            }
            if(!checkValidConnections()) 
            {
                // System.out.println("Unreachable white squares");
                return false;
            }
        }
        else
        {
            // System.out.println("Duplicate numbers");
            return false;
        }
        return true;
    }
}