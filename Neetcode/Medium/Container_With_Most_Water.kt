class Solution {
    fun maxArea(heights: IntArray): Int {
        var p1 = 0
        var p2 = heights.size - 1
        var maxArea = 0
        while(p1 < p2) {
            val area = getArea(p1, heights[p1], p2, heights[p2])
            if(area > maxArea) maxArea = area
            if(heights[p1] < heights[p2]) {
                p1++
            } else {
                p2--
            }
        }
        return maxArea

    }
    fun getArea(idx1: Int, h1: Int, idx2: Int, h2: Int): Int {
        return min(h1, h2) * (idx2 - idx1)
    }
}

