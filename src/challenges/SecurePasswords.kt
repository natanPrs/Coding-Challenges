package challenges

fun main() {

    println("Welcome to Secure Passwords checker!")
    print("Enter your password: ")
    var password = readlnOrNull() ?: return println("Enter some password!")
    var errors = checkPassword(password)


    while (errors.isNotEmpty()){
        for (error in errors) {
            println(error) }

        print("Enter your password: ")
        password = readlnOrNull() ?: return println("Enter some password!")
        errors = checkPassword(password)
    }

    println("Your Password is strong!")
}

fun checkPassword(password: String):MutableList<String> {
    val errors = mutableListOf<String>()
    if (!hasNumber(password)){ errors.add("Your password needs at least 1 number.") }
    if (!hasUpper(password)){ errors.add("Your password needs at least 1 upper character.") }
    if (!hasLower(password)){ errors.add("Your password needs at least 1 lower character") }
    if (hasSpace(password)){ errors.add("Your password can't count spaces.") }
    if (!hasSpecialCharacter(password)) { errors.add("Your password needs at least 1 special character") }
    if (!hasMinLength(password)){ errors.add("Your password needs at least 8 characters") }
    return errors
}

fun hasNumber(password: String): Boolean {
   //return password.any { it.isDigit() }  // other option
    val regex = "[0-9]".toRegex()
    return regex.containsMatchIn(password)
}

fun hasSpecialCharacter(password: String): Boolean {
    val regex = "[^a-zA-Z0-9]".toRegex()
    return regex.containsMatchIn(password)
}

fun hasUpper(password: String): Boolean {
    val regex = "[A-Z]".toRegex()
    return regex.containsMatchIn(password)
}

fun hasLower(password: String): Boolean{
    val regex = "[a-z]".toRegex()
    return regex.containsMatchIn(password)
}

fun hasSpace(password: String): Boolean {
    //return password.contains(" ")   // other option
    val regex = "\\s".toRegex()
    return regex.containsMatchIn(password)
}

fun hasMinLength(password: String): Boolean {
    return password.length >= 8
}
