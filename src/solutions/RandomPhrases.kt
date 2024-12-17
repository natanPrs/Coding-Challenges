package solutions

fun main() {
    var optionYesNo: String
    var wordOption: String
    println("Welcome to Random Funny Phrases generator!")
    print("Enter the number of funny phrases you want: ")
    val numberPhrases = readLine()?.toIntOrNull() ?: return println("Enter a valid Integer!")

    do {
        println("Do you want to insert a funny word? (yes/no)")
        optionYesNo = readlnOrNull() ?: "Pedro"

    } while (optionYesNo.lowercase() !in listOf("yes", "no"))

    if (optionYesNo == "yes") {
        do {
            println("What kind of word you want to insert:\n" +
                    "1 - Subject\n" +
                    "2 - Action\n" +
                    "3 - Complement")
            wordOption = readlnOrNull() ?: return println("Pedro, Pedro, Pedro")

        } while (wordOption !in listOf("1", "2", "3"))

        when (wordOption) {
            "1" -> {
                print("Enter the subject: ")
                val subject = readLine() ?: ""
                subjects.add(subject)
            }
            "2" -> {
                print("Enter the action: ")
                val action = readLine() ?: ""
                actions.add(action)
            }
            "3" -> {
                print("Enter the complement: ")
                val complement = readLine() ?: ""
                complements.add(complement)
            }
        }
    }

    for (i in 1..numberPhrases) {
        println(generatePhrases())
    }

}

val subjects = mutableListOf("O animal", "O pato")
val actions = mutableListOf("Liderou", "Sugou")
val complements = mutableListOf("A manada", "O canudo")

val generatePhrases: () -> String = {
    val subject = subjects.random()
    val action = actions.random()
    val complement = complements.random()

    "$subject $action $complement"
}