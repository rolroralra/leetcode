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
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?): ListNode? {
        return headA.intersect(headB)
    }

    private fun ListNode?.toList(): List<ListNode> {
        return generateSequence(this) { it.next }.toList()
    }

    private fun ListNode?.intersect(other: ListNode?): ListNode? {
        return this.toList().intersect(other.toList().toSet()).firstOrNull()
    }
}