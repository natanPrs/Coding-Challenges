package challenges

import java.text.Normalizer

fun main() {
    println("Welcome to our Phrase Palindrome checker!")
    print("Enter your phrase: ")
    val phrase = readlnOrNull() ?: return println("Enter some phrase.")

    val phraseNoAccents = Normalizer.normalize(phrase, Normalizer.Form.NFD).replace("[^A-Za-z ]".toRegex(),"")
    val phraseCleaned = phraseNoAccents.lowercase().replace(" ", "")

    val phraseReversed = phraseCleaned.reversed()

    if (phraseReversed == phraseCleaned) {
        println("This phrase is a palindrome!")
    }else {
        println("This phrase is NOT a palindrome!")
    }
}