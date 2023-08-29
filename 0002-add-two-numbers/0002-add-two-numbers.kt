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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val result = ListNode(0)

        var currNode: ListNode? = result
        var carry = 0
        var left = l1
        var right = l2
        while (left != null || right != null || carry != 0) {
            val v1 = left?.`val` ?: 0
            val v2 = right?.`val` ?: 0

            val nextValue = v1 + v2 + carry

            currNode?.next = ListNode(nextValue.rem(10))
            carry = nextValue.div(10)
            currNode = currNode?.next
            left = left?.next
            right = right?.next
        }

        return result.next
    }
}