package challenges

fun main () {
    println("Welcome to Random Funny Phrases!")
    print("Enter the number of phrases you want: ")
    val numberPhrases = readLine()?.toIntOrNull() ?: return println("Enter a valid Integer!")

    for (i in 1..numberPhrases) {
        println(generateRandomPhrase())
    }
}

val subjects = listOf("A minha vó", "O gato", "O pombo", "A sua mãe", "O monitor")
val actions = listOf("comeu", "matou", "jogou", "destruiu", "construiu", "degustou")
val complements = listOf("um bolo inteiro", "o sol", "a nave dos aliens", "uma caminhonete", "uma pedra na escola")

val generateRandomPhrase: () -> String = {
    val subject = subjects.random()
    val action = actions.random()
    val complement = complements.random()

    "$subject $action $complement"
}