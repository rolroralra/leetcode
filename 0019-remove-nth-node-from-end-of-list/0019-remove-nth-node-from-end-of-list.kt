/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var forward: ListNode? = head
        var backward: ListNode? = head
        
        repeat(n) {
            forward = forward?.next
        }

        if (forward == null) {
            return head?.next
        }

        while (forward?.next != null) {
            forward = forward?.next
            backward = backward?.next
        }

        backward?.next = backward?.next?.next

        return head
    }
}