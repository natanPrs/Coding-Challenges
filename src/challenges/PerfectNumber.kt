package challenges

fun main() {
    var result = 0
    val number = input("Enter a Integer: ")

    for (i in 1..<number) {
        if (number % i == 0) {
            result += i
        }
    }

    if (result == number) println("$number is a perfect number!") else println("$number is not a perfect number!")
}

fun input(message: String): Int {
    print(message)
    return readlnOrNull()?.toIntOrNull() ?: input("Invalid entry! Try again: ")
}