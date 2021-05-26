import java.lang.Integer.max


fun main(args: Array<String>) {

    var string1 = "ABCDGH"
    var string2 = "AEDFHR"

    var output = "GTAB"
    var n = string1.length
    var m = string2.length

    var dp = Array(n + 1) { Array(m + 1) { -1 } }
    var lcsLength = lcsdp(string1, string2, n, m, dp)

    print("LCS is $lcsLength")

}

fun lcsdp(s1: String, s2: String, n: Int, m: Int, dp: Array<Array<Int>>): Int {

    //Base condition
    if (n == 0 || m == 0) {
        return 0
    }

    // Initialization
    var i = 0
    var j = 0
    for (c1 in s1) {
        for (c2 in s2) {
            if (i == 0 || j == 0) {
                dp[i][j] = 0
            }
            i++
        }
        j++
    }

    for (i in 1..s1.length) {
        for (j in 1..s2.length) {
            if (s1.get(i-1) == s2.get(j-1)) {
                println("${s1.get(i-1)} -- ${s2.get(j-1)} ")
                dp[i][j] = 1 + dp[i - 1][j - 1]
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }

    /*for (c1 in s1) {
        for (c2 in s2) {
            //println("$c1 -- $c2")

                if (i > 0 && j > 0) {
                    if (c1 == c2) {
                        println("$c1 -- $c2")
                        dp[i][j] = 1 + dp[i - 1][j - 1]
                    } else {
                        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
                    }
                }
                j++
            }
        }
        i++
    }*/

    return dp[n][m];
}