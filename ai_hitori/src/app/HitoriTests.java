package app;

import java.util.HashSet;
import java.util.Set;

/**
 * HitoriTests
 */
public class HitoriTests 
{
    public static final int NUMBER_OF_TESTS = 3;

    public static HitoriCell[][] getUnsolvedPuzzle(int i)
    {
        //http://hitoriconquest.com/?puzzle_id=
        switch (i) {
            case 0: //#????
                HitoriCell[][] original1 = new HitoriCell[][] {
                    {new HitoriCell(0,0,1),   new HitoriCell(0,1,4), new HitoriCell(0,2,2), new HitoriCell(0,3,4), new HitoriCell(0,4,3)},
                    {new HitoriCell(1,0,1),   new HitoriCell(1,1,1), new HitoriCell(1,2,3), new HitoriCell(1,3,4), new HitoriCell(1,4,5)},
                    {new HitoriCell(2,0,3),   new HitoriCell(2,1,4), new HitoriCell(2,2,4), new HitoriCell(2,3,5), new HitoriCell(2,4,5)},
                    {new HitoriCell(3,0,4),   new HitoriCell(3,1,5), new HitoriCell(3,2,1), new HitoriCell(3,3,3), new HitoriCell(3,4,2)},
                    {new HitoriCell(4,0,1),   new HitoriCell(4,1,3), new HitoriCell(4,2,3), new HitoriCell(4,3,1), new HitoriCell(4,4,2)}};
                return original1;
            case 1: //#15747
                HitoriCell[][] original2 = new HitoriCell[][] {
                    {new HitoriCell(0,0,6), new HitoriCell(0,1,6), new HitoriCell(0,2,8), new HitoriCell(0,3,1), new HitoriCell(0,4,7), new HitoriCell(0,5,5), new HitoriCell(0,6,5), new HitoriCell(0,7,2)},
                    {new HitoriCell(1,0,7), new HitoriCell(1,1,6), new HitoriCell(1,2,1), new HitoriCell(1,3,7), new HitoriCell(1,4,6), new HitoriCell(1,5,1), new HitoriCell(1,6,4), new HitoriCell(1,7,5)},
                    {new HitoriCell(2,0,8), new HitoriCell(2,1,1), new HitoriCell(2,2,5), new HitoriCell(2,3,7), new HitoriCell(2,4,5), new HitoriCell(2,5,6), new HitoriCell(2,6,8), new HitoriCell(2,7,3)},
                    {new HitoriCell(3,0,3), new HitoriCell(3,1,5), new HitoriCell(3,2,7), new HitoriCell(3,3,1), new HitoriCell(3,4,3), new HitoriCell(3,5,8), new HitoriCell(3,6,6), new HitoriCell(3,7,4)},
                    {new HitoriCell(4,0,5), new HitoriCell(4,1,7), new HitoriCell(4,2,8), new HitoriCell(4,3,8), new HitoriCell(4,4,4), new HitoriCell(4,5,6), new HitoriCell(4,6,2), new HitoriCell(4,7,2)},
                    {new HitoriCell(5,0,5), new HitoriCell(5,1,4), new HitoriCell(5,2,6), new HitoriCell(5,3,3), new HitoriCell(5,4,7), new HitoriCell(5,5,1), new HitoriCell(5,6,1), new HitoriCell(5,7,7)},
                    {new HitoriCell(6,0,6), new HitoriCell(6,1,7), new HitoriCell(6,2,2), new HitoriCell(6,3,8), new HitoriCell(6,4,5), new HitoriCell(6,5,3), new HitoriCell(6,6,7), new HitoriCell(6,7,1)},
                    {new HitoriCell(7,0,2), new HitoriCell(7,1,3), new HitoriCell(7,2,4), new HitoriCell(7,3,5), new HitoriCell(7,4,1), new HitoriCell(7,5,3), new HitoriCell(7,6,8), new HitoriCell(7,7,2)}};
                return original2;
            case 2: //#15396
                HitoriCell[][] original3 = new HitoriCell[][] {
                    {new HitoriCell(0,0,1), new HitoriCell(0,1,1), new HitoriCell(0,2,8), new HitoriCell(0,3,8), new HitoriCell(0,4,6), new HitoriCell(0,5,7), new HitoriCell(0,6,4), new HitoriCell(0,7,8)},
                    {new HitoriCell(1,0,6), new HitoriCell(1,1,1), new HitoriCell(1,2,7), new HitoriCell(1,3,8), new HitoriCell(1,4,3), new HitoriCell(1,5,2), new HitoriCell(1,6,1), new HitoriCell(1,7,4)},
                    {new HitoriCell(2,0,1), new HitoriCell(2,1,4), new HitoriCell(2,2,3), new HitoriCell(2,3,3), new HitoriCell(2,4,2), new HitoriCell(2,5,4), new HitoriCell(2,6,6), new HitoriCell(2,7,1)},
                    {new HitoriCell(3,0,7), new HitoriCell(3,1,7), new HitoriCell(3,2,7), new HitoriCell(3,3,1), new HitoriCell(3,4,5), new HitoriCell(3,5,6), new HitoriCell(3,6,3), new HitoriCell(3,7,8)},
                    {new HitoriCell(4,0,8), new HitoriCell(4,1,2), new HitoriCell(4,2,6), new HitoriCell(4,3,5), new HitoriCell(4,4,2), new HitoriCell(4,5,7), new HitoriCell(4,6,2), new HitoriCell(4,7,1)},
                    {new HitoriCell(5,0,2), new HitoriCell(5,1,5), new HitoriCell(5,2,5), new HitoriCell(5,3,6), new HitoriCell(5,4,1), new HitoriCell(5,5,6), new HitoriCell(5,6,8), new HitoriCell(5,7,2)},
                    {new HitoriCell(6,0,4), new HitoriCell(6,1,3), new HitoriCell(6,2,5), new HitoriCell(6,3,8), new HitoriCell(6,4,8), new HitoriCell(6,5,1), new HitoriCell(6,6,4), new HitoriCell(6,7,6)},
                    {new HitoriCell(7,0,1), new HitoriCell(7,1,6), new HitoriCell(7,2,1), new HitoriCell(7,3,3), new HitoriCell(7,4,5), new HitoriCell(7,5,5), new HitoriCell(7,6,2), new HitoriCell(7,7,1)}};
            return original3;
            default: //Same as 0
                HitoriCell[][] originalDefault = new HitoriCell[][] {
                    {new HitoriCell(0,0,1),   new HitoriCell(0,1,4), new HitoriCell(0,2,2), new HitoriCell(0,3,4), new HitoriCell(0,4,3)},
                    {new HitoriCell(1,0,1),   new HitoriCell(1,1,1), new HitoriCell(1,2,3), new HitoriCell(1,3,4), new HitoriCell(1,4,5)},
                    {new HitoriCell(2,0,3),   new HitoriCell(2,1,4), new HitoriCell(2,2,4), new HitoriCell(2,3,5), new HitoriCell(2,4,5)},
                    {new HitoriCell(3,0,4),   new HitoriCell(3,1,5), new HitoriCell(3,2,1), new HitoriCell(3,3,3), new HitoriCell(3,4,2)},
                    {new HitoriCell(4,0,1),   new HitoriCell(4,1,3), new HitoriCell(4,2,3), new HitoriCell(4,3,1), new HitoriCell(4,4,2)}};
                return originalDefault;
        }
    }

