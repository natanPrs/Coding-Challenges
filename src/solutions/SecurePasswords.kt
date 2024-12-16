package solutions

/*  IMPROVEMENTS:
        - I USED LAMBDA
*/

fun main() {
    println("Welcome to our Secure Password checker!")
    print("Enter your password: ")
    var password = readlnOrNull() ?: return println("Enter some password!")
    var errors = checkPassword(password)

    while (errors.isNotEmpty()) {
        errors.forEach { println(it) }

        print("Enter your password: ")
        password = readlnOrNull() ?: return println("Enter some password!")
        errors = checkPassword(password)
    }
    println("Your password is Strong!")
}


val rules = listOf<(String) -> String?> (
    { password -> if (!hasNumber(password)) "Your password needs at least 1 number." else null},
    { password -> if (!hasUpper(password)) "Your password needs at least 1 upper character." else null },
    { password -> if (!hasLower(password)) "Your password needs at least 1 lower character." else null},
    { password -> if (hasSpace(password)) "Your password can't count spaces." else null},
    { password -> if (!hasSpecialCharacter(password)) "Your password needs at least 1 special character." else null},
    { password -> if (!hasMinLength(password)) "Your password needs at least 8 characters" else null}

)

fun checkPassword(password: String): List<String> {
    return rules.mapNotNull { it(password) }
}

fun hasSpace(password: String): Boolean {
    return password.contains(" ")
}

fun hasMinLength(password: String): Boolean {
    return password.length >= 8
}

fun hasSpecialCharacter(password: String): Boolean {
    val  regex = "[^a-zA-Z0-9]".toRegex()
    return regex.containsMatchIn(password)
}

fun hasUpper(password: String): Boolean {
    val regex = "[A-Z]".toRegex()
    return regex.containsMatchIn(password)
}

fun hasLower(password: String):Boolean {
    val regex = "[a-z]".toRegex()
    return regex.containsMatchIn(password)
}

fun hasNumber(password: String): Boolean {
    return password.any { it.isDigit() }
}