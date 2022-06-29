import exceptions.CricketException;
import exceptions.InningsOverException;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class Team {
    private int teamSize;
    private List<Player> players;
    private List<String> runs;
    private int totalRuns;
    private int onStrikePlayerIndex;
    private int offStrikePlayerIndex;
    private int lastPlayerIndex;
    private List<List<String>> overWiseRuns;
    private int oversCompleted;
    private int currentOverBallNo;
    private int totalNumberOfBalls;
    private int totalNumberOfOvers;
    private int wickets;

    public Team(int teamSize, int totalNumberOfOvers) {
        this.teamSize = teamSize;
        this.players = new ArrayList<>();
        this.runs = new ArrayList<>();
        this.overWiseRuns = new ArrayList<>();
        this.overWiseRuns.add(new ArrayList<>()); //Initializing first over
        this.totalRuns = 0;
        this.onStrikePlayerIndex = 0;
        this.offStrikePlayerIndex = 1;
        this.currentOverBallNo = 0;
        this.totalNumberOfBalls = 0;
        this.totalNumberOfOvers = totalNumberOfOvers;
        this.lastPlayerIndex = 1;
        this.wickets = 0;
        this.oversCompleted = 0;
    }

    /**
     * Adding player to team
     *
     * @param player
     * @throws CricketException
     */
    public void addPlayerToTeam(Player player) throws CricketException {
        if (players.size() == teamSize) {
            throw new CricketException("Team size has exceeded");
        }
        players.add(player);
    }

    /**
     * Adding score the team
     * @param run
     * @throws InningsOverException
     */
    public void scoreRun(String run) throws InningsOverException {
        List<String> currentOver = overWiseRuns.get(overWiseRuns.size() - 1);
        if (run.equals("Wd") || run.equals("NB")) {
            totalRuns++;
        } else {
            totalNumberOfBalls++;
            currentOverBallNo++;
            Player onStrikePlayer = players.get(onStrikePlayerIndex);
            onStrikePlayer.scoreRun(run);
            currentOver.add(run);

            //Processing wicket
            if (run.equals("W")) {
                wickets++;
                checkInningsEndForWicket();
                lastPlayerIndex++;
                onStrikePlayerIndex = lastPlayerIndex;
            } else {
                //Changing strike on odd runs
                if (Integer.parseInt(run) % 2 != 0)
                    strikeChange();

                totalRuns += Integer.parseInt(run);
            }

            //Creating a new over
            if (currentOverBallNo == 6) {
                currentOverBallNo = 0;
                oversCompleted++;
                checkInningsEndForOver();   //Checking if innings has ended because of over
                overWiseRuns.add(new ArrayList<>());    //Creating a new over
                strikeChange();
            }
        }
    }

    /**
     * Check if the team is all out
     * @throws InningsOverException
     */
    private void checkInningsEndForWicket() throws InningsOverException {
        if (lastPlayerIndex + 1 == players.size()) {
            lastPlayerIndex = -1;
            onStrikePlayerIndex = -1;
            throw new InningsOverException("Innings ended because team got all out.");
        }
    }

    /**
     * check if the overs have been completed
     * @throws InningsOverException
     */
    private void checkInningsEndForOver() throws InningsOverException {
        if (totalNumberOfOvers == overWiseRuns.size()) {
            throw new InningsOverException("Innings ended, as all the overs are completed.");
        }
    }

    /**
     * Changing strike of the batsmen
     */
    private void strikeChange() {
        int temp = onStrikePlayerIndex;
        onStrikePlayerIndex = offStrikePlayerIndex;
        offStrikePlayerIndex = temp;
    }

    /**
     * Prints score card
     */
    public void printScoreCard() {
        System.out.println("SCORECARD : ");
        Formatter fmt = new Formatter();
        fmt.format("%15s %15s %15s %12s %12s\n", "Player Name", "Total Runs", "Total Balls", "4s", "6s");
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            String playerName = player.getName() + (i == onStrikePlayerIndex || i == offStrikePlayerIndex ? "*" : "");
            fmt.format("%14s %14s %14s %14s %14s\n", playerName, player.getTotalRuns(), player.getRuns().size(), player.getFours(), player.getSixes());
        }
        fmt.format("Total Score : %s / %s\n", totalRuns, wickets);
        fmt.format("Total Overs : %s.%s\n", oversCompleted, currentOverBallNo);
        System.out.println(fmt);
    }

    public int getTotalRuns() {
        return totalRuns;
    }

}

