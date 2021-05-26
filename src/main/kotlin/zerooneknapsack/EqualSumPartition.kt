package zerooneknapsack

fun main(args: Array<String>) {

    var arr: Array<Int> = arrayOf(2, 5, 11, 8)
    var sum: Int = arr.sum()
    println("Sum is $sum : ${sum % 2}")

    if (sum % 2 == 0) {
        var tq = Array(arr.size+1) { Array(sum / 2 + 1) { -1 } }
        equalSumPartition(arr, arr.size, sum / 2, tq)

        println("tq is ${tq[arr.size][sum / 2]} ")

    } else {
        println("No Equals Sum Partition available")
    }


}

/**
 * 0  Exists
 * 1  Does not exists
 * -1 initialized
 * t [size][sum]
 */
fun equalSumPartition(arr: Array<Int>, size: Int, sum: Int, tq: Array<Array<Int>>): Int {

    //Base Condition
    if (size == 0) {
        return -1
    }

    if (sum == 0) {
        return 0
    }

    //Base Condition initil
    for (i in tq.indices) {
        for (j in tq[i].indices) {
            if (i == 0) {
                tq[i][j] = 1
            }
            if (j == 0) {
                tq[i][j] = 0
            }
        }
    }

    // Implementing Choice Diagram

    for (i in tq.indices) {
        for (j in tq[i].indices) {

            if (i > 0 && j > 0) {

                if (arr[i - 1] <= j) {

                    var a1 = tq[i - 1][j]
                    var a2 = tq[i - 1][j - arr[i - 1]]

                    if (a1 == 0 || a2 == 0) {
                        tq[i][j] = 0
                    } else
                        tq[i][j] = 1
                } else {
                    //not included
                    tq[i][j] = tq[i - 1][j]
                }
            }

        }
    }

    println("initialized")
    for (i in tq.indices) {
        for (j in tq[i].indices) {
            println("tq[$i][$j] = ${tq[i][j]} ")
        }
    }

    return -1

}