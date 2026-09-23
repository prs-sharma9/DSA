class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size == 1) return 0
        var buy = prices[0]
        var profit = 0
        var sell = prices[0]
        for(value in prices) {
            if (value < buy) {
                buy = value
                sell = value
            }
            else if (value > sell) sell = value
            if((sell - buy) > profit) profit = sell - buy
        }

        return profit
    }
}

