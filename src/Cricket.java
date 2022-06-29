import exceptions.CricketException;
import exceptions.InningsOverException;

import java.util.Scanner;

public class Cricket {

    public static void main(String[] args) {
        Team t1, t2;
        boolean isSecondInnings = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("No. of players for each team : ");
        int noOfPlayers = sc.nextInt();

        System.out.println("No. of overs : ");
        int noOfOvers = sc.nextInt();

        System.out.println("Enter details for TEAM 1 : ");
        t1 = getTeam(sc, noOfPlayers, noOfOvers);
        System.out.println("Enter details for TEAM 2 : ");
        t2 = getTeam(sc, noOfPlayers, noOfOvers);

        System.out.println("Enter runs for first innings of TEAM 1 : ");
        getOverWiseScore(sc, noOfOvers, t1, t2, isSecondInnings);
        int target = t1.getTotalRuns() + 1;
        System.out.println("Target for Team 2 is : " + target);
        isSecondInnings = true;

        System.out.println("Enter runs for second innings of TEAM 2 : ");
        getOverWiseScore(sc, noOfOvers, t1, t2, isSecondInnings);
    }

    /**
     * Get the team player input from console
     * @param sc
     * @param noOfPlayers
     * @param noOfOvers
     * @return
     */
    private static Team getTeam(Scanner sc, int noOfPlayers, int noOfOvers) {
        int noOfPlayersTemp = noOfPlayers;
        Team t1 = new Team(noOfPlayers, noOfOvers);

        System.out.println("Enter player names : ");
        int temp = 0;
        while (noOfPlayersTemp-- > 0) {
            temp++;
            System.out.println("Player : " + temp);
            String name = sc.next();
            try {
                t1.addPlayerToTeam(new Player(name));
            } catch (CricketException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        return t1;
    }

    /**
     * Get the scores from the console.
     * @param sc
     * @param noOfOvers
     * @param t1
     * @param t2
     * @param isSecondInnings
     */
    private static void getOverWiseScore(Scanner sc, int noOfOvers, Team t1, Team t2, boolean isSecondInnings) {
        System.out.println("Runs over wise : ");
        Team currentTeam = isSecondInnings ? t2 : t1;
        for (int i = 0; i < noOfOvers; i++) {
            System.out.println("Over " + (i + 1) + " :");
            boolean endFlag = false;
            for (int j = 0; j < 6; j++) {
                try {
                    String run = sc.next();
                    if (run.equals("Wd") || run.equals("NB"))
                        i--;
                    currentTeam.scoreRun(run);
                    if (isSecondInnings && checkIfTargetIsReached(t1, t2)) {
                        endFlag = true;
                        break;
                    }
                } catch (InningsOverException e) {
                    System.out.println(e.getMessage());
                    endFlag = true;
                    break;
                }

            }
            currentTeam.printScoreCard();
            if(endFlag)
                break;
        }

        if(isSecondInnings)
            printResult(t1, t2);

    }

    /**
     * Print the result on the console
     * @param t1
     * @param t2
     */
    private static void printResult(Team t1, Team t2) {
        if (t1.getTotalRuns() == t2.getTotalRuns()) {
            System.out.println("Match is tied!");
        } else if (t1.getTotalRuns() > t2.getTotalRuns()) {
            System.out.println("Team 1 has won the match!");
        } else {
            System.out.println("Team 2 has won the match!");
        }
    }

    /**
     * Check if the target is reached
     * @param t1
     * @param t2
     * @return
     */
    private static boolean checkIfTargetIsReached(Team t1, Team t2) {
        return t2.getTotalRuns() > t1.getTotalRuns();
    }
}
