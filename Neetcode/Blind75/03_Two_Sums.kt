/*
* THE PROBLEM
* I'm given an array of integers and a target value, and I need to find the indices of the two
* numbers that add up to the target.
*
* MY THOUGHT PROCESS
* The most straightforward thing I can do is pick each number one at a time and ask: "what value
* would I need to pair with this one to hit the target?" That value is just `target - nums[i]`,
* the complement. Once I know the complement I'm looking for, I check every number that comes
* after it for a match.
*
* This is the brute-force approach -- it checks every pair exactly once, so it's guaranteed to
* find the answer, but it's not the fastest option since a hashmap could do this lookup in one
* pass instead of two nested loops.
*
* WALKING THROUGH AN EXAMPLE
* nums = [2, 7, 11, 15], target = 9
*   - i=0: nums[0]=2, complement = 9 - 2 = 7
*     - j=1: nums[1]=7 -> matches the complement, so I return [0, 1].
*
* WHY THIS WORKS
* For every element, I'm exhaustively checking all the elements after it for the exact value
* that would complete the pair. Since I check every possible pair in the array, I can't miss the
* answer if one exists.
*
* COMPLEXITY
* Time: O(n^2) -- for each element, I scan the rest of the array looking for its complement.
* Space: O(1) -- no extra data structures, just the output array.
*/

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
