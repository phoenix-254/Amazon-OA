/*
A customer wants to buy a pair of jeans, a pair of shoes, a skirt, and a top but has a limited budget in dollars. Given different pricing options for each product, determine how many options our customer has to buy 1 of each product. You cannot spend more money than the budgeted amount.

Example
priceOfJeans = [2, 3]
priceOfShoes = [4]
priceOfSkirts = [2, 3]
priceOfTops = [1, 2]
budgeted = 10

The customer must buy shoes for 4 dollars since there is only one option. This leaves 6 dollars to spend on the other 3 items. Combinations of prices paid for jeans, skirts, and tops respectively that add up to 6 dollars or less are [2, 2, 2], [2, 2, 1], [3, 2, 1], [2, 3, 1]. There are 4 ways the customer can purchase all 4 items.

Function Description

Complete the getNumberOfOptions function in the editor below. The function must return an integer which represents the number of options present to buy the four items.

getNumberOfOptions has 5 parameters:
int[] priceOfJeans: An integer array, which contains the prices of the pairs of jeans available.
int[] priceOfShoes: An integer array, which contains the prices of the pairs of shoes available.
int[] priceOfSkirts: An integer array, which contains the prices of the skirts available.
int[] priceOfTops: An integer array, which contains the prices of the tops available.
int dollars: the total number of dollars available to shop with.

Constraints:
1 ≤ a, b, c, d ≤ 103
1 ≤ dollars ≤ 109
1 ≤ price of each item ≤ 109
Note: a, b, c and d are the sizes of the four price arrays
*/

import java.util.*;

class Main {
    private static int numOptions(int[] pj, int[] ps, int[] psk, int[] pt, int d) {
        int ans = 0;

        int[] sums1 = new int[pj.length * ps.length];
        int k = 0;
        for (int i = 0; i < pj.length; i++) {
            for (int j = 0; j < ps.length; j++) {
                if (pj[i] + ps[j] <= d) {
                    sums1[k++] = pj[i] + ps[j];
                }
            }
        }        

        int[] sums2 = new int[psk.length * pt.length];
        k = 0;
        for (int i = 0; i < psk.length; i++) {
            for (int j = 0; j < pt.length; j++) {
                if (psk[i] + pt[j] <= d) {
                    sums2[k++] = psk[i] + pt[j];
                }
            }
        }

        Arrays.sort(sums1);
        Arrays.sort(sums2);

        for (int s : sums1) {
            int t = d - s + 1;
            int low = 0, high = sums2.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (sums2[mid] < t) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            ans += low;
        }

        return ans;
    }

    public static void main(String[] args) {
        int numOptions = numOptions(
            new int[]{2, 3}, new int[]{4}, new int[]{2, 3}, new int[]{1, 2}, 10);
        System.out.println(numOptions);
    }
}
