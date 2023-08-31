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
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }

        val visited = mutableMapOf<ListNode, Boolean>()

        var currNode: ListNode = head
        visited[currNode] = true

        while (currNode.next != null) {

            val nextNode: ListNode = currNode.next!!

            if (visited[nextNode] == true) {
                return true
            }

            visited[nextNode] = true

            currNode = nextNode
        }

        return false
}
}