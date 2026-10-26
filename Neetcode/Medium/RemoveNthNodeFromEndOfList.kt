/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var p1: ListNode? = head
        var p2 = head
        var count = n

        while(count > 0) {
            p2 = p2?.next
            count--
        }
        if(p2 == null) return head?.next
        while(p2?.next != null) {
            p2 = p2?.next
            p1 = p1?.next
        }
        // println("${p1?.`val`} : ${p2?.`val`}")
        p1?.next = p1?.next?.next
        return head

    }
}

