class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for(i in 0 until nums.size) {
            val complement = target - nums[i]
            for(j in i+1 until nums.size) {
                if(nums[j] == complement) return intArrayOf(i,j)
            }
        }
        return intArrayOf(-1,-1)
    }
}
