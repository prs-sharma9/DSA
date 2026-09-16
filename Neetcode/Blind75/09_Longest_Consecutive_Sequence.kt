// LINK: https://neetcode.io/problems/longest-consecutive-sequence/question?list=neetcode150

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        // Converting the input array into a set, making all operations O(1)
        val set = nums.toHashSet()
        var result = 0
        for(n in nums) {
            // Finding the start of any sequence,
            // For any number, if input set does not contain immediate smaller number
            // then that number is the starting point of a sequence.
            if(!set.contains(n-1)) {
                val len = getLengthFor(n, set)
                if(len > result) result = len
            }
        }

        return result;
    }


    /**
     * Returns the length of sequence starting from a num
     * @param
     * num: Starting point a sequence
     * set: Hashset containing the input numbers
     * 
     * @Returns: Length on consecutive sequence starting from nums.
     */
    fun getLengthFor(num: Int, set: HashSet<Int>): Int {
        var len: Int = 0
        var flag: Boolean = true
        var n = num
        while (flag) {
            // println("num: $n; len: $len")
            if(set.contains(num++)) {
                len++
            } else {
                flag = false
            }
        }
        return len
    }
}
