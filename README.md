# cricket-scoreboard
Write a cricket scorecard that will show the score for a team along with score of each player.

Problem Statement :
You will be given the number of players in each team, the number of overs and their batting
order as input. Then, we can input overs ball by ball with the runs scored on that ball (could be
wide, no ball or a wicket as well).
You are expected to print individual scores, number of balls faced, number of 4s, number of 6s
for all the players from the batting side at the end of every over. You also need to print total
score, total wickets. Essentially, you need to keep a track of all the players, strike changes (at
the end of the over or after taking singles or 3s) and maintain their scores, also keep track of
extra bowls that are being bowled (like wides or no balls). You also need to print which team
won the match at the end.
This is the bare minimum solution which is expected for the problem. You can add some more
features once you are done with these, like maintaining bowlers record (total overs bowled, runs
conceded, wickets taken, maiden overs, dot balls, economy, etc.). Total team extras, batsman
strike rates, etc. can be added too. But these are "good to have" features, please try to complete
the bare minimum first.
Make sure your code is readable and maintainable and preferably object oriented. It should be
modular and extensible, to add new features if needed.

Main : Cricket.java

Sample Input :

No. of players for each team :
5
No. of overs :
2
Enter details for TEAM 1 :
Enter player names :
Player : 1
P1
Player : 2
P2
Player : 3
P3
Player : 4
P4
Player : 5
P5
Enter details for TEAM 2 :
Enter player names :
Player : 1
P6
Player : 2
P7
Player : 3
P8
Player : 4
P9
Player : 5
P10
Enter runs for first innings of TEAM 1 :
Runs over wise :
Over 1 :
1 1 1 1 1 2
SCORECARD :
Player Name      Total Runs     Total Balls           4s           6s
P1*              3              3              0              0
P2*              4              3              0              0
P3              0              0              0              0
P4              0              0              0              0
P5              0              0              0              0
Total Score : 7 / 0
Total Overs : 1.0

Over 2 :
W 4 4 Wd W 1 6
SCORECARD :
Player Name      Total Runs     Total Balls           4s           6s
P1              3              4              0              0
P2*              4              3              0              0
P3              8              3              2              0
P4*              1              1              0              0
P5              0              0              0              0
Total Score : 17 / 2
Total Overs : 1.5

Over 2 :
Innings ended, as all the overs are completed.
SCORECARD :
Player Name      Total Runs     Total Balls           4s           6s
P1              3              4              0              0
P2*             10              4              0              1
P3              8              3              2              0
P4*              1              1              0              0
P5              0              0              0              0
Total Score : 23 / 2
Total Overs : 2.0

Target for Team 2 is : 24
Enter runs for second innings of TEAM 2 :
Runs over wise :
Over 1 :
4 6 W W 1 1
SCORECARD :
Player Name      Total Runs     Total Balls           4s           6s
P6             10              3              1              1
P7*              1              1              0              0
P8              0              1              0              0
P9*              1              1              0              0
P10              0              0              0              0
Total Score : 12 / 2
Total Overs : 1.0

Over 2 :
6 1 W W
Innings ended because team got all out.
SCORECARD :
Player Name      Total Runs     Total Balls           4s           6s
P6             10              3              1              1
P7*              8              3              0              1
P8              0              1              0              0
P9              1              2              0              0
P10              0              1              0              0
Total Score : 19 / 4
Total Overs : 1.4

Team 1 has won the match!