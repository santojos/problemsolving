package longestcommonsubsequence

import java.lang.Integer.max

//00:54
fun main(args: Array<String>) {

    var str1 = "AABEBCDD"
    var str2 = str1

    var n = str1.length
    var m = str2.length

    var dp = Array(n + 1) { Array(m + 1) { -1 } }


    var op =""
    for( i in dp.indices){
        for(j in dp.get(i).indices){
            if(i == 0  || j ==0) {
                dp[i][j] = 0
            }else{

                if(str1.get(i-1) == str2.get(j-1) && i !=j ) {
                    dp[i][j] = 1 + dp[i-1][j-1]
                    op = op.plus(str1.get(i-1))
                }else{
                    dp[i][j] = max(dp[i][j-1], dp[i-1][j])
                }
            }
        }
    }


    for( i in dp.indices) {
        println(" ")
        for (j in dp.get(i).indices) {
            print("dp[$i][$j] :  ${dp.get(i).get(j)}  ")
        }
    }

    println(" ")
    println("Sring is $op")




}
