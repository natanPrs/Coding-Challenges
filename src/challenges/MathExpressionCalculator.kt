package challenges

fun main () {
    val expression = "2 + 3 * 4"
    val result = calculate(expression)
    println("Result: $result")

}

fun calculate(expression: String): Int {
    val tokens = tokenize(expression.replace(" ", ""))
    val  tokensAfterMultiplication = handleMultiplicationAndDivision(tokens)
    val result = handleAdditionAndSubtraction(tokensAfterMultiplication)
    return result
}

fun tokenize(expression: String): MutableList<String> {
    val regex = """(\d+(\.\d+)?|[+\-*/()])""".toRegex()
    return regex.findAll(expression).map { it.value }.toMutableList()
}

fun handleMultiplicationAndDivision(tokens: MutableList<String>): MutableList<String> {
    var result = handleAdditionAndSubtraction(tokens)

    while (tokens.isNotEmpty() && tokens[0] == "*" || tokens[0] == "/") {
        val operator = tokens.removeAt(0)
        val nextNumber = tokens.removeAt(0).toInt()
        result = if (operator == "*") result * nextNumber else result / nextNumber
    }
    return result
}

fun handleAdditionAndSubtraction(tokens: MutableList<String>): Int {
    var token = tokens.removeAt(0).toInt()

    while (tokens.isNotEmpty() && tokens[0] == "+" || tokens[0] == "-") {
        val operator = tokens.removeAt(0)
        val nextNumber = tokens.removeAt(0).toInt()
        token = if (operator == "+") token + nextNumber else token - nextNumber
    }
    return token
}