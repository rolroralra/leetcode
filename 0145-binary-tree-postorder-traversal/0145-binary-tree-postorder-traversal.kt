/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        postorderTraversal(root, result)

        return result   
    }

    private fun postorderTraversal(root: TreeNode?, trace: MutableList<Int>): Unit {
        if (root == null) {
            return
        }

        postorderTraversal(root.left, trace)
        postorderTraversal(root.right, trace)
        trace.add(root.`val`)
    }
}