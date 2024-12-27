package challenges

fun main(){
    println("Welcome to Roman to Integer application!")
    print("Enter a Roman number: ")

    val romanNumber = readlnOrNull() ?: ""
    val chars = romanNumber.trim().toMutableList()

    try {
        val result = calculate(chars)
        println("$romanNumber in ordinal number is: $result")
    }catch (e: Exception) {
        println("Invalid format! Try again")
    }

}
val romanToInt = mapOf(
    'I' to  1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000
)

fun calculate(chars: MutableList<Char>):Int {
    var result = 0
    var i = 0

    while (i < chars.size) {
        val currentNumber = romanToInt(chars[i])

        if (i + 1 < chars.size && currentNumber < romanToInt(chars[i + 1]) ) {
            result += romanToInt(chars[i + 1]) - currentNumber
            i += 2
        } else {
            result += currentNumber
            i ++
        }
    }
    return result
}

fun romanToInt(char: Char): Int {
    return romanToInt[char]!!
}