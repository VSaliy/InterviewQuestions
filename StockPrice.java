import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
/**
Given a stock price of one company for a day, create an method that would return the maximum profit for the day given the following conditions:

you can only buy and sell once
the difference between buy and sell time must be at least five seconds long
Assumptions:

the difference in time between each stock price is 1 second long
stock prices are already in order by time
if there is no profit for the day, return 0

*/

public class Solution {

    /*
     * Complete the function below.
     */
    static long maxProfit(long[] prices) {
        long maxProfit = 0;
        long bestSell = prices[0];
        long bestSellIndex = 0;
        for (int i = 0; i < prices.length; i++) {
            //maxDiffIndex = i;
            if (prices[i] > bestSell) {
                bestSell = prices[i];
                bestSellIndex = i;
            }
        }
        maxProfit = bestSell - prices[0];
        for (int i = 0; i < prices.length; i++) {
            long diff = Math.max(maxProfit, Math.abs(prices[i] - bestSell));
            if (diff > maxProfit && Math.abs(bestSellIndex - i) >= 5) {
                maxProfit = diff;
            }

        }
        return maxProfit;

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        } else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        long res;
        int prices_size = 0;
        prices_size = Integer.parseInt(in.nextLine().trim());

        long[] prices = new long[prices_size];
        for (int i = 0; i < prices_size; i++) {
            long prices_item;
            prices_item = Long.parseLong(in.nextLine().trim());
            prices[i] = prices_item;
        }

        res = maxProfit(prices);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
