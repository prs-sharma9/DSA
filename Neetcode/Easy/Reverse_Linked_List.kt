/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */


// Simple method using pointer
// class Solution {
//     fun reverseList(head: ListNode?): ListNode? {
        
//         var rhead: ListNode? = null
//         var curr:ListNode? = head
//         while(curr != null) {
//             // println(node?.`val`)
//             val nxt = curr.next
//             curr.next = rhead
//             rhead = curr
//             curr = nxt
//         }
//         return rhead
//     }
// }

// Kotlin way using scope function
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
    
        var curr = head
        var prev: ListNode? = null
        while(curr != null) {
            curr = curr.next.also {
                curr.next = prev
                prev = curr
            }
        }
        return prev
    }
}

/*
using `tailrec`
When you mark a function as tailrec, the Kotlin compiler performs a neat trick: it secretly rewrites your recursion into a standard while loop behind the scenes.
For the compiler optimization to work, the recursive call must be the absolute last thing the function executes.
Safety: It makes recursion perfectly safe for production code, even against massive data sets.
*/ 
// class Solution {
//     fun reverseList(head: ListNode?): ListNode? {
//         tailrec fun rev(curr: ListNode?, prev: ListNode?): ListNode? {
//             if(curr == null) return prev
//             val nxt = curr.next
//             curr.next = prev
//             return rev(nxt, curr)
//         }
//         return rev(head, null)
//     }
// }

