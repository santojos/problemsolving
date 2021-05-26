package longestcommonsubsequence

import java.lang.Integer.max


/**
 * Input : X = “GeeksforGeeks”, Y = “GeeksQuiz”
Output : 5


X = “GeeksforGeeks”,
Y = “GeeksQuiz”

length = 0
if (a = b) {
ok  length
}


 */

fun main(args: Array<String>) {

    var string1 = "abcde"
    var string2 = "ababcde"
    var output = "GTAB"

    var n = string1.length
    var m = string2.length

    var dp = Array(n + 1) { Array(m + 1) { -1 } }

    var lcsLength = substringDP(string1, string2, n, m, dp)

    print("LCS is $lcsLength")
}

fun substringDP(s1: String, s2: String, n: Int, m: Int, dp: Array<Array<Int>>): Int {

    //Base condition
    if (n == 0 || m == 0) {
        return 0
    }

    // Initialization
    for (i in 0..s1.length) {
        for (j in 0..s2.length) {
            if (i == 0 || j == 0) {
                dp[i][j] = 0
            }
        }
    }

    var i = 0
    var j = 0
    var result = 0
    for (i in 1..s1.length) {
        for (j in 1..s2.length) {

            if (s1.get(i - 1) == s2.get(j - 1)) {
                println("${s1.get(i - 1)} -- ${s2.get(j - 1)} ")
                dp[i][j] = 1 + dp[i - 1][j - 1]
                result = max(result, dp[i][j]);
            } else {
                dp[i][j] = 0 // Integer.max(dp[i - 1][j], dp[i][j - 1])
            }
        }

    }

    var l = 0
    for (i in 1..s1.length) {
        for (j in 1..s2.length) {

            if(l <= dp[i][j] ){
                l = dp[i][j]
            }
        }
    }

    println("dp is ${dp.get(n).get(m)}")
    return  result
}
