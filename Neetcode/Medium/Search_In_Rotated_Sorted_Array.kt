class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        var result = -1
        while(l < r) {
            var m = l + ((r - l) / 2)
            // println("Value at $m is ${nums[m]}")
            if(nums[m] == target) return m
            if(nums[m] >= nums[l]) {
                // println("Left array is sorted")
                if(target < nums[l] || target > nums[m]) {
                    // go right
                    l = m + 1
                } else {
                    // go left
                    r = m - 1
                }
            }
            else if(nums[m] < nums[r]) {
                // println("Right array is sorted")
                if(target > nums[r] || target < nums[m]) {
                    // go left
                    r = m - 1
                } else {
                    // go right
                    l = m + 1
                }
            }
        }
        if(l == r && nums[l] == target) return l
        return result
    }
}

