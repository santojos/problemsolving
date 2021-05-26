package longestcommonsubsequence

import java.lang.Integer.max

//22.56
//23.07


fun main(args: Array<String>) {

    var str1 = "geeksforgeeks"
    var str2 = "geeks"

    var n = str1.length
    var m = str2.length

    var dp = Array(n + 1) { Array(m + 1) { -1 } }

    var lcsLength = findLCS(str1, n, str2, m, dp)

    var del = n - lcsLength
    var ins = m - lcsLength

    println("Min Del : $del")
    println("Min Ins : $ins")
}

fun findLCS(str1: String, n: Int, str2: String, m: Int, dp: Array<Array<Int>>): Int {

    //Base condition
    if (n == 0 || m == 0) {
        return 0
    }

    for (i in dp.indices) {
        for (j in dp.get(i).indices) {

            //base condition
            if (i == 0 || j == 0) {
                dp[i][j] = 0
            } else {

                if (str1.get(i - 1) == str2.get(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                } else {
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
                }
            }
        }
    }
    return dp[n][m];
}
