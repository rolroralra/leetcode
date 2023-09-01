class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val intervalList = intervals.map { Interval(it) }.sortedBy { it.start }

        val mergedIntervalList = mutableListOf<Interval>()

        for (interval in intervalList) {
            var pivotInterval = interval
            for (nextInterval in intervalList) {
                if (nextInterval == interval || nextInterval.isMerged) {
                    continue
                }

                if (pivotInterval.isOverlapping(nextInterval)) {
                    pivotInterval = pivotInterval.merge(nextInterval)
                    nextInterval.isMerged = true
                }
            }

            if (pivotInterval != interval) {
                mergedIntervalList.add(pivotInterval)
                interval.isMerged = true
            }
        }

        return intervalList
            .filter { it.isMerged.not() }
            .plus(mergedIntervalList)
            .sortedBy { it.start }
            .map { intArrayOf(it.start, it.end) }
            .toTypedArray()
    }

    class Interval(val start: Int, val end: Int, var isMerged: Boolean = false) {
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

    private fun Interval.merge(interval: Interval): Interval {
        check(isOverlapping(interval))
        val mergedStart = listOf(start, end, interval.start, interval.end).minOf { it }
        val mergedEnd = listOf(start, end, interval.start, interval.end).maxOf { it }

        return Interval(mergedStart, mergedEnd)
    }
}