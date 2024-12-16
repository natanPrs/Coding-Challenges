package challenges

fun main() {
    println("Welcome to User Generator!")
    println("How many Users do you want to generate today?")
    val numberUsers = readLine()?.toIntOrNull() ?: return println("Enter a valid number!")

    val users = (1..numberUsers).map {
        val name = generateName()
        User(
            name = name,
            age = generateAge(),
            email = generateEmail(name)
        )
    }

    users.forEachIndexed { index, user ->
        println("User ${index + 1}: Name: ${user.name}, Age: ${user.age} , Email: ${user.email}")
    }

}
data class User(val name: String, val age: Int, val email: String)

val names = listOf("Natan", "Daniel", "John", "Mike", "Dexter")
val surnames = listOf("Morgan", "Pires", "Little", "Smith", "Cooper")

val generateName: () -> String = {
    val firstName = names.random()
    val lastName = surnames.random()
    "$firstName $lastName"
}

val generateAge: () -> Int = {
    (18..60).random()
}

val generateEmail: (String) -> String = {
    name -> name.lowercase().replace(" ", ".") + "@email.com"
}

