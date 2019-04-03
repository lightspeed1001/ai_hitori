package app;

import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

//        for (int i = 0; i < HitoriTests.NUMBER_OF_TESTS; i++) 
//        {
//            Set<HitoriCell[][]> tests = HitoriTests.getTestCase(i);
//            System.out.println("Test case " + i);
//            for (HitoriCell[][] test : tests) {
//                System.out.println("------");
//                HitoriGame g = new HitoriGame(test.length, test);
//                System.out.println("Solved? " + g.isValidSolution());
//                g.print();
//            }
//            System.out.println("================================");
//        }
//        
//        Set<HitoriCell[][]> tests = HitoriTests.getTestCase(99);
//        System.out.println("Testing getPossibleBlackSquares ");
//        for (HitoriCell[][] test : tests) {
//            System.out.println("------");
//            HitoriGame g = new HitoriGame(test.length, test);
//            System.out.println("Solved? " + g.isValidSolution());
//            g.print();
//            Set<HitoriCell> possibleBlacks = g.getPossibleBlackCells();
//            
//            System.out.println("===Possible black cells===");
//            for (HitoriCell cell : possibleBlacks) {
//                System.out.println("value: " + cell.getNumber() + "; (" + cell.getX() + ", " + cell.getY() + ");");
//            }
//        }
//        System.out.println("================================");
//
//        HitoriCell[][] test = HitoriTests.getUnsolvedPuzzle(0);
//        HitoriGame g = new HitoriGame(test.length, test);
//        g.print();
//        HitoriSolver s = new HitoriSolver(g);
//        System.out.println("BFS Solution");
//        s.BFSSolve().print();
//        System.out.println("DFS Solution");
//        s.DFSSolve().print();
//        System.out.println("Human solution");
//        HitoriGame gg = new HitoriGame(5, HitoriTests.getSolvedPuzzle(0));
//        gg.print();
    	
    	HitoriMaker m = new HitoriMaker(7);
    	m.generateBoard();
    	
    	
        /*
        Have some sort of main menu?

        Pseudocode:
        choice = ShowMainMenu
        if choice = play <shouldn't be too hard?>
            start hitoriplayer
                play a game of hitori

        if choice = solve <MAIN FOCUS>
            start hitorisolver
                solve a puzzle

        if choice = create <once solver is done>
            start hitorimaker
                create a puzzle
        */
    }
}