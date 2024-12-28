package challenges

fun main() {
    println("Welcome to Pascal's Triangle!")
    val rowNumber = 5
    val triangle = generateTriangle(rowNumber)

    triangle.forEach { println(it) }
}

fun generateTriangle(rowNumber: Int): MutableList<List<Int>> {
    val result = mutableListOf<List<Int>>()

    for (i in 0 until rowNumber) {
        val row = MutableList(i + 1) { 1 }

        for (j in 1 until i){
            row[j] = result[i - 1][j - 1] + result[i - 1][j]
        }
        result.add(row)
    }
    return result
}