import java.lang.Integer.min

fun main(args: Array<String>) {

    //str1 = "AGGTAB",  str2 = "GXTXAYB"

    var str1 = "Hello"
    var str2 = "Geeek"

    var n = str1.length
    var m = str2.length

    var dp = Array(n + 1) { Array(m + 1) { -1 } }


    //base conditions
    if (n == 0 || m == 0) {
        print("SCS is 0")
    } else if (n == 0 && m > 0) {
        print("SCC is $m")
    } else if (m == 0 && n > 0) {
        print("SCC is $n")
    } else {

        for (i in dp.indices) {
            for (j in dp.get(i).indices) {
                if (j == 0) {
                    dp[i][j] = i
                }
                if (i == 0) {
                    dp[i][j] = j
                }
            }
        }

        for (i in dp.indices) {
            for (j in dp.get(i).indices) {

                if (i > 0 && j > 0) {
                    if (str1.get(i - 1) == str2.get(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1]
                    } else {
                        dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j])
                    }
                }
            }
        }
    }

    for (i in dp.indices) {
        for (j in dp.get(i).indices) {
            print("   ${dp.get(i).get(j)}")
        }
        println("")
    }
    println("Length is  ${dp.get(n).get(m)}")


    var i = n
    var j = m
    var str = ""


    while (j > 0 && j > 0) {

        if (str1.get(i - 1) == str2.get(j - 1)) {
            str = str.plus(str1[i-1])
            i--
            j--
        } else {

            if (dp[i - 1][j] > dp[i][j - 1]) {
                str = str.plus(str1[i - 1])
                i--
            } else {
                str = str.plus(str2[j - 1])
                j--
            }
        }

    }
    println("I is $i and j is $j")

    while (i > 0) {
        str = str.plus(str1[i - 1])
        i--
    }


    while (j > 0) {
        str = str.plus(str2[j - 1])
        j--
    }


    println("Str is ${str.reversed()}")

}

