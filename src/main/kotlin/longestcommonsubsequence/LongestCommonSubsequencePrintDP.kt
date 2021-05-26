import java.lang.Integer.max


fun main(args: Array<String>) {

    var string1 = "GEEKSFORGEEKS"
    var string2 = "GEEKS"

    var n = string1.length
    var m = string2.length

    var dp = Array(n + 1) { Array(m + 1) { -1 } }

    var lcsLength = lcsdpprint(string1, string2, n, m, dp)

    for (i in dp.indices) {
        for (j in dp.get(i).indices) {
            print("   ${dp.get(i).get(j)}")
        }
        println("")
    }

    var i = string1.length
    var j = string2.length

    var str=""
    while (i >= 0) {
        if(i == 0 || j == 0 ){
            break;
        }
        while (j > 0) {

            if (string1.get(i-1) == string2.get(j-1)) {
                str = str.plus(string1.get(i-1))
                i = i.dec()
                j = j.dec()
            } else {

                var k = dp[i - 1][j]
                var l = dp[i][j - 1]
                if (k >= l) {
                    i = i.dec()
                } else {
                    j = j.dec()
                }
            }
        }
    }
    print("String is ${str.reversed()}")
}

fun lcsdpprint(s1: String, s2: String, n: Int, m: Int, dp: Array<Array<Int>>) {

    //Base condition
    if (n == 0 || m == 0) {
        return
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

            if (s1.get(i - 1) == s2.get(j - 1)) {
                println("${s1.get(i - 1)} -- ${s2.get(j - 1)} ")
                dp[i][j] = 1 + dp[i - 1][j - 1]
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
}