package challenges

import kotlin.math.pow

fun main() {

    val exclude = mutableListOf<Int>()
    var soma = 0.0

    println("Welcome to our Happy numbers checker!")

    print("Enter a Integer: ")
    var number = readLine()?.toIntOrNull() ?: return println("Enter a valid number!")

    while (soma != 1.0) {
        soma = number.toString().sumOf { (it.digitToInt()).toDouble().pow(2) }
        number = soma.toInt()
        if (exclude.contains(number)) {
            println("Is not a happy number!")
            break
        }
        exclude.add(soma.toInt())
    }

    if (soma == 1.0) {
        println("Is a happy number!")
    }
}