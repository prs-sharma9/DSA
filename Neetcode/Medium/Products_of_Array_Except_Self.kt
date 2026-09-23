// LINK: https://neetcode.io/problems/products-of-array-discluding-self/question?list=neetcode150

/*
* THE PROBLEM
* I'm given an array of integers, and for each position I need to return the product of every
* other number in the array except the one at that position -- without using division.
*
* MY THOUGHT PROCESS
* My first instinct was "just multiply everything together and divide by nums[i] for each
* position," but that breaks the moment there's a zero in the array (and I'm not allowed to use
* division anyway). So I need another way to get "everything except this one value."
*
* The product of everything except index i is really just: (product of everything to its left)
* times (product of everything to its right). So if I precompute the running product of
* everything to the left of each index, and separately the running product of everything to the
* right of each index, I can combine the two for any position without ever touching division.
*
* I build this in three passes:
* 1. left_product[idx] = product of nums[0..idx] (inclusive, running product going left to right).
* 2. right_product[idx] = product of nums[idx..end] (inclusive, running product going right to
*    left).
* 3. For each index, output[idx] is left_product[idx-1] * right_product[idx+1] -- everything
*    strictly to the left, times everything strictly to the right. The first and last indices are
*    special-cased since there's nothing to their left or right respectively.
*
* WALKING THROUGH AN EXAMPLE
* nums = [1, 2, 3, 4]
*   - left_product:  [1, 2, 6, 24]   (1, 1*2, 1*2*3, 1*2*3*4)
*   - right_product: [24, 24, 12, 4] (1*2*3*4, 2*3*4, 3*4, 4)
*   - idx=0: nothing to the left, so output[0] = right_product[1] = 24
*   - idx=1: output[1] = left_product[0] * right_product[2] = 1 * 12 = 12
*   - idx=2: output[2] = left_product[1] * right_product[3] = 2 * 4 = 8
*   - idx=3: nothing to the right, so output[3] = left_product[2] = 6
*   - Final result: [24, 12, 8, 6]
*
* WHY THIS WORKS
* Every index's answer only needs "everything to the left" and "everything to the right"
* multiplied together, and I've already precomputed both of those as running products, so I can
* just look them up and multiply instead of recomputing anything from scratch.
*
* COMPLEXITY
* Time: O(n) -- three separate passes over the array, each linear.
* Space: O(n) -- the left_product and right_product arrays (beyond the required output array).
*/

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

