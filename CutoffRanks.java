/*
A group of work friends at Amazon is playing a competitive video game together. During the game, each player receives a certain amount of points based on their performance. At the end of a round, players who achieve at least a cutoff rank get to "level up" their character, gaining increased abilities for them. Given the scores of the players at the end of the round, how many players will be able to level up their character?

Note that players with equal scores will have equal ranks, but the player with the next lowest score will be ranked based on the position within the list of all players' scores. For example, if there are four players, and three players tie for first place, their ranks would be 1,1,1, and 4. Also, no player with a score of O can level up, no matter what their rank.

Write an algorithm that returns the count of players able to level up their character.

Input
The input to the function/method consists of three arguments:
cutOffRank, an integer representing the cutoff rank for levelin up the player's character;
num, an integer representing the total number of scores;
scores, a list of integers representing the scores of the players.

Output
Return an integer representing the number of players who will be able to level up their characters at the end of the round.

Constraints
1 <= num <= 10^5
0 <= scores[i] <= 100
0 <= i < num
cutOffRank <= num

Example 1:
Input:
cutOffRank = 3
num= 4
scores=[100, 50, 50, 25 ]

Output:
3

Explanation:
There are num= 4 players, where the cutOffRank is 3 and scores = [100, 50,50, 25]. These players' ranks are [1, 2, 2, 4]. Because the players need to have a rank of at least 3 to level up their characters, only the first three players will be able to do so.
So, the output is 3.

Example 2:
Input:
cutOffRank = 4
num=5
scores=[2,2,3,4,5]

Output:
5

Explanation:
In order, the players achieve the ranks [4,4,3,2,1]. Since the cutOffRank is 4, all 5 players will be able to level up their characters.
So, the output is 5.
*/
import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public int cutOffRank(int cutOffRank, int num, int[] scores) {
        int[] scoreMap = new int[101];
        for (int s : scores) {
            scoreMap[s] += 1;
        }
        
        int ans = 0;
        for (int i = 100; i > 0; i--) {
            if (ans >= cutOffRank) break;
            ans += scoreMap[i];
        }
        return ans;
    }
}

public class CutoffRanks {
	public static void main(String[] args) {
		
	}
}
