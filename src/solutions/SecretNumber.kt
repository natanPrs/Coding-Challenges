package solutions
/*  IMPROVEMENTS:
        - FIXED A LOGIC BUG IN "clue".
        - BETTER MESSAGES FOR USER.
        - REMOVED UNNECESSARY RETURNS
        - I ADDED THE "DIRECTION" VARIABLE TO BETTER ORGANIZE THE CODE */

fun main() {
    val randomNumber = (1..100).random()
    var guessesLeft = 7

    println("Let's play number matching.")

    while (guessesLeft > 0) {
        print("Take a guess: ")
        val guess = readLine()?.toIntOrNull() ?: return println("Enter a valid number!")

        if (guess < 1 || guess > 100) {
            println("Enter a number between 1 and 100!")
            continue
        }

        val range = kotlin.math.abs(guess - randomNumber)

        val clue = when {
            range >= 50 -> "Your guess is way off!"
            range in 25..49 -> "Your guess is off!"
            range in 10..24 -> "Your guess is close!"
            else -> "Your guess is VERY close"
        }

        if (guess == randomNumber) {
            println("Congratulations, you got it! The number was $randomNumber!")
            return
        } else {
            guessesLeft -= 1
            val direction = if (guess < randomNumber) "it's higher!" else "it's lower!"
            println("$clue, $direction")
        }

        if (guessesLeft == 1) {
            println("WATCH OUT, THERE'S ONLY 1 SHOT LEFT!")
        } else if (guessesLeft > 0) {
            println("$guessesLeft guesses left!")
        }
    }

    println("Game over! The correct number was $randomNumber. Better luck next time!")
}