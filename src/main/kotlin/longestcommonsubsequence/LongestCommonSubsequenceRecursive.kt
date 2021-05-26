import java.lang.Integer.max

fun main(args: Array<String>) {

    var string1 = "AGGTAB"
    var string2 = "GXTXAYB"
    var output = "GTAB"

    var n = 6
    var m = 7

    var lcsLength = lcs(string1, string2, n, m)

    print("LCS is $lcsLength")
}

fun lcs(s1: String, s2: String, n: Int, m: Int): Int {

    //Base condition
    if (n == 0 || m == 0) {
        return 0
    }

    //Choice diagram

    //matches
    if (s1.get(n - 1) == s2.get(m - 1)) {
        return 1 + lcs(s1, s2, n - 1, m - 1)
    } else {
        //not matches
        return max(
            lcs(s1, s2, n, m - 1),
            lcs(s1, s2, n - 1, m)
        )
    }
}