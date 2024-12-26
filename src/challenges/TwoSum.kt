package challenges

fun twoSum(numbers: IntArray, target: Int): IntArray {
    val matchFinder = mutableMapOf<Int, Int>()

    for ((index, number) in numbers.withIndex()) {

        if (matchFinder.containsKey(number)){
            return intArrayOf(matchFinder[number]!!, index)
        }
        val wantedNumbers = target - number

        matchFinder[wantedNumbers] = index
    }

    return intArrayOf()
}

fun main() {
    println(twoSum(intArrayOf(2, 7, 11, 15), 26).contentToString())
    println(twoSum(intArrayOf(3, 2, 4), 6).contentToString())
    println(twoSum(intArrayOf(3, 3), 6).contentToString())
}
