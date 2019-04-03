package app;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * HitoriSolver
 * To solve some puzzle
 */
public class HitoriSolver {
	
	private HitoriGame original;
	private HitoriCell[][] cells;
    private int size;
    //private HitoriGame board;
	
	HitoriSolver(HitoriGame board){
		original = board;
		cells = board.getBoard();
		size = cells.length;
		//board = new HitoriGame(this.board);
		
		// checkCorners(board);
		// solveThreeInRow(board);
		// original = BFSSolve();
		
	}
	//must first check corners for three of same
	private void checkCorners(HitoriGame board) 
	{
		if(cells[0][0].getNumber() == cells [0][1].getNumber() && cells[0][0].getNumber() == cells [1][0].getNumber()) {
			board.markCellBlack(0, 0, true);
			board.markCellMustBeWhite(0, 1, true);
			board.markCellMustBeWhite(1, 0, true);
		}
		if(cells[size-1][0].getNumber() == cells [size-1][1].getNumber() && cells[size-2][0].getNumber() == cells [size-1][0].getNumber()) {
			board.markCellBlack(size-1, 0, true);
			board.markCellMustBeWhite(0, size-2, true);
			board.markCellMustBeWhite(size-2, 0, true);
		}
		if(cells[size-1][size-1].getNumber() == cells [size-1][size-2].getNumber() && cells[size-1][size-1].getNumber() == cells [size-2][size-1].getNumber()) {
			board.markCellBlack(size-1, size-1, true);
			board.markCellMustBeWhite(size-1, size-2, true);
			board.markCellMustBeWhite(size-2, size-1, true);
		}
		if(cells[0][size-1].getNumber() == cells [1][size-1].getNumber() && cells[0][size-1].getNumber() == cells [0][size-2].getNumber()) {
			board.markCellBlack(0, size-1, true);
			board.markCellMustBeWhite(0, size-2, true);
			board.markCellMustBeWhite(1, size-1, true);
		}
	}
	private void solveThreeInRow(HitoriGame board)
	{
		int number;
		//check horizontally for three in a row
		for (int row = 0; row < size; row++) {
            for (int col = 0; col < size-2; col++)
            {
            	number = cells[row][col].getNumber();
  
                if (number == cells[row][col+1].getNumber())
                {
                	if(number == cells[row][col+2].getNumber()) 
                	{
                		board.markCellBlack(row, col, true);
                		board.markCellBlack(row, col+2, true);
                		board.markCellMustBeWhite(row, col+1, true);
                		if(col != 0) {
                			board.markCellMustBeWhite(row, col-1, true);
                		}
                		if(col+2 != size-1) {
                			board.markCellMustBeWhite(row, col+3, true);
                		}
                		if(row != 0) {
                			board.markCellMustBeWhite(row-1, col, true);
	                		if(col+2 != size-1) {
	                			board.markCellMustBeWhite(row-1, col+2, true);
	                		}
                		}
                		if(row != size-1) {
                			board.markCellMustBeWhite(row+1, col, true);
	                		if(col+2 != size-1) {
	                			board.markCellMustBeWhite(row+1, col+2, true);
	                		}
                		}
                		col =+ 2;
                	}
                }
            }
        }
		//check vertically
		for (int col = 0; col < size; col++) {
            for (int row = 0; row < size-2; row++)
            {
            	number = cells[row][col].getNumber();
  
                if (number == cells[row+1][col].getNumber())
                {
                	if(number == cells[row+2][col].getNumber()) 
                	{
                		board.markCellBlack(row, col, true);
                		board.markCellBlack(row+2, col, true);
                		if(row != size-1) {
                			board.markCellMustBeWhite(row+1, col, true);
                		}
                		if(row != 0) {
                			board.markCellMustBeWhite(row-1, col, true);
                		}
                		if(row+2 != size-1) {
                			board.markCellMustBeWhite(row+3, col, true);
                		}
                		if(col != 0) {
                			board.markCellMustBeWhite(row, col-1, true);
	                		if(row+2 != size-1) {
	                			board.markCellMustBeWhite(row+2, col-1, true);
	                		}
                		}
                		if(col != size-2) {
                			board.markCellMustBeWhite(row, col+2, true);
	                		if(row+2 != size-1) {
	                			board.markCellMustBeWhite(row+2, col+1, true);
	                		}
                		}
                		row =+ 2;
                	}
                }
            }
        }
		
	}
		
	public HitoriCell[][] getBoard() {
		return cells;
    }
    
