/*
* THE PROBLEM
* I'm given an array of integers and a number k, and I need to return the k values that occur
* most often in the array.
*
* MY THOUGHT PROCESS
* First, I need to know how often each value shows up, so a hashmap is the natural fit -- I walk
* the array once and bump the count for each value I see.
*
* Once I have every value's frequency, I need the k highest ones. The simplest way to get there
* is to turn the map into a list of (value, frequency) pairs, sort that list by frequency in
* descending order, and just take the first k entries.
*
* WALKING THROUGH AN EXAMPLE
* nums = [1, 1, 1, 2, 2, 3], k = 2
*   - Counting frequencies: {1: 3, 2: 2, 3: 1}
*   - As a list of pairs: [(1,3), (2,2), (3,1)]
*   - Sorted by frequency descending: [(1,3), (2,2), (3,1)] (already in the right order here)
*   - Taking the top k=2 pairs: [(1,3), (2,2)]
*   - Pulling out just the values: [1, 2]
*
* WHY THIS WORKS
* Once every value's true frequency is known, sorting by frequency guarantees the most frequent
* values end up at the front of the list, so slicing off the first k always gives me the k most
* frequent values.
*
* COMPLEXITY
* Time: O(n log n) -- counting is O(n), but sorting the (value, frequency) pairs dominates.
*   (This could be brought down to O(n) with a bucket-sort approach instead of a full sort, but
*   I went with the simpler sort here.)
* Space: O(n) -- the hashmap and the resulting list both scale with the number of distinct values.
*/

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val hashmap = LinkedHashMap<Int, Int>()
        for (i in nums) {
            hashmap[i] = hashmap.getOrDefault(i, 0) + 1
        }
        val sortedList = hashmap.toList().sortedBy { it.second }.reversed().subList(0,k)

        for (i in sortedList) {
            result.add(i.first)
        }
        return result.toIntArray()
    }
}
