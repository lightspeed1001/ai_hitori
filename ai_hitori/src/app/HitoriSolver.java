package app;

/**
 * HitoriSolver
 * To solve some puzzle
 */
public class HitoriSolver {

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