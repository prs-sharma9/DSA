class Solution {
    fun findMin(nums: IntArray): Int {
        if(nums.size == 1) return nums[0]
        return binarySearch(0, nums.size-1, nums)
    }

    fun binarySearch(l: Int, r: Int, nums: IntArray): Int {
        println("l:$l, r:$r")
        if(l < 0 || r >= nums.size || l>r) return 10001
        val m: Int = (l + r) ushr 1 
        println("m:$m")
        if(m == 0) {
            if(nums[m+1] > nums[m]) return nums[m]
        }
        else if(m == nums.size-1) {
            if(nums[m] < nums[m-1]) return nums[m]
        }
        else if(nums[m-1] > nums[m] && nums[m+1] > nums[m]) {
            return nums[m]
        }
        val n1 = binarySearch(l, m-1, nums)
        val n2 = binarySearch(m+1, r, nums)
        if(n1<n2) return n1
        return n2
    }
}

