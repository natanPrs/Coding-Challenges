package challenges

fun main() {
    println("Welcome to Hero generator!")
    print("How many Heroes you want to generate: ")
    val heroesQuantity = readln()?.toIntOrNull() ?: return println("Enter a valid number!")

    println("Do you wanna add some adjective or substantive? (yes/no)")
    val wantAdd = readlnOrNull() ?: ""

    if (wantAdd == "yes") {
        do {
            val option = loop("Do you wanna add adjective or substantive?", "Adjective", "Substantive")
            if (option == "1" || option == "2") {
                when (option) {
                    "1" -> {
                        print("Enter a Adjective: ")
                        val word = readlnOrNull() ?: ""
                        adjective.add(word)
                    }
                    "2" -> {
                        print("Enter a Substantive: ")
                        val word = readlnOrNull() ?: ""
                        substantives.add(word)
                    }
                }

            }
            do {
                println("Do you wanna add something else? (yes/no)")
            }while (readlnOrNull()?.lowercase() !in listOf("yes", "no"))
        }while (readlnOrNull()?.lowercase() != "no")
    }

    for (i in 1..heroesQuantity) {
        println(generateHero())
    }
}

val adjective = mutableListOf("Veloz", "Misterioso", "Incrível", "Assoprador", "Sofredor", "Destruidor", "Alfaiate")
val substantives = mutableListOf("Pedro", "Tigre", "Frango", "Fênix", "Boleiro", "Gato", "Luan", "Pedreiro")

val generateHero: () -> String = {
    val adjective = adjective.random()
    val substantive = substantives.random()

    "$substantive $adjective"
}

fun loop(message: String, one: String, two: String): String {
    var option: String
    do {
        println("$message")
        println("1- $one\n" +
                "2- $two")
        option = readlnOrNull() ?: ""
    }while (option.lowercase() !in listOf("1", "2"))

    return option
}