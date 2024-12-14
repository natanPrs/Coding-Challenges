package solutions

import kotlin.math.sqrt

/* Improvements:
    - Best efficiency for large numbers
    - Checks up to the square root of the number
    - Numbers above the square root are added more efficiently
 */

fun main() {
    var sumOfDivisors = 0

    println("Welcome to our Abundant checker!")
    print("Enter an Integer: ")
    val number = readLine()?.toIntOrNull() ?: return println("Enter a valid number!")

    val squareRoot = sqrt(number.toDouble()).toInt()


    for (i in 1..squareRoot) {
        if (number % i == 0) {
            sumOfDivisors += i
            if (i != 1 && i != number / i) {
                sumOfDivisors += number / i
            }
        }
    }

    if (sumOfDivisors > number) {
        println("$number is an abundant number!")
    }else {
        println("$number is not an abundant number!")
    }
}