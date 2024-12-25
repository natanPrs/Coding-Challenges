package challenges

import solutions.promptForYesNo

fun main() {
    val palindromesList = mutableListOf<String>()
    println("Welcome to Palindrome Generator")

    do {
        val input = promptForInput("Enter a word: ")

        when (palindromeChecker(input)) {
            true -> palindromesList.add(input)
            false -> palindromesList.add(generatePalindrome(input))
        }

        val yesOrNo = challenges.promptForYesNo("Do you want to add something else?")
    } while (yesOrNo)

    println("Palindromes Generated: ")
    palindromesList.forEach { println(" - $it") }

}

fun promptForInput(message: String): String {
    println(message)
    return readlnOrNull()?.trim().takeIf { !it.isNullOrEmpty() } ?: promptForInput("Enter a valid word!")
}

fun palindromeChecker(input: String): Boolean {
    return (input.lowercase() == input.reversed().lowercase())
}

fun generatePalindrome(input: String):String {
    return input + input.reversed()
}

fun promptForYesNo(message: String): Boolean {
    val input = promptForInput("$message (Yes/No)").lowercase()
    return when (input) {
        "yes" -> true
        "no" -> false
        else -> promptForYesNo("Invalid Answer! Try Again: ")
    }
}

