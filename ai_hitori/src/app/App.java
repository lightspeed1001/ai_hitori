package app;

import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        //Testing the state class
        for (int i = 0; i < HitoriTests.NUMBER_OF_TESTS; i++) 
        {
            Set<HitoriCell[][]> tests = HitoriTests.getTestCase(i);
            System.out.println("Test case " + i);
            for (HitoriCell[][] test : tests) {
                System.out.println("------");
                HitoriGame g = new HitoriGame(test.length, test);
                System.out.println("Solved? " + g.isValidSolution());
                g.print();
            }
            System.out.println("================================");
        }
        //Testing the solver
        System.out.println("Testing solver");
        Set<HitoriCell[][]> tests = HitoriTests.getSmallUnsolvedPuzzles();
        for (HitoriCell[][] test : tests) {
            System.out.println("------");
            System.out.println("---Original---");
            HitoriGame g = new HitoriGame(test.length, test);
            System.out.println("Solved? " + g.isValidSolution());
            g.print();
            long start = System.currentTimeMillis();
            HitoriSolver solve = new HitoriSolver(g);
            System.out.println("---BFS Solve---");
            HitoriGame solution = solve.BFSSolve();
            if(solution != null) solution.print();
            long end = System.currentTimeMillis();
            System.out.println("Time to find solution: " + (end - start) + "ms");
            System.out.println("---DFS Solve---");
            start = System.currentTimeMillis();
            solution = solve.DFSSolve();
            if(solution != null) solution.print();
            end = System.currentTimeMillis();
            System.out.println("Time to find solution: " + (end - start) + "ms");
        }
        System.out.println("================================");
        
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