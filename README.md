# cricket-scoreboard
Write a cricket scorecard that will show the score for a team along with score of each player.



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