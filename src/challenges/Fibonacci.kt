package challenges

fun main() {
    val number = forInput("Enter an integer: ")

    var a = 0
    var b = 1

    for (i in 2..number) {
        val temp = a + b
        a = b
        b = temp
    }

    println("The Fibonacci number of $number is $b")
}

fun forInput(message: String): Int {
    print(message)
    return readlnOrNull()?.toIntOrNull() ?: forInput("Enter a valid number! Try again:  ")
}

