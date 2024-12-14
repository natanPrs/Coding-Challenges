package solutions

import kotlin.math.pow

fun main() {
    val exclude = mutableListOf<Int>()

    println("Welcome to our Happy numbers checker!")
    print("Enter an Integer: ")
    var number = readLine()?.toIntOrNull() ?: return println("Enter a valid number!")

    while (number != 1) {
        number = number.toString().sumOf { (it.digitToInt()).toDouble().pow(2) }.toInt()

        if (exclude.contains(number)) {
            println("Is not a happy number!")
            return
        }
        exclude.add(number)
    }
    println("Is a happy number!")
}