    private void UpdateMap(HitoriGame state, HitoriCell point) {
    	int row = point.getX();
    	int col = point.getY();
    	state.markCellBlack(row, col, true);
    	if(row != size-1) {
			state.markCellMustBeWhite(row+1, col, true);
		}
		if(row != 0) {
			state.markCellMustBeWhite(row-1, col, true);
		}
		if(col != 0) {
			state.markCellMustBeWhite(row, col-1, true);
		}
		if(col != size-1) {
			state.markCellMustBeWhite(row, col+1, true);
		}
    	
    }
    
    private boolean FillSuccessors(HitoriGame node)
    {
        Set<HitoriCell> legalMoves = node.getPossibleBlackCells();
        for (HitoriCell cell : legalMoves) 
        {
            //Grab a copy of the state we're going to expand
            HitoriGame state = new HitoriGame(node);
            //Execute a legal move on the state
            UpdateMap(state, cell);
            //Add it as a successor to the state we were given
            node.AddSuccessorState(cell, state);
        }
        return false;
    }
    
    public HitoriGame BFSSolve()
    {
        //Statistics
        int maxFrontier = 0, expandedStates = 0;

        
        //For BFS, our frontier is a queue
        Queue<HitoriGame> frontier = new LinkedList<HitoriGame>();
        //Keep track of states, so we don't run into infinite loops
        Set<String> seenStates = new HashSet<String>();
        
        //Don't want to mess with the original. That's just rude.
        HitoriGame node = new HitoriGame(original);
        //Check corners and three in a row first, since those are rather simple.
        checkCorners(node);
        solveThreeInRow(node);
        frontier.add(node);
        while(frontier.size() != 0)
        {
            //If the frontier is empty, we have failed to find a solution
            if (frontier.isEmpty()) break;
            //Grab the next node
            node = frontier.remove();
            FillSuccessors(node);
            
            //if making the point black causes something illegal go back one state
            
            if (node.isValidSolution())
            {
                System.out.println("Max frontier: " + maxFrontier);
                System.out.println("Expanded states: " + expandedStates);
                return node;
            }
            //Check for repeated states so that the frontier doesn't grow insanely big
            String stateString = node.str();
            if(!seenStates.contains(stateString))
            {
                seenStates.add(stateString);
                frontier.addAll(node.GetSuccessorStates().values());
            }
            //Statistics
            expandedStates++;
            if(frontier.size() > maxFrontier) 
            {
                maxFrontier = frontier.size();
            }
        }
        System.out.println("No solution found. :(");
        System.out.println("Max frontier: " + maxFrontier);
        System.out.println("Expanded states: " + expandedStates);
        return null;
    }

	public HitoriGame DFSSolve()
	{
        int maxFrontier = 0, expandedStates = 0;
        
        //For DFS, our frontier is a stack
        Stack<HitoriGame> frontier = new Stack<HitoriGame>();
        //Keep track of states, so we don't run into infinite loops
        Set<String> seenStates = new HashSet<String>();
        
        //Don't want to mess with the original. That's just rude.
        HitoriGame node = new HitoriGame(original);
        //Check corners and three in a row first, since those are rather simple.
        checkCorners(node);
        solveThreeInRow(node);
        frontier.add(node);
        while(frontier.size() != 0)
        {
            //If the frontier is empty, we have failed to find a solution
            if (frontier.isEmpty()) break;
            //Grab the next node
            node = frontier.pop();
            FillSuccessors(node);
            
            //if making the point black causes something illegal go back one state
            
            if (node.isValidSolution())
            {
                System.out.println("Max frontier: " + maxFrontier);
                System.out.println("Expanded states: " + expandedStates);
                return node;
            }
            //Check for repeated states so that the frontier doesn't grow insanely big
            String stateString = node.str();
            if(!seenStates.contains(stateString))
            {
                seenStates.add(stateString);
                frontier.addAll(node.GetSuccessorStates().values());
            }
            //Statistics
            expandedStates++;
            if(frontier.size() > maxFrontier) 
            {
                maxFrontier = frontier.size();
            }
        }
        System.out.println("No solution found. :(");
        System.out.println("Max frontier: " + maxFrontier);
        System.out.println("Expanded states: " + expandedStates);
        return null;
    }

	public HitoriGame ret()
	{
		return original;
	}
    /* For the love of god don't make the same mistake as in prog1 where it was all one giant class.
       One for the state (HitoriGame), one for the tree, one for the logic (This one), more if needed 
       Some thoughts:
       First, mark any cells that should never become black (only one number in that row/col) as "mustBeWhite"
       Then, go through the remaining cells and mark one as black. When marking a cell as black, make sure to update the neighbouring cells as "mustBeWhite"
       Repeat until a solution has been found, or that there are no more possible cells remaining, in which case we go back a step and mark a different cell as black.
       
       Make DFS and BFS solutions to have something to compare.
       Any other algorithms we could check?
       */
}