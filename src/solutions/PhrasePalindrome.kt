package solutions

import java.text.Normalizer

/*  IMPROVEMENTS:
        - More to the point
        - Wider range of international words
  */

fun main() {
    println("Welcome to our Phrase Palindrome checker!")
    print("Enter your phrase: ")
    val phrase = readlnOrNull() ?: return println("Enter some phrase.")

    val phraseNoAccents = Normalizer.normalize(phrase, Normalizer.Form.NFD).replace("[^\\p{L}\\p{N}]+".toRegex(),"")
    val phraseCleaned = phraseNoAccents.lowercase().replace(" ", "")

    if (phraseCleaned.reversed() == phraseCleaned) {
        println("This phrase is a palindrome!")
    }else {
        println("This phrase is NOT a palindrome!")
    }
}