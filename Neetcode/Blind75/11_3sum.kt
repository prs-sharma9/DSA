class Solution {
    // fun threeSum(nums: IntArray): List<List<Int>> {
    //     val sortedNums = nums.sortedArray()
    //     val result: MutableSet<List<Int>> = mutableSetOf()

    //     for (idx in 0 until sortedNums.size-1) {
    //         val target = sortedNums[idx] * -1
    //         val twoSums = twoSum(sortedNums, target, idx+1, sortedNums.size-1)
    //         if(!twoSums.isEmpty()) {
    //             for(l in twoSums)
    //             result.add(listOf(sortedNums[idx],l[0], l[1]))
    //         }
    //     }
    //     return result.toList()
    // }

    // fun twoSum(nums: IntArray, target: Int, start: Int, end: Int): List<List<Int>> {
    //     var idx1 = start
    //     var idx2 = end
    //     val result: MutableSet<List<Int>> = mutableSetOf()
    //     while(idx1 < idx2) {
    //         val sum = nums[idx1] + nums[idx2]
    //         if(sum < target) {
    //             idx1++
    //         } else if(sum > target) {
    //             idx2--
    //         } else {
    //             result.add(listOf(nums[idx1], nums[idx2]))
    //             idx2--
    //             idx1++
    //         }
    //     }
    //     return result.toList()
    // }

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()

        for(a in 0 until nums.size-2) {
            if( a == 0 || nums[a] != nums[a-1]) { // optimization condition to avoid duplicate checks
                var b = a + 1
                var c = nums.size - 1
                while(b < c) {
                    val sum = nums[a] + nums[b] + nums[c]
                    if(sum == 0) {
                        result.add(listOf(nums[a], nums[b], nums[c]))
                        do {            // optimization to avoid adding same triplet
                            b++ 
                        } while (b < c && nums[b] == nums[b-1])
                        do {            // optimization to avoid adding same triplet
                            c--
                        } while (b < c && nums[c] == nums[c+1])
                    } else if(sum < 0) {
                        b++
                    } else {
                        c--
                    }
                }
            }
            
        }
        return result
    }

}
