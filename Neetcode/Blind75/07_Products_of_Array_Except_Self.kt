class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val ip_size = nums.size
        val output = IntArray(ip_size)
        val left_product = IntArray(ip_size)
        val right_product = IntArray(ip_size)
        left_product[0] = nums[0]
        for(idx in 1 until ip_size) {
            left_product[idx] = left_product[idx-1] * nums[idx]
        }
        right_product[ip_size-1] = nums[ip_size-1]
        for(idx in ip_size-2 downTo 0) {
            right_product[idx] = right_product[idx+1] * nums[idx]
        }
        for(idx in 0 until ip_size) {
            when(idx) {
                0 -> {
                    output[idx] = right_product[idx+1]
                }
                ip_size-1 -> {
                    output[idx] = left_product[idx-1]
                }
                else -> {
                    output[idx] = left_product[idx-1] * right_product[idx+1]
                }
            }
        }
        
        return output
    }
}

