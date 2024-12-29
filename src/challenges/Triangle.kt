package challenges

/* In this challenge we need to calculate the sum of the better path from top to bottom of the triangle.
        rule: we must move to an adjacent number of the row below.
*/

fun main() {
    val triangle = listOf(
        listOf(1,),
        listOf(1, 6),
        listOf(1, 2, 3),
        listOf(3, 7, 5, 4),
        listOf(9, 3, 6, 4, 1)
    )
    val result = routeCalculate(triangle)
    println(result)
}

fun routeCalculate(triangle: List<List<Int>>): Int {
    val lastLine = triangle.last().toMutableList() // I've saved the last row of the triangle in this variable

    for (row in triangle.size - 2 downTo 0) {  // Iterate from the second-to-last row to the top
        for (col in triangle[row].indices) {       // Iterate through each column in the current row
            lastLine[col] = triangle[row][col] + minOf(lastLine[col], lastLine[col + 1])  // Update the "last line" (our result) with best option between the two options below
        }
    }
    return lastLine[0] // The result will be the first index of this variable
}