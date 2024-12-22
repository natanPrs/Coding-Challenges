package challenges

fun main () {
    val expression = "2 + 3 * 5 + 1"
    val result = calculate(expression)
    println("Result: $result")

}

fun calculate(expression: String): Int {
    val tokens = tokenize(expression.replace(" ", ""))
    val result = handleExpression(tokens)
    return result
}

fun tokenize(expression: String): MutableList<String> {
    val regex = """(\d+(\.\d+)?|[+\-*/()])""".toRegex()
    return regex.findAll(expression).map { it.value }.toMutableList()
}

fun handleExpression(tokens: MutableList<String>): Int {
    val afterMultiplication = handleMultiplicationAndDivision(tokens)
    val result = handleAdditionAndSubtraction(afterMultiplication)
    return result
}

fun handleMultiplicationAndDivision(tokens: MutableList<String>): MutableList<String> {
    val newTokens = mutableListOf<String>()
    var currentNumber = tokens.removeAt(0).toInt()

    while (tokens.isNotEmpty()) {
        val operator = tokens.removeAt(0)
        val nextNumber = tokens.removeAt(0).toInt()

        if (operator == "*") {
            currentNumber *= nextNumber
        } else if (operator == "/") {
            currentNumber /= nextNumber
        }else {
            newTokens.add(currentNumber.toString())
            newTokens.add(operator)
            currentNumber = nextNumber
        }
    }
    newTokens.add(currentNumber.toString())
    return newTokens
}

fun handleAdditionAndSubtraction(tokens: MutableList<String>): Int {
    var result = tokens.removeAt(0).toInt()

    while (tokens.isNotEmpty()) {
        val operator = tokens.removeAt(0)
        val nextNumber = tokens.removeAt(0).toInt()

        if (operator == "+") {
            result += nextNumber
        } else if (operator == "-") {
            result -= nextNumber
        }
    }
    return result
}