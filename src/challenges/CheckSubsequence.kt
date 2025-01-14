package challenges

fun main() {
    println(isSubsequence("openai", "pane")) // false
}

fun isSubsequence(s: String, sub: String): Boolean {
    var i = 0
    var j = 0

    while (i < s.length && j < sub.length) {
        if (s[i] == sub[j]) {
            j++
        }
        i++
    }
    return j == sub.length
}