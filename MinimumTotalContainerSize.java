/*
You want to move N items in k days (N >= k). You have to move at least one item per day.
The items are listed in array P, where P[i] is size of item i. You can move item i only if all items from 0 to [i-1] are already moved. Every day you need a container to pack the item and move it. The container size needed for day i is the maximum item size moved on that day. Given k days and array P as the item sizes, find out the minimum total container size required to move all the items.

Input:
P = [10, 2, 20, 5, 15, 10, 1]
d = 3

Output:
31
day1 - [10, 2, 20, 5, 15], Containersize = 20
day2 - [10], ContainerSize = 10
day3 - [1], ContainerSize = 1
Total = 20 + 10 + 1 = 31
*/


/*
Similar to: https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
*/

import java.lang.*;
import java.util.*;

public class Solution {
	public int minContainerSize(int[] p, int d) {
        int len = p.length;
        
        if (d > len) {
            return -1;
        }
        
        int[][] dp = new int[d][len];
        dp[0][0] = p[0];
        for (int j = 1; j < len; j++) {
            dp[0][j] = Math.max(dp[0][j-1], p[j]);
        }
        
        for (int i = 1; i < d; i++) {
            for (int j = i; j < len; j++) {
                int localMax = p[j];
                dp[i][j] = localMax + dp[i-1][j-1];
                for (int k = j-1; k >= i; k--) {
                    localMax = Math.max(localMax, p[k]);
                    dp[i][j] = Math.min(dp[i][j], localMax + dp[i-1][k-1]);
                }
            }
        }
        
        return dp[d-1][len-1];
    }
}

public class MinimumTotalContainerSize {
	public static void main(String[] args) {
	
	}
}
