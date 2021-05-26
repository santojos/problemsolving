package unboundedknapsack

fun main(args: Array<String>) {

    /**
     * length   (1   2   3 )
     * Sum = 4
     */


    var coinArray: Array<Int> = arrayOf(1, 2, 3)
    var sum = 4
    var coinsSize = coinArray.size
    var dp = Array(coinsSize+1) { Array(sum + 1) { -1 } }

    //Base Condition
    if(coinArray.size == 0 || sum == 0){
        return
    }

    for (i in dp.indices) {
        for (j in dp[i].indices) {
            if (i == 0) {
                dp[i][j] = 0
            }

            if( j == 0){
                dp[i][j] = 1
            }
        }
    }

    //Choice diagram

    for (i in dp.indices) {
        for (j in dp[i].indices) {
            if (i > 0 && j > 0) {

                if(coinArray[i-1] <= j ){
                    dp[i][j] = ( dp[i-1][j] +   dp[i][j - coinArray[i-1]] )
                }else{
                    dp[i][j] = dp[i-1][j]
                }

            }
        }
    }

    for (i in dp.indices) {
        for (j in dp[i].indices) {
            println("dp[$i][$j] = ${dp[i][j]} ")
        }
    }

    print("Output is : " )
    println("dp[${coinsSize}][$sum] = ${dp[coinsSize][sum]} ")
}