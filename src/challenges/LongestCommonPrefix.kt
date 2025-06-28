package challenges

fun main(){

    val entry = arrayListOf("flower", "flow", "flight")

    println("Welcome to our common prefix identifier!")

    var response = entry[0]

    entry.forEach { i ->
        var j = 0
        var aux = ""

        while (j < i.length && j < response.length && i[j] == response[j]){
            aux += i[j]
            j++
        }
        response = aux
    }

    println(response)
}