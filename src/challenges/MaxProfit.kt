package challenges

fun main() {
    val prices = intArrayOf(50, 20, 50, 30, 10, 20)
    println(maxProfit(prices))  // Saída: 5

}

fun maxProfit(prices: IntArray): Int {
    var minPrice = Int.MAX_VALUE
    var maxProfit = 0

    for (price in prices) {
        if (price < minPrice) minPrice = price

        val profit = price - minPrice
        if (profit > maxProfit) maxProfit = profit
    }

    return maxProfit
}
