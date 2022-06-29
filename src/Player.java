import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<String> runs;
    private int sixes;
    private int fours;
    private int dots;

    private String name;
    private int totalRuns;


    public Player(String name) {
        runs = new ArrayList<>();
        this.name = name;
        totalRuns = 0;
    }

    public void scoreRun(String run) {
        runs.add(run);
        if (run.equals("W")) {
           return;
        }
        int runInt = Integer.parseInt(run);
        if (runInt == 6)
            sixes++;
        else if (runInt == 4)
            fours++;
        else if (runInt == 0)
            dots++;

        totalRuns += runInt;

    }

    public List<String> getRuns() {
        return runs;
    }

    public void setRuns(List<String> runs) {
        this.runs = runs;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
