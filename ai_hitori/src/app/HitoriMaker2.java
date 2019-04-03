package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * HitoriMaker
 * To create a puzzle
 */
public class HitoriMaker2 {
	private int size;
	HitoriGame board;
	//list of cells that can be black but are not already
	private ArrayList<HitoriCell> white = new ArrayList<HitoriCell>();
	private Set<HitoriCell> blackSquares;
	private Random random = new Random();
	ArrayList<Integer> num = new ArrayList<Integer>();
	Set<Integer> nums = new HashSet<Integer>();

    HitoriMaker2(int size){
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
	   			white.add(cells[row][col]);
	   		}
	   	}
		for(int i = 1; i <= size; i++) {
			num.add(i);
		}
   	
    }
    
    public HitoriGame generateBoard() {
    	HitoriSolver s;
    	HitoriGame game;
    	//do {
    		generateBlackSquares();
    		//do {
    			generateNumbers();
    			s = new HitoriSolver(board);
    			game = s.DFSSolve();
    		//}while(game == null);
    	//}while(!board.isValidMaker());
    	
    	return board;
    }
    
    private void generateBlackSquares() {
    	int loops = 0;

    	HitoriGame temp = new HitoriGame(board);
    	
    	blackSquares = new HashSet<HitoriCell>();
    	int index;

	    do {
	    	//Shuffle to pick a random element
	    	Collections.shuffle(white);

	    	index = random.nextInt(white.size());
	    	HitoriCell x = white.get(index);

	        temp.markCellBlack(x.getX(), x.getY(), true);
	        if(temp.isValidMaker()) {
	        	blackSquares.add(x);
	        	white = removeWhites(white, x);
	        }
	        else {
	        	temp.markCellBlack(x.getX(), x.getY(), false);
	        }
	        
	        board = temp;
	        loops++;
	        
	       //do this until white isn't connected anymore
	    }while(loops < 10000);
	    
//	    System.out.println(blackSquares.size());
//	    board.print();
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
    	//do {
    	
    		//addBlackNum();
    		addNums();
    		//correctBlackNum(temp);
    	//}while(correctBlackNum(temp));
    	
    	//index = random.nextInt(allCell.size());
    	///generate numbers
    }
    private void addNums() 
    {
    	ArrayList<Integer> num = new ArrayList<Integer>();
    	for(int i = 1; i <= size; i++) {
    		num.add(i);
    	}
    	
    	ArrayList<Integer> list = num;
    	
    	
    	HitoriGame temp = new HitoriGame(board);
    	HitoriCell[][] b = temp.getBoard();
    	for(int row = 0; row < size; row++) {
    		Collections.shuffle(list);
	   		for(int col = 0; col < size; col++) {
	   			if(!b[row][col].isBlack()) {
	   				b[row][col].setNumber(list.get(col));
	   			}
	   		}
	   	}
    	board = temp;
    	board.print();
    	System.out.println("======================");
    	do {
    	for(HitoriCell s : blackSquares) {
    		findDuplicatesRow(s, s.getX(), s.getY());
    		findDuplicatesCol(s, s.getX(), s.getY());
    		//newNumber();  //this function is not ready yet getting errors
    	}
    	board.print();
    	System.out.println("======================");
    	}while(!board.isValidSolution());
    
    }
    private void findDuplicatesRow(HitoriCell b, int row, int c) 
    {
    	HitoriGame temp = new HitoriGame(board);
    	HitoriCell[][] bo = temp.getBoard();
    	ArrayList<Integer> tempNums = num;
        int[] numCounts = new int[size];
        Arrays.fill(numCounts, 0);
        for(int col = 0; col < size; col++) {
            if(!bo[row][col].isBlack())
            {    
                numCounts[bo[row][col].getNumber() - 1] += 1;
                if(numCounts[bo[row][col].getNumber() - 1] > 1) 
                {
                    int t = bo[row][col].getNumber();
                    bo[row][c].setNumber(t);

                    bo[row][col].setNumber(size+1);
                }
            }
        }
    	board = temp;
    }
    private void findDuplicatesCol(HitoriCell b, int row, int c) 
    {
    	HitoriGame temp = new HitoriGame(board);
    	HitoriCell[][] bo = temp.getBoard();
        int[] numCounts = new int[size];
        Arrays.fill(numCounts, 0);
	    for(int r = 0; r < size; r++) {
	        if(!bo[r][c].isBlack())
	        {    
	            numCounts[bo[r][c].getNumber() - 1] += 1;
	            if(numCounts[bo[r][c].getNumber() - 1] > 1) 
	            {
	                int t = bo[r][c].getNumber();
	                bo[row][c].setNumber(t);
	                
	                bo[r][c].setNumber(size+1);
	            }
	        }
	    }
    	board = temp;
    }
    private void newNumber() 
    {
    	HitoriGame temp = new HitoriGame(board);
    	HitoriCell[][] b = temp.getBoard();
    	Set<Integer> tempNums = nums;
    	for(int row = 0; row < size; row++) {
       		for(int col = 0; col < size; col++) {
       			if(b[row][col].getNumber() == size+1) {
       				tempNums = nums;
       				
                for(int i = 0; i < size; i++) {
                	if(!b[row][i].isBlack()) {
                		System.out.println(b[row][i].getNumber());
                		tempNums.remove(b[row][i].getNumber());
                		}
                	}
                }
       			//Iterator<Integer> i = tempNums.iterator();
	            b[row][col].setNumber(tempNums.iterator().next());      				
       			
       		}

       	}
    }

}