    public static Set<HitoriCell[][]> getTestCase(int i)
    {
        Set<HitoriCell[][]> testCases = new HashSet<HitoriCell[][]>();
        switch (i) {
            case 0:
                HitoriCell[][] original1 = getUnsolvedPuzzle(i);
                HitoriCell[][] solution1 = new HitoriCell[][] {
                    {new HitoriCell(0,0,1),         new HitoriCell(0,1,4),       new HitoriCell(0,2,2),       new HitoriCell(0,3,4, true),  new HitoriCell(0,4,3)},
                    {new HitoriCell(1,0,1, true),   new HitoriCell(1,1,1),       new HitoriCell(1,2,3),       new HitoriCell(1,3,4),        new HitoriCell(1,4,5)},
                    {new HitoriCell(2,0,3),         new HitoriCell(2,1,4, true), new HitoriCell(2,2,4),       new HitoriCell(2,3,5),        new HitoriCell(2,4,5, true)},
                    {new HitoriCell(3,0,4),         new HitoriCell(3,1,5),       new HitoriCell(3,2,1),       new HitoriCell(3,3,3),        new HitoriCell(3,4,2)},
                    {new HitoriCell(4,0,1, true),   new HitoriCell(4,1,3),       new HitoriCell(4,2,3, true), new HitoriCell(4,3,1),        new HitoriCell(4,4,2, true)}};
                HitoriCell[][] unreachableWhites1 = new HitoriCell[][] {
                    {new HitoriCell(0,0,1),         new HitoriCell(0,1,4),       new HitoriCell(0,2,2),       new HitoriCell(0,3,4, true),  new HitoriCell(0,4,3)},
                    {new HitoriCell(1,0,1, true),   new HitoriCell(1,1,1),       new HitoriCell(1,2,3,true),  new HitoriCell(1,3,4),        new HitoriCell(1,4,5)},
                    {new HitoriCell(2,0,3),         new HitoriCell(2,1,4, true), new HitoriCell(2,2,4),       new HitoriCell(2,3,5),        new HitoriCell(2,4,5, true)},
                    {new HitoriCell(3,0,4),         new HitoriCell(3,1,5),       new HitoriCell(3,2,1),       new HitoriCell(3,3,3),        new HitoriCell(3,4,2)},
                    {new HitoriCell(4,0,1, true),   new HitoriCell(4,1,3),       new HitoriCell(4,2,3, true), new HitoriCell(4,3,1),        new HitoriCell(4,4,2, true)}};
                HitoriCell[][] tooManyBlacks1 = new HitoriCell[][] {
                    {new HitoriCell(0,0,1, true),   new HitoriCell(0,1,4),       new HitoriCell(0,2,2),       new HitoriCell(0,3,4, true),  new HitoriCell(0,4,3)},
                    {new HitoriCell(1,0,1, true),   new HitoriCell(1,1,1),       new HitoriCell(1,2,3,true),  new HitoriCell(1,3,4),        new HitoriCell(1,4,5)},
                    {new HitoriCell(2,0,3),         new HitoriCell(2,1,4, true), new HitoriCell(2,2,4),       new HitoriCell(2,3,5),        new HitoriCell(2,4,5, true)},
                    {new HitoriCell(3,0,4),         new HitoriCell(3,1,5),       new HitoriCell(3,2,1),       new HitoriCell(3,3,3),        new HitoriCell(3,4,2)},
                    {new HitoriCell(4,0,1, true),   new HitoriCell(4,1,3),       new HitoriCell(4,2,3, true), new HitoriCell(4,3,1),        new HitoriCell(4,4,2, true)}};
                testCases.add(original1);
                testCases.add(unreachableWhites1);
                testCases.add(tooManyBlacks1);
                testCases.add(solution1);
                break;
            case 1:
                HitoriCell[][] original2 = getUnsolvedPuzzle(i);
                HitoriCell[][] solved2 = new HitoriCell[][] {
                    {new HitoriCell(0,0,6, true), new HitoriCell(0,1,6),       new HitoriCell(0,2,8),       new HitoriCell(0,3,1),       new HitoriCell(0,4,7),       new HitoriCell(0,5,5),       new HitoriCell(0,6,5, true), new HitoriCell(0,7,2)},
                    {new HitoriCell(1,0,7),       new HitoriCell(1,1,6, true), new HitoriCell(1,2,1),       new HitoriCell(1,3,7, true), new HitoriCell(1,4,6),       new HitoriCell(1,5,1, true), new HitoriCell(1,6,4),       new HitoriCell(1,7,5)},
                    {new HitoriCell(2,0,8),       new HitoriCell(2,1,1),       new HitoriCell(2,2,5),       new HitoriCell(2,3,7),       new HitoriCell(2,4,5, true), new HitoriCell(2,5,6),       new HitoriCell(2,6,8, true), new HitoriCell(2,7,3)},
                    {new HitoriCell(3,0,3, true), new HitoriCell(3,1,5),       new HitoriCell(3,2,7),       new HitoriCell(3,3,1, true), new HitoriCell(3,4,3),       new HitoriCell(3,5,8),       new HitoriCell(3,6,6),       new HitoriCell(3,7,4)},
                    {new HitoriCell(4,0,5),       new HitoriCell(4,1,7),       new HitoriCell(4,2,8, true), new HitoriCell(4,3,8),       new HitoriCell(4,4,4),       new HitoriCell(4,5,6, true), new HitoriCell(4,6,2),       new HitoriCell(4,7,2, true)},
                    {new HitoriCell(5,0,5, true), new HitoriCell(5,1,4),       new HitoriCell(5,2,6),       new HitoriCell(5,3,3),       new HitoriCell(5,4,7, true), new HitoriCell(5,5,1),       new HitoriCell(5,6,1, true), new HitoriCell(5,7,7)},
                    {new HitoriCell(6,0,6),       new HitoriCell(6,1,7, true), new HitoriCell(6,2,2),       new HitoriCell(6,3,8, true), new HitoriCell(6,4,5),       new HitoriCell(6,5,3),       new HitoriCell(6,6,7),       new HitoriCell(6,7,1)},
                    {new HitoriCell(7,0,2),       new HitoriCell(7,1,3),       new HitoriCell(7,2,4),       new HitoriCell(7,3,5),       new HitoriCell(7,4,1),       new HitoriCell(7,5,3, true), new HitoriCell(7,6,8),       new HitoriCell(7,7,2, true)}};
                HitoriCell[][] unreachables2 = new HitoriCell[][] {
                    {new HitoriCell(0,0,6, true), new HitoriCell(0,1,6),       new HitoriCell(0,2,8),       new HitoriCell(0,3,1),       new HitoriCell(0,4,7),       new HitoriCell(0,5,5),       new HitoriCell(0,6,5, true), new HitoriCell(0,7,2)},
                    {new HitoriCell(1,0,7),       new HitoriCell(1,1,6, true), new HitoriCell(1,2,1),       new HitoriCell(1,3,7, true), new HitoriCell(1,4,6),       new HitoriCell(1,5,1, true), new HitoriCell(1,6,4),       new HitoriCell(1,7,5)},
                    {new HitoriCell(2,0,8),       new HitoriCell(2,1,1),       new HitoriCell(2,2,5),       new HitoriCell(2,3,7),       new HitoriCell(2,4,5, true), new HitoriCell(2,5,6),       new HitoriCell(2,6,8, true), new HitoriCell(2,7,3)},
                    {new HitoriCell(3,0,3, true), new HitoriCell(3,1,5),       new HitoriCell(3,2,7),       new HitoriCell(3,3,1, true), new HitoriCell(3,4,3),       new HitoriCell(3,5,8),       new HitoriCell(3,6,6),       new HitoriCell(3,7,4)},
                    {new HitoriCell(4,0,5),       new HitoriCell(4,1,7),       new HitoriCell(4,2,8, true), new HitoriCell(4,3,8),       new HitoriCell(4,4,4),       new HitoriCell(4,5,6, true), new HitoriCell(4,6,2),       new HitoriCell(4,7,2, true)},
                    {new HitoriCell(5,0,5, true), new HitoriCell(5,1,4),       new HitoriCell(5,2,6),       new HitoriCell(5,3,3),       new HitoriCell(5,4,7, true), new HitoriCell(5,5,1),       new HitoriCell(5,6,1, true), new HitoriCell(5,7,7)},
                    {new HitoriCell(6,0,6),       new HitoriCell(6,1,7, true), new HitoriCell(6,2,2),       new HitoriCell(6,3,8, true), new HitoriCell(6,4,5),       new HitoriCell(6,5,3),       new HitoriCell(6,6,7),       new HitoriCell(6,7,1)},
                    {new HitoriCell(7,0,2),       new HitoriCell(7,1,3),       new HitoriCell(7,2,4, true), new HitoriCell(7,3,5),       new HitoriCell(7,4,1),       new HitoriCell(7,5,3, true), new HitoriCell(7,6,8),       new HitoriCell(7,7,2, true)}};
                HitoriCell[][] adjacentBlacks2 = new HitoriCell[][] {
                    {new HitoriCell(0,0,6, true), new HitoriCell(0,1,6),       new HitoriCell(0,2,8),       new HitoriCell(0,3,1),       new HitoriCell(0,4,7),       new HitoriCell(0,5,5),       new HitoriCell(0,6,5, true), new HitoriCell(0,7,2)},
                    {new HitoriCell(1,0,7, true), new HitoriCell(1,1,6, true), new HitoriCell(1,2,1),       new HitoriCell(1,3,7, true), new HitoriCell(1,4,6),       new HitoriCell(1,5,1, true), new HitoriCell(1,6,4),       new HitoriCell(1,7,5)},
                    {new HitoriCell(2,0,8),       new HitoriCell(2,1,1),       new HitoriCell(2,2,5),       new HitoriCell(2,3,7),       new HitoriCell(2,4,5, true), new HitoriCell(2,5,6),       new HitoriCell(2,6,8, true), new HitoriCell(2,7,3)},
                    {new HitoriCell(3,0,3, true), new HitoriCell(3,1,5),       new HitoriCell(3,2,7),       new HitoriCell(3,3,1, true), new HitoriCell(3,4,3),       new HitoriCell(3,5,8),       new HitoriCell(3,6,6),       new HitoriCell(3,7,4)},
                    {new HitoriCell(4,0,5),       new HitoriCell(4,1,7),       new HitoriCell(4,2,8, true), new HitoriCell(4,3,8),       new HitoriCell(4,4,4),       new HitoriCell(4,5,6, true), new HitoriCell(4,6,2),       new HitoriCell(4,7,2, true)},
                    {new HitoriCell(5,0,5, true), new HitoriCell(5,1,4),       new HitoriCell(5,2,6),       new HitoriCell(5,3,3),       new HitoriCell(5,4,7, true), new HitoriCell(5,5,1),       new HitoriCell(5,6,1, true), new HitoriCell(5,7,7)},
                    {new HitoriCell(6,0,6),       new HitoriCell(6,1,7, true), new HitoriCell(6,2,2),       new HitoriCell(6,3,8, true), new HitoriCell(6,4,5),       new HitoriCell(6,5,3),       new HitoriCell(6,6,7),       new HitoriCell(6,7,1)},
                    {new HitoriCell(7,0,2),       new HitoriCell(7,1,3),       new HitoriCell(7,2,4),       new HitoriCell(7,3,5),       new HitoriCell(7,4,1),       new HitoriCell(7,5,3, true), new HitoriCell(7,6,8),       new HitoriCell(7,7,2, true)}};
                testCases.add(solved2);
                testCases.add(adjacentBlacks2);
                testCases.add(unreachables2);
                testCases.add(original2);
                break;
            case 2: 
                HitoriCell[][] original3 = getUnsolvedPuzzle(i);
                HitoriCell[][] solved3 = new HitoriCell[][] {
                    {new HitoriCell(0,0,1, true), new HitoriCell(0,1,1),       new HitoriCell(0,2,8),       new HitoriCell(0,3,8, true), new HitoriCell(0,4,6),       new HitoriCell(0,5,7, true), new HitoriCell(0,6,4),       new HitoriCell(0,7,8, true)},
                    {new HitoriCell(1,0,6),       new HitoriCell(1,1,1, true), new HitoriCell(1,2,7),       new HitoriCell(1,3,8),       new HitoriCell(1,4,3),       new HitoriCell(1,5,2),       new HitoriCell(1,6,1),       new HitoriCell(1,7,4)},
                    {new HitoriCell(2,0,1),       new HitoriCell(2,1,4),       new HitoriCell(2,2,3),       new HitoriCell(2,3,3, true), new HitoriCell(2,4,2),       new HitoriCell(2,5,4, true), new HitoriCell(2,6,6),       new HitoriCell(2,7,1, true)},
                    {new HitoriCell(3,0,7, true), new HitoriCell(3,1,7),       new HitoriCell(3,2,7, true), new HitoriCell(3,3,1),       new HitoriCell(3,4,5),       new HitoriCell(3,5,6),       new HitoriCell(3,6,3),       new HitoriCell(3,7,8)},
                    {new HitoriCell(4,0,8),       new HitoriCell(4,1,2),       new HitoriCell(4,2,6),       new HitoriCell(4,3,5),       new HitoriCell(4,4,2, true), new HitoriCell(4,5,7),       new HitoriCell(4,6,2, true), new HitoriCell(4,7,1)},
                    {new HitoriCell(5,0,2, true), new HitoriCell(5,1,5),       new HitoriCell(5,2,5, true), new HitoriCell(5,3,6),       new HitoriCell(5,4,1),       new HitoriCell(5,5,6, true), new HitoriCell(5,6,8),       new HitoriCell(5,7,2)},
                    {new HitoriCell(6,0,4),       new HitoriCell(6,1,3),       new HitoriCell(6,2,5),       new HitoriCell(6,3,8, true), new HitoriCell(6,4,8),       new HitoriCell(6,5,1),       new HitoriCell(6,6,4, true), new HitoriCell(6,7,6)},
                    {new HitoriCell(7,0,1, true), new HitoriCell(7,1,6),       new HitoriCell(7,2,1),       new HitoriCell(7,3,3),       new HitoriCell(7,4,5, true), new HitoriCell(7,5,5),       new HitoriCell(7,6,2),       new HitoriCell(7,7,1, true)}};
                HitoriCell[][] adjacentBlacks3 = new HitoriCell[][] {
                    {new HitoriCell(0,0,1, true), new HitoriCell(0,1,1),       new HitoriCell(0,2,8),       new HitoriCell(0,3,8, true), new HitoriCell(0,4,6),       new HitoriCell(0,5,7, true), new HitoriCell(0,6,4),       new HitoriCell(0,7,8, true)},
                    {new HitoriCell(1,0,6),       new HitoriCell(1,1,1, true), new HitoriCell(1,2,7),       new HitoriCell(1,3,8),       new HitoriCell(1,4,3),       new HitoriCell(1,5,2),       new HitoriCell(1,6,1),       new HitoriCell(1,7,4)},
                    {new HitoriCell(2,0,1),       new HitoriCell(2,1,4),       new HitoriCell(2,2,3),       new HitoriCell(2,3,3, true), new HitoriCell(2,4,2),       new HitoriCell(2,5,4, true), new HitoriCell(2,6,6),       new HitoriCell(2,7,1, true)},
                    {new HitoriCell(3,0,7, true), new HitoriCell(3,1,7),       new HitoriCell(3,2,7, true), new HitoriCell(3,3,1),       new HitoriCell(3,4,5),       new HitoriCell(3,5,6),       new HitoriCell(3,6,3),       new HitoriCell(3,7,8)},
                    {new HitoriCell(4,0,8),       new HitoriCell(4,1,2),       new HitoriCell(4,2,6),       new HitoriCell(4,3,5),       new HitoriCell(4,4,2, true), new HitoriCell(4,5,7),       new HitoriCell(4,6,2, true), new HitoriCell(4,7,1)},
                    {new HitoriCell(5,0,2, true), new HitoriCell(5,1,5),       new HitoriCell(5,2,5, true), new HitoriCell(5,3,6),       new HitoriCell(5,4,1),       new HitoriCell(5,5,6, true), new HitoriCell(5,6,8),       new HitoriCell(5,7,2)},
                    {new HitoriCell(6,0,4),       new HitoriCell(6,1,3),       new HitoriCell(6,2,5, true), new HitoriCell(6,3,8, true), new HitoriCell(6,4,8),       new HitoriCell(6,5,1),       new HitoriCell(6,6,4, true), new HitoriCell(6,7,6)},
                    {new HitoriCell(7,0,1, true), new HitoriCell(7,1,6),       new HitoriCell(7,2,1),       new HitoriCell(7,3,3),       new HitoriCell(7,4,5, true), new HitoriCell(7,5,5),       new HitoriCell(7,6,2),       new HitoriCell(7,7,1, true)}};
                HitoriCell[][] unreachables3 = new HitoriCell[][] {
                    {new HitoriCell(0,0,1, true), new HitoriCell(0,1,1),       new HitoriCell(0,2,8),       new HitoriCell(0,3,8, true), new HitoriCell(0,4,6),       new HitoriCell(0,5,7, true), new HitoriCell(0,6,4),       new HitoriCell(0,7,8, true)},
                    {new HitoriCell(1,0,6),       new HitoriCell(1,1,1, true), new HitoriCell(1,2,7),       new HitoriCell(1,3,8),       new HitoriCell(1,4,3),       new HitoriCell(1,5,2),       new HitoriCell(1,6,1),       new HitoriCell(1,7,4)},
                    {new HitoriCell(2,0,1),       new HitoriCell(2,1,4),       new HitoriCell(2,2,3),       new HitoriCell(2,3,3, true), new HitoriCell(2,4,2),       new HitoriCell(2,5,4, true), new HitoriCell(2,6,6),       new HitoriCell(2,7,1, true)},
                    {new HitoriCell(3,0,7, true), new HitoriCell(3,1,7),       new HitoriCell(3,2,7, true), new HitoriCell(3,3,1),       new HitoriCell(3,4,5),       new HitoriCell(3,5,6),       new HitoriCell(3,6,3),       new HitoriCell(3,7,8)},
                    {new HitoriCell(4,0,8),       new HitoriCell(4,1,2),       new HitoriCell(4,2,6),       new HitoriCell(4,3,5),       new HitoriCell(4,4,2, true), new HitoriCell(4,5,7),       new HitoriCell(4,6,2, true), new HitoriCell(4,7,1)},
                    {new HitoriCell(5,0,2, true), new HitoriCell(5,1,5),       new HitoriCell(5,2,5, true), new HitoriCell(5,3,6),       new HitoriCell(5,4,1),       new HitoriCell(5,5,6, true), new HitoriCell(5,6,8),       new HitoriCell(5,7,2)},
                    {new HitoriCell(6,0,4),       new HitoriCell(6,1,3, true), new HitoriCell(6,2,5),       new HitoriCell(6,3,8, true), new HitoriCell(6,4,8),       new HitoriCell(6,5,1),       new HitoriCell(6,6,4, true), new HitoriCell(6,7,6)},
                    {new HitoriCell(7,0,1, true), new HitoriCell(7,1,6),       new HitoriCell(7,2,1),       new HitoriCell(7,3,3),       new HitoriCell(7,4,5, true), new HitoriCell(7,5,5),       new HitoriCell(7,6,2),       new HitoriCell(7,7,1, true)}};
                testCases.add(original3);
                testCases.add(solved3);
                testCases.add(adjacentBlacks3);
                testCases.add(unreachables3);
                break;
            case 99: //Testing the possible black squares function
                HitoriCell[][] test = new HitoriCell[][] {
                    {new HitoriCell(0,0,1),   new HitoriCell(0,1,4), new HitoriCell(0,2,2, true), new HitoriCell(0,3,4), new HitoriCell(0,4,3)},
                    {new HitoriCell(1,0,1, true),   new HitoriCell(1,1,1), new HitoriCell(1,2,3), new HitoriCell(1,3,4), new HitoriCell(1,4,5)},
                    {new HitoriCell(2,0,3),   new HitoriCell(2,1,4, true), new HitoriCell(2,2,4), new HitoriCell(2,3,5), new HitoriCell(2,4,5)},
                    {new HitoriCell(3,0,4),   new HitoriCell(3,1,5), new HitoriCell(3,2,1), new HitoriCell(3,3,3), new HitoriCell(3,4,2)},
                    {new HitoriCell(4,0,1),   new HitoriCell(4,1,3), new HitoriCell(4,2,3), new HitoriCell(4,3,1), new HitoriCell(4,4,2)}};
                testCases.add(test);
                break;
            default:
                //Same as test case 0
                HitoriCell[][] originalDefault = getUnsolvedPuzzle(0);
                HitoriCell[][] solutionDefault = new HitoriCell[][] {
                    {new HitoriCell(0,0,1),         new HitoriCell(0,1,4),       new HitoriCell(0,2,2),       new HitoriCell(0,3,4, true),  new HitoriCell(0,4,3)},
                    {new HitoriCell(1,0,1, true),   new HitoriCell(1,1,1),       new HitoriCell(1,2,3),       new HitoriCell(1,3,4),        new HitoriCell(1,4,5)},
                    {new HitoriCell(2,0,3),         new HitoriCell(2,1,4, true), new HitoriCell(2,2,4),       new HitoriCell(2,3,5),        new HitoriCell(2,4,5, true)},
                    {new HitoriCell(3,0,4),         new HitoriCell(3,1,5),       new HitoriCell(3,2,1),       new HitoriCell(3,3,3),        new HitoriCell(3,4,2)},
                    {new HitoriCell(4,0,1, true),   new HitoriCell(4,1,3),       new HitoriCell(4,2,3, true), new HitoriCell(4,3,1),        new HitoriCell(4,4,2, true)}};
                HitoriCell[][] unreachableWhitesDefault = new HitoriCell[][] {
                    {new HitoriCell(0,0,1),         new HitoriCell(0,1,4),       new HitoriCell(0,2,2),       new HitoriCell(0,3,4, true),  new HitoriCell(0,4,3)},
                    {new HitoriCell(1,0,1, true),   new HitoriCell(1,1,1),       new HitoriCell(1,2,3,true),  new HitoriCell(1,3,4),        new HitoriCell(1,4,5)},
                    {new HitoriCell(2,0,3),         new HitoriCell(2,1,4, true), new HitoriCell(2,2,4),       new HitoriCell(2,3,5),        new HitoriCell(2,4,5, true)},
                    {new HitoriCell(3,0,4),         new HitoriCell(3,1,5),       new HitoriCell(3,2,1),       new HitoriCell(3,3,3),        new HitoriCell(3,4,2)},
                    {new HitoriCell(4,0,1, true),   new HitoriCell(4,1,3),       new HitoriCell(4,2,3, true), new HitoriCell(4,3,1),        new HitoriCell(4,4,2, true)}};
                HitoriCell[][] tooManyBlacksDefault = new HitoriCell[][] {
                    {new HitoriCell(0,0,1, true),   new HitoriCell(0,1,4),       new HitoriCell(0,2,2),       new HitoriCell(0,3,4, true),  new HitoriCell(0,4,3)},
                    {new HitoriCell(1,0,1, true),   new HitoriCell(1,1,1),       new HitoriCell(1,2,3,true),  new HitoriCell(1,3,4),        new HitoriCell(1,4,5)},
                    {new HitoriCell(2,0,3),         new HitoriCell(2,1,4, true), new HitoriCell(2,2,4),       new HitoriCell(2,3,5),        new HitoriCell(2,4,5, true)},
                    {new HitoriCell(3,0,4),         new HitoriCell(3,1,5),       new HitoriCell(3,2,1),       new HitoriCell(3,3,3),        new HitoriCell(3,4,2)},
                    {new HitoriCell(4,0,1, true),   new HitoriCell(4,1,3),       new HitoriCell(4,2,3, true), new HitoriCell(4,3,1),        new HitoriCell(4,4,2, true)}};
                testCases.add(originalDefault);
                testCases.add(tooManyBlacksDefault);
                testCases.add(unreachableWhitesDefault);
                testCases.add(solutionDefault);
                break;
        }
        return testCases;
    }
    
}