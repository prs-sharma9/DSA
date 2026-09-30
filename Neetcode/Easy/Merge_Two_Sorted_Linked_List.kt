/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

/*
Simple approach
*/
// class Solution {
//     fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
//         var merged: ListNode? = null
//         var list1 = list1
//         var list2 = list2
//         var curr: ListNode? = null
//         while(list1 != null && list2 != null) {
//             var newNode : ListNode? = null
//             if(list1.`val` <= list2.`val`) {
//                 newNode = list1
//                 list1 = list1.next
//             } else {
//                 newNode = list2
//                 list2 = list2.next
//             }
//             newNode.next = null

//             if(merged == null) {
//                 merged = newNode    
//                 curr = newNode
//             } else {
//                 curr?.next = newNode
//                 curr = curr?.next
//             }
//         }
//         var remaining: ListNode? = null
//         if(list1 != null) {
//             remaining = list1
//         } else {
//             remaining = list2
//         }

//         if(merged == null) {
//             merged = remaining
//         } else {
//             curr?.next = remaining
//         }

//         return merged
//     }
// }


/*
Smart way: By adding pseudoHead node we avoided check if merged list is initialized or not.
The merged list is always initialized and and we can simply return the next of pseudoHead at the end.
*/

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val pseudoHead = ListNode(-1000)
        var tail: ListNode = pseudoHead
        var l1 = list1
        var l2 = list2
        while(l1 != null && l2 != null) {
            if(l1.`val` <= l2.`val`) {
                tail.next = l1
                tail = tail.next!!
                l1 = l1.next
            } else {
                tail.next = l2
                tail = tail.next!!
                l2 = l2.next
            }
        }
        tail.next = l1 ?: l2
        return pseudoHead.next
    }
}

