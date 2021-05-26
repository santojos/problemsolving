import java.lang.Integer.max


fun main(args: Array<String>) {

    var string1 = "AGGTAB"
    var string2 = "GXTXAYB"
    var output = "GTAB"

    var n = 7
    var m = 8

    var dp = Array(n + 1) { Array(m + 1) { -1 } }

    var lcsLength = lcsmemoize(string1, string2, n, m, dp)

    print("LCS is $lcsLength")
}

fun lcsmemoize(s1: String, s2: String, n: Int, m: Int, dp: Array<Array<Int>>): Int {

    //Base condition
    if (n == 0 || m == 0) {
        return 0
    }

    if (dp[n][m] != -1) {
        return dp[n][m];
    }
    //Choice diagram

    //matches
    if (s1.get(n - 1) == s2.get(m - 1)) {
        dp[n][m] = 1 + lcs(s1, s2, n - 1, m - 1)
        return dp[n][m]
    } else {
        //not matches

        dp[n][m] = max(

            lcs(s1, s2, n, m - 1),
            lcs(s1, s2, n - 1, m)
        )
        return dp[n][m];
    }
}