package challenges

// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
//On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
//Find and return the maximum profit you can achieve.

fun main() {
    val prices = intArrayOf(7,1,5,3,6,4)
    println(calculateMaxProfit(prices))
}

fun calculateMaxProfit(prices: IntArray): Int {
    var purchase = Int.MAX_VALUE   //Variable initialized with max value
    var totalProfit = 0

    prices.forEachIndexed { index, price ->     // Here I iterate through the prices to get the Index and its number
        if (price < purchase) purchase = price

        if ((index + 1 < prices.size) && (price > purchase) && (price > prices[index + 1]) || index == prices.lastIndex) {
            val profit = price - purchase
            totalProfit += profit
            purchase = Int.MAX_VALUE
        }
    }

    return totalProfit
}