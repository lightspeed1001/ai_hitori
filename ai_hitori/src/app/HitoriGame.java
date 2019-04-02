package app;

import java.util.Arrays;
import java.util.HashSet;
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

    public HitoriGame(int size, HitoriCell[][] cells)
    {
        this.size = size;
        this.cells = cells;
    }

    public HitoriGame(HitoriGame other)
    {
        this.size = other.size;
        this.cells = new HitoriCell[size][size];
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                this.cells[row][col] = other.cells[row][col];
            }
        }
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
                if(cell.isBlack())
                    System.out.print("X ");
                else
                    System.out.print(cell.getNumber() + " ");
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

    public Boolean isValidSolution()
    {
        //This can be consolidated into one line, but we have it like this for debugging purposes
        if(checkRows() && checkCols())
        {
            System.out.println("Rows and cols ok");
            if(!checkBlackSquares()) 
            {
                System.out.println(("Adjacent black squares"));
                return false;
            }
            if(!checkValidConnections()) 
            {
                System.out.println("Unreachable white squares");
                return false;
            }
        }
        else
        {
            System.out.println("Duplicate numbers");
            return false;
        }
        return true;
    }
}