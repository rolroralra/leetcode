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
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var node = head

        val stack = Stack<ListNode>()
        repeat(k) {
            if (node == null) {
                return head
            }

            stack.push(node)
            node = node?.next
        }

        val result = stack.pop()
        var currNode = result
        var nextNode = result.next
        while (stack.isNotEmpty()) {
            currNode.next = stack.pop()
            currNode = currNode.next
        }

        currNode.next = reverseKGroup(nextNode, k)

        return result
    }
}