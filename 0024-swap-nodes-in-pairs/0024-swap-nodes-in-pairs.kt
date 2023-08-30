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
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val nextNode = head.next?.next
        val result = head.next
        result?.next = head
        head.next = swapPairs(nextNode)

        return result
    }
}