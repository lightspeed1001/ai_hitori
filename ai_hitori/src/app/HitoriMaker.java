package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * HitoriMaker
 * To create a puzzle
 */
public class HitoriMaker {
	private int size;
	HitoriGame board;
	//list over all cells than can be or are black already
	private ArrayList<HitoriCell> allCells = new ArrayList<HitoriCell>();
	//list of cells that can be black but are not already
	private ArrayList<HitoriCell> white = new ArrayList<HitoriCell>();
	private Set<HitoriCell> blackSquares;
	private Random random = new Random();

    HitoriMaker(int size){
    	this.size = size;
    	HitoriCell[][] cells;
    	HitoriCell[] rows;
    	
    	cells = new HitoriCell[size][size];
    	for(int row = 0; row < size; row++) {
    		rows = new HitoriCell[size];
       		for(int col = 0; col < size; col++) {
       			rows[col] = (new HitoriCell(row,col,size+1));
       		}
       		cells[row] = rows;
       	}
    	
       board = new HitoriGame(size, cells);
	
   	for(int row = 0; row < size; row++) {
   		for(int col = 0; col < size; col++) {
   			allCells.add(cells[row][col]);
   		}
   	}
   	white = allCells;
   	
    }
    
    public HitoriGame generateBoard() {
    	HitoriSolver s;
    	HitoriGame game;
    	do {
    		generateBlackSquares();
    		do {
    			generateNumbers();
    			s = new HitoriSolver(board);
    			game = s.DFSSolve();
    		}while(game == null);
    	}while(!board.isValidMaker());
    	
    	return board;
    }
    
    private void generateBlackSquares() {
    	int loops = 0;

    	HitoriGame temp = new HitoriGame(board);
    	
    	blackSquares = new HashSet<HitoriCell>();
    	int index, index2;

	    do {
	    	//Shuffle to pick a random element
	    	Collections.shuffle(allCells);
	    	Collections.shuffle(white);
	    	
	    	HitoriCell x;
	    	HitoriCell y;
	    	do {
	    		index = random.nextInt(allCells.size());
		    	index2 = random.nextInt(white.size());
	    		x = allCells.get(index);
	    		y = white.get(index2);
	    	}while((x.getX() != y.getX() && x.getY() == y.getY() ) || (x.getX() == y.getX() && x.getY() != y.getY() ));

	        temp.markCellBlack(x.getX(), x.getY(), true);
	        if(temp.isValidMaker()) {
	        	blackSquares.add(x);
	        	allCells = removeWhites(allCells, x);
	        }
	        else {
	        	temp.markCellBlack(x.getX(), x.getY(), false);
	        }
	        temp.markCellBlack(y.getX(), y.getY(), true);
	        if(temp.isValidMaker()) {
		    	blackSquares.add(y);
		    	white.remove(y);
		    	white = removeWhites(white, y);
	        }
	        else {
	        	temp.markCellBlack(y.getX(), y.getY(), false);
	        }
	        board = temp;
	        loops++;
	        
	       //do this until white isn't connected anymore
	    }while(loops < 10000);
	    
	    System.out.println(blackSquares.size());
	    board.print();
    }
    //remove cells that must be white from the cell lists to make the random select more accurate
    private ArrayList<HitoriCell> removeWhites(ArrayList<HitoriCell> set, HitoriCell cell) {
    	int row = cell.getX();
    	int col = cell.getY();
    	if(col != 0) {
			set.remove(new HitoriCell(row, col-1, size+1));
		}
		if(col != size-1) {
			set.remove(new HitoriCell(row, col+1, size+1));
		}
		if(row != 0) {
			set.remove(new HitoriCell(row-1, col, size+1));
		}
		if(row != size-1) {
			set.remove(new HitoriCell(row+1, col, size+1));
		}
    	
    	return set;
    }
    private void generateNumbers() 
    {
    	HitoriGame temp = new HitoriGame(board);
    	do {
    		for(HitoriCell square: blackSquares) {
    		
    		}
    	}while(correctBlackNum(temp));
    	
    	//index = random.nextInt(allCell.size());
    	///generate numbers
    }
    private Boolean correctBlackNum(HitoriGame temp) {
    	HitoriCell[][] b = temp.getBoard();
    	ArrayList<Integer> num = new ArrayList<Integer>();
    	for(int i = 1; i <= size; i++) {
    		num.add(i);
    	}
    	
    	Collections.shuffle(num);
    	int index = random.nextInt(num.size());
    	int prevBlackNum = num.get(index);
    	for(int row = 0; row < size; row++) {
    		
       		for(int col = 0; col < size; col++) {
       			if(b[row][col].isBlack() && b[row][col].getNumber() == size+1) {
       				b[row][col].setNumber(prevBlackNum);
       			}
       		}
       	}
    	return true;
    }
}