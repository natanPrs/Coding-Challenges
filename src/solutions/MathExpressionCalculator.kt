package solutions

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
    val tokens = tokenize(expression.replace(" ", ""))
    val result = parseExpression(tokens)
    return result
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

    while (tokens.isNotEmpty() && (tokens[0] == "+" || tokens[0] == "-")) {
        val operator = tokens.removeAt(0)
        val nextNumber = parseFactor(tokens)

        result = if (operator == "+") result + nextNumber else result - nextNumber
    }
    return result
}

fun parseFactor(tokens: MutableList<String>): Double {
    var result = parsePrimary(tokens)

    while (tokens.isNotEmpty() && (tokens[0] == "*" || tokens[0] == "/")){
        val operator = tokens.removeAt(0)
        val nextNumber = parsePrimary(tokens)

        result = if (operator == "*") result * nextNumber else result / nextNumber
    }
    return result
}

fun parsePrimary(tokens: MutableList<String>): Double {
    if (tokens.isEmpty()) throw Exception("Invalid Expression")

    val token = tokens.removeAt(0)
    return when {
        token == "(" -> {
            val result = parseExpression(tokens)
            if (tokens.isEmpty() || tokens.removeAt(0) != ")") {
                throw Exception("Parenthesis error!")
            }
            result
        }
        token.matches(Regex("""-?\d+(\.\d+)?""")) -> token.toDouble()
        else -> throw Exception("Invalid Token: $token")
    }
}
