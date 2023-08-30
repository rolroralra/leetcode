class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var k = -1
        for (i in nums.indices.reversed()) {
            if (k == -1 || nums[i] < nums[k]) {
                k = i
                continue
            }

            break
        }
        
        return (nums.slice((0 until k)) + nums.slice(k until nums.size)).indexOf(target)
    }
}