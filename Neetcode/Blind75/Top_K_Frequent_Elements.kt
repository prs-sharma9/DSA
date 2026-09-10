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
