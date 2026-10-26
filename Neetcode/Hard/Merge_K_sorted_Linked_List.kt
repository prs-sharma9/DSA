/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
import java.util.PriorityQueue

class Solution {
    // fun mergeKLists(lists: Array<ListNode?>): ListNode? {

    //     var newList: ListNode? = null
    //     var curr: ListNode? = null
    //     var sIdx = shouldStopLooping(lists)
    //     while(sIdx != -1) {
    //         for(idx in 0 until lists.size) {
    //             if ((lists[idx]?.`val` ?: Int.MAX_VALUE) < (lists[sIdx]?.`val` ?: Int.MAX_VALUE)){
    //                 sIdx = idx
    //             }
    //         }
    //         if(newList == null) {
    //             newList = lists[sIdx]
    //             curr = newList
    //         } else {
    //             curr?.next = lists[sIdx]
    //             curr = curr?.next
    //         }
    //         lists[sIdx] = lists[sIdx]?.next
    //         sIdx = shouldStopLooping(lists)
    //     }

    //     return newList;
    // }


    // fun shouldStopLooping(lists: Array<ListNode?>): Int {
    //     for(idx in 0 until lists.size) {
    //         if(lists[idx] != null) return idx
    //     }
    //     return -1
    // }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val minHeap = PriorityQueue<ListNode>(compareBy {it.`val`})

        for(list in lists) {
            list?.let{ minHeap.offer(it) }
        }

        var dummy = ListNode(0)
        var curr = dummy

        while(minHeap.isNotEmpty()) {
            val smallest = minHeap.poll();
            smallest.next?.let { minHeap.offer(it) }

            curr.next = smallest
            curr = curr.next!!
        }

        return dummy.next
    }
}

