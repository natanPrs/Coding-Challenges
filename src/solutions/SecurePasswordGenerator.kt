package solutions

/*  IMPROVEMENTS:
        - Function "promptYesNo" improved
 */

fun main() {
    var passLength: Int
    var chosen: List<Boolean>
    var includeUpper: Boolean
    var includeLower:Boolean
    var includeNumber: Boolean
    var includeSpecial: Boolean
    println("Welcome to the Secure Password Generator!")

    do {
        print("Enter the desired password length: ")
        passLength = readlnOrNull()?.toIntOrNull() ?: return println("Enter a valid number!")

        if (passLength < 6 ) {
            println("Your password must have at least 6 digits.")
        }

    }while (passLength < 6)

    do {

        includeUpper = promptYesNo("Include uppercase letters? (yes/no)")
        includeLower = promptYesNo("Include lowercase letters? (yes/no)")
        includeNumber = promptYesNo("Include numbers? (yes/no)")
        includeSpecial = promptYesNo("Include special characters? (yes/no)")

        chosen = listOf(includeSpecial,includeNumber,includeLower,includeUpper)

        if (chosen.all { !it }) {println("You must choose at least one option") }

    }while (chosen.all { !it } )


    var generatedPassword = passwordGenerator(passLength, includeUpper,includeLower,includeNumber,includeSpecial)
    println(generatedPassword)

    do {
        val repeat = promptYesNo("Do you want to generate another password? (yes/no): ")
        if (repeat) {
            generatedPassword = passwordGenerator(passLength, includeUpper,includeLower,includeNumber,includeSpecial)
            println(generatedPassword) }
    } while (repeat)

}

fun promptYesNo(message: String): Boolean {
    var option: String
    do {
        println(message)
        option = readlnOrNull() ?: ""

        if (option.isEmpty()) {
            println("Invalid answer! Try again")
        }
    }while (option.lowercase() !in listOf("yes", "no"))
    return option == "yes"
}

fun passwordGenerator(size: Int, includeUpper: Boolean, includeLower: Boolean, includeNumber: Boolean ,includeSpecial: Boolean ): String {
    val allowedCharacters = mutableListOf<Char>()

    if (includeLower) allowedCharacters.addAll('a'..'z')
    if (includeNumber) allowedCharacters.addAll('0'..'9')
    if (includeUpper) allowedCharacters.addAll('A'..'Z')
    if (includeSpecial) allowedCharacters.addAll("!@#\$%^&*()-_=+[{]}|\\\\;:'\\\",<.>/?~".toList())

    return (1..size).map { allowedCharacters.random() }.joinToString("")
}
