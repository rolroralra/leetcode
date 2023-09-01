class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val intervalList = intervals.map { Interval(it) }.sortedBy { it.start }

        var pivotInterval = intervalList.first()

        val result = mutableListOf(pivotInterval)

        for (interval in intervalList) {
            if (pivotInterval.isOverlapping(interval)) {
                pivotInterval.merge(interval)
            } else {
                pivotInterval = interval
                result.add(pivotInterval)
            }
        }

        return result.map { intArrayOf(it.start, it.end) }.toTypedArray();
    }

    class Interval(var start: Int, var end: Int, var isMerged: Boolean = false) {
        constructor(intArray: IntArray): this(intArray[0], intArray[1])

        fun isIn(point: Int): Boolean {
            return point in range()
        }

        private fun range(): IntRange = (start..end)
    }


    private fun Interval.isOverlapping(interval: Interval): Boolean {
        return when {
            start <= interval.start && interval.end <= end -> true
            interval.start <= start && end <= interval.end -> true
            isIn(interval.start) || isIn(interval.end) -> true
            else -> false
        }
    }

    private fun Interval.merge(interval: Interval) {
        val mergedStart = listOf(start, end, interval.start, interval.end).minOf { it }
        val mergedEnd = listOf(start, end, interval.start, interval.end).maxOf { it }

        start = mergedStart
        end = mergedEnd
    }
}