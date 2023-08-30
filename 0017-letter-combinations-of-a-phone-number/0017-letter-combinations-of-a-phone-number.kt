class Solution {
    private val digitToLetterMap = mapOf('2' to "abc", '3' to "def", '4' to "ghi", '5' to "jkl", '6' to "mno", '7' to "pqrs", '8' to "tuv", '9' to "wxyz")
    
    fun letterCombinations(digits: String): List<String> = 
    digits.mapNotNull { digit -> 
        digitToLetterMap.getOrDefault(digit, "").toList()
    }.getCartesianProduct2().map { String(it.toCharArray()) }
      
}

 fun <T> Collection<Iterable<T>>.getCartesianProduct2(): List<List<T>> {
    if (isEmpty()) {
        return emptyList()
    }

    var result = mutableListOf(mutableListOf<T>())

    forEach { iterable ->
        result = iterable.flatMap { element ->
            result.map { previous ->
                previous.plus(element).toMutableList()
            }
        }.toMutableList()
    }

    return result
}