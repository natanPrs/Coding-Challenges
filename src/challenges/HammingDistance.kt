package challenges

fun main() {
    println("Welcome to Hamming Distance Checker!")
    var result = 0
    var number1 = promptInput("Enter The first number").toString(2)
    var number2 = promptInput("Enter The second number").toString(2)
    number1 = number1.padStart(number2.length, '0')
    number2 = number2.padStart(number1.length, '0')

    for (i in 0 until number1.length) {
        if (number2[i] != number1[i]) result += 1
    }

    println(result)
}

fun promptInput(message: String): Int {
    print("$message :")
    val input = readlnOrNull()?.trim()?.toIntOrNull().takeIf { it != null } ?: promptInput("Invalid entry! Try again")
    return input
}
