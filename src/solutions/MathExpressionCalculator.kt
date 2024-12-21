package solutions

import java.beans.Expression

fun main() {
    println("Welcome to Math Expression Calculator!")

    do {
        print("Enter your expression: ")
        val expression = readlnOrNull() ?: ""

        try {
            val result = calculate(expression)
            println("Result: $result")
        }catch (e: Exception){
            println("Invalid Expression! Try again.")
        }

        print("Deseja calcular outra expressão? (sim/nao): ")
    } while (readlnOrNull()?.lowercase() == "yes")

    println("See ya!")
}

fun calculate(expression: String): Any {
    val tokens = tokenize(expression)
    val result = parseExpression(tokens)
}

fun tokenize(expression: String): MutableList<String> {
    val regex = """(\d+(\.\d+)?|[+\-*/()])""".toRegex()
    return regex.findAll(expression).map { it.value }.toMutableList()
}

fun parseExpression(tokens: MutableList<String>): Double {
    return parseTerm(tokens)
}

fun parseTerm(tokens: MutableList<String>): Double {
    var result = parseFactor(tokens)
}

fun parseFactor(tokens: MutableList<String>): Any {
    var result = parsePrimary(tokens)
}

fun parsePrimary(tokens: MutableList<String>): Any {
    if (tokens.isEmpty()) throw Exception("Invalid Expression")

    val token = tokens.removeAt(0)
    return when {
        token == "(" -> {
            val result = parseExpression(tokens)
            if (tokens.isEmpty() || tokens[0] != ")") {
                throw Exception("Error with the parentheses")
            }
            result
        }
        token
    }
}
