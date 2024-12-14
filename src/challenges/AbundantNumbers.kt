package challenges

fun main() {
    var sumOfDivisors = 0

    println("Welcome to our Abundant checker!")
    print("Enter an Integer: ")
    val number = readLine()?.toIntOrNull() ?: return println("Enter a valid number!")


    for (i in 1 until number) {
        if (number % i == 0) {
            sumOfDivisors += i
        }
    }
    if (sumOfDivisors > number) {
        println("$number is an abundant number!")
    }else {
        println("$number is not an abundant number!")
    }
}