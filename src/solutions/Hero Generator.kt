package solutions

import challenges.generateHero

fun main() {
    println("Welcome to the Hero Generator!")
    val heroesQuantity = promptForNumber("How many Heroes do you want to generate: ")

    if(promptForYesNo("Do you want to add some adjective or substantive?")) {
        while (true) {
            when (promptForOption("Do you want add: ", "Adjective", "Substantive" )) {
                "1" -> adjectiveList.add(promptForInput("Enter an Adjective: "))
                "2" -> substantiveList.add(promptForInput("Enter a Substantive: "))
            }
            if (!promptForYesNo("Do you want to add something else?")) break
        }
    }

    repeat(heroesQuantity) {
        println(generateHero())
    }
}
val substantiveList = mutableListOf("Pedro", "Tigre", "Frango", "Fênix", "Boleiro", "Gato", "Luan", "Pedreiro")
val adjectiveList = mutableListOf("Veloz", "Misterioso", "Incrível", "Assoprador", "Sofredor", "Destruidor", "Alfaiate")


fun promptForNumber(message: String): Int {
    println(message)
    return readlnOrNull()?.toIntOrNull() ?: promptForNumber("Enter a valid number: ")
}

fun promptForInput(message: String): String{
    print(message)
    return readlnOrNull()?.trim().takeIf { !it.isNullOrEmpty() } ?: promptForInput("Enter a valid input!")
}

fun promptForYesNo(message: String): Boolean {
    val input = promptForInput("$message (yes/no) ").lowercase()
    return when(input) {
        "yes" -> true
        "no" -> false
        else -> promptYesNo("Invalid answer!) ")
    }
}

fun promptForOption(message: String, option1: String, option2: String): String {
    println(message)
    println("1- $option1\n2- $option2")
    return readlnOrNull()?.trim().takeIf { it in listOf("1", "2") } ?: promptForOption(message, option1, option2)
}