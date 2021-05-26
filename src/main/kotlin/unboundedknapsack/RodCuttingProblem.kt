package unboundedknapsack

import java.util.function.Consumer


fun main(args: Array<String>) {

    /**
     * length   | 1   2   3   4   5   6   7   8
     * price    | 1   5   8   9  10  17  17  20
     * OP = 22
     */


    var lengthArray: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    var priceArray: Array<Int> = arrayOf(1, 5, 8, 9, 10, 17, 17, 20)
    var output = 22
    var rodLength = 8;

    var dp = Array(lengthArray.size+1) { Array(rodLength + 1) { -1 } }

    //Base Condition
    if(lengthArray.size == 0 || rodLength == 0){
        return
    }

    for (i in dp.indices) {
        for (j in dp[i].indices) {
            if (i == 0 || j == 0) {
                dp[i][j] = 0
            }
        }
    }

    //Choice diagram

    for (i in dp.indices) {
        for (j in dp[i].indices) {
            if (i > 0 && j > 0) {

                if(lengthArray[i-1] <= j ){
                    dp[i][j] = maxOf( dp[i-1][j],  dp[i][j - lengthArray[i-1]]  + priceArray[i-1] )
                }else{
                    dp[i][j] = dp[i-1][j]
                }

            }
        }
    }

    /*for (i in dp.indices) {
        for (j in dp[i].indices) {
            println("dp[$i][$j] = ${dp[i][j]} ")
        }
    }*/

    print("Output is : " )
    println("dp[${lengthArray.size}][$rodLength] = ${dp[lengthArray.size][rodLength]} ")
}