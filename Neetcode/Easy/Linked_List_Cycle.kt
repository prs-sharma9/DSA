/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var p1 = head
        var p2 = head?.next
        while(p1 != null && p2 != null) {
            if(p1 == p2) return true 
            p1 = p1?.next
            p2 = p2?.next?.next
        }
        return false
    }
}

