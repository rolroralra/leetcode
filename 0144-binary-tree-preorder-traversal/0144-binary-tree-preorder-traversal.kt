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
    fun preorderTraversal(root: TreeNode?): List<Int> {
        var result = mutableListOf<Int>()

        preorderTraversal(root, result)

        return result    
    }

    private fun preorderTraversal(root: TreeNode?, trace: MutableList<Int>): Unit {
        if (root == null) {
            return
        }

        trace.add(root.`val`)
        preorderTraversal(root.left, trace)
        preorderTraversal(root.right, trace)
    }
}