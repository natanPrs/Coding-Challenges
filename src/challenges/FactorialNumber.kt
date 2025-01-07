package challenges

fun main() {
    var result = 1
    println("Welcome to Factorial Checker!")
    val number = forPrompt("Enter an integer: ")

    for (i in 1..number) {
        result *= i
    }

    println("The factorial of $number is $result")

}

fun forPrompt(messager: String): Int{
    print(messager)
    return readlnOrNull()?.toIntOrNull() ?: forPrompt("Invalid entry! Try again: ")
}