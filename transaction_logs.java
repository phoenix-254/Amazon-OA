/*
Your Amazonian team is responsible for maintaining a monetary transaction service. The transactions are tracked in a log file.
A log file is provided as a string array where each entry represents a transaction to service. Each transaction consists of:

sender_user_id, Unique identifier for the user that initiated the transaction. It consists of only digits with at most 9 digits.
recipient_user_id: Unique identifier for the user that is receiving the transaction. It consists of only digits with at most 9 digits.
amount_of_transaction: The amount of the transaction. It consists of only digits with at most 9 digits.

The values are separated by a space. For example, "sender_user_id recipient_user_id amount_of_transaction".
Users that perform an excessive amount of transactions might be abusing the service so you have been tasked to identify the users that have a number of transactions over a threshold. The list of user ids should be ordered in ascending numeric value.

Example:
logs = ["88 99 200", "88 99 300", "99 32 100", "12 12 15"]
threshold = 2

The transactions count for each user, regardless of role are:

ID       Transactions
---       --------------
99       3
88       2
12       1
32       1

There are two users with at least threshold = 2 transactions: 99 and 88. In ascending order, the return arra is ['88', '99'].
*/

import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public String[] processLogFile(String[] logs, int threshold) {
        Map<String, Integer> count = new HashMap<>();
        
        for (String log : logs) {
            String sId = log.split(" ")[0];
            String rId = log.split(" ")[1];
            String amt = log.split(" ")[2];
            
            count.put(sId, count.getOrDefault(sId, 0) + 1);
            if (!sId.equals(rId)) count.put(rId, count.getOrDefault(rId, 0) + 1);
        }
        
        List<String> usersAboveThreshold = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() >= threshold) usersAboveThreshold.add(entry.getKey());
        }
        
        String[] ans = new String[usersAboveThreshold.size()];
        int i = 0;
        for (String id : usersAboveThreshold) ans[i++] = id;
        
        Arrays.sort(ans);
        
        return ans;
    }
}
