package challenges

fun main() {
    println("Welcome to the palindrome checker")

    print("Type an integer: ")
    val input = readLine()

    if (input.isNullOrEmpty() || input.any {!it.isDigit()}) {
        println("Please, type a valid number.")
        return
    }

    val originalList = input.map { it.toString().toInt() }.toMutableList()
    val reverseList = mutableListOf<Int>()

    while (originalList.isNotEmpty()) {
        val lastNumber = originalList.removeLast()
        reverseList.add(lastNumber)
    }

    println("Original number $input")
    println("Inverse number ${reverseList.joinToString("")}")

    if (input == reverseList.joinToString("")) {
        println("That number is a palindrome.")
    }else {
        println("That number isn't a palindrome.")
    }
}