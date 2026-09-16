// LINK: https://neetcode.io/problems/duplicate-integer/question?list=neetcode150

/*
* THE PROBLEM
* I'm given an array of integers and I need to figure out if any value appears more than once.
* I just need a true/false answer -- I don't care which value repeats or how many times.
*
* MY THOUGHT PROCESS
* The most direct way to spot a duplicate is to compare every element against every other
* element, but that's an O(n^2) approach and it doesn't sit right with me for larger inputs.
* What I really want is a way to bring equal values next to each other so I only ever need to
* compare neighbors.
*
* Sorting does exactly that. Once the array is sorted, any duplicate values are guaranteed to
* land right beside each other, so a single pass checking `nums[i] == nums[i+1]` is enough to
* catch a repeat anywhere in the array.
*
* WALKING THROUGH AN EXAMPLE
* Input: [1, 2, 3, 1]
*   - Sorted: [1, 1, 2, 3]
*   - i=0: nums[0]=1, nums[1]=1 -> they match, so I return true immediately.
*
* A non-duplicate case, [1, 2, 3, 4]:
*   - Sorted: [1, 2, 3, 4]
*   - No two neighbors ever match, so I fall through the loop and return false.
*
* WHY THIS WORKS
* Sorting guarantees that if a value repeats anywhere in the array, its copies end up adjacent
* to each other, so I never have to look further than one position ahead to catch it.
*
* COMPLEXITY
* Time: O(n log n) -- dominated by the sort; the scan afterward is only O(n).
* Space: O(1) extra space beyond the sort itself (sorting is done in place).
*/

class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        nums.sort()
        
        nums.sort()
        
        for( i in 0 until nums.size-1) {
            if(nums[i] == nums[i+1]) return true
        }
        return false
    }
}