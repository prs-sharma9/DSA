class Solution {
    fun trap_extra_space(height: IntArray): Int {
        val maxLeft: IntArray = IntArray(height.size)
        val maxRight: IntArray = IntArray(height.size)
        var trappedWater = 0
        var max = height[0]
        for(idx in 0 until height.size) {
            if(height[idx] > max) max = height[idx]
            maxLeft[idx] = max
        }
        max = height[height.size-1]
        for (idx in height.size-1 downTo 0) {
            if(height[idx] > max) max = height[idx]
            maxRight[idx] = max
        }

        for(idx in 0 until height.size) {
            val water = min(maxLeft[idx], maxRight[idx]) - height[idx]
            if (water > 0) trappedWater += water
        }

        return trappedWater
    }

    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxRight = height[right]
        var maxLeft = height[left]
        var trappedWater = 0
        while(left<right) {
            if(maxLeft < maxRight) {
                // shift left pointer
                left++
                maxLeft = max(maxLeft, height[left])
                val water = maxLeft - height[left]
                if(water > 0) trappedWater += water
            } else {
                // shift right pointer
                right--
                maxRight = max(maxRight, height[right])
                val water = maxRight - height[right]
                if(water > 0) trappedWater += water
            }
        }

        return trappedWater
    }
    
}

