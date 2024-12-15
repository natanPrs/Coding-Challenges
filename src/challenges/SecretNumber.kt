package challenges

fun main() {
    val randomNumber = (1..100).random()
    var guessesLeft = 7

    println("Let's play number matching.")

    while (guessesLeft != 0) {
        print("Take a guess: ")
        val guess = readLine()?.toIntOrNull() ?: return println("Enter a valid number!")

        if (guess < 1 || guess > 100) {
            println("Enter a number between 1 and 100! ")
            return
        }
        val range = kotlin.math.abs(guess - randomNumber)
        var clue = ""

        if (range > 50) {
            clue = "Your guess is way off!"
        } else if (range < 10) {
            clue = "Your guess is VERY close!"
        }else if (range < 25) {
            clue = "Your guess is close!"
        } else if (range < 50) {
            clue = "Your guess is way off!"
        }

        if (guess == randomNumber) {
            println("Congratulations, you got it!")
            return
        } else if (guess < randomNumber) {
            println("$clue, it's higher!")
            guessesLeft -= 1
        }else {
            println("$clue, it's lower!")
            guessesLeft -= 1
        }
        if (guessesLeft == 1) {
            println("WATCH OUT, THERE'S ONLY $guessesLeft SHOT LEFT!")
        } else {
            println("$guessesLeft guesses left!")
        }
    }
    println("The number was: $randomNumber")
}
