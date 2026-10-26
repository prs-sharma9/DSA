/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        // find the mid point using slow and fast pointer.
        // break the list from middle
        // reverse the second list 
        // start arranging the nodes.

        if (head == null) return
        if (head.next == null) return

        var slow = head
        var fast = head

        while(fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // break the list from center
        var head2 = slow?.next
        slow?.next = null

        // reverse the second list
        var prev: ListNode? = null
        var curr = head2

        while(curr != null) {
            val temp = curr?.next
            curr?.next = prev
            prev = curr
            curr = temp
        }

        head2 = prev

        var p1 = head
        var p2 = head2

        while(p1 != null && p2 != null) {
            val t1 = p1?.next
            val t2 = p2?.next
            p1?.next = p2
            p2?.next = t1
            p1 = t1
            p2 = t2
        }

    }
}

