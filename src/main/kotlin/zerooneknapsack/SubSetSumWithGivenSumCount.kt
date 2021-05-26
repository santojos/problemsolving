package zerooneknapsack

/**
Count of subsets sum with a Given sum
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
Example:

Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3
All the possible subsets are {1, 2, 3},
{1, 2, 3} and {3, 3}
 */


fun main(args: Array<String>) {

    var arr: Array<Int> = arrayOf(1, 1, 2, 3)
    var sum = 4
    var tq = Array(arr.size+1) { Array(sum +1) { 0 } }
    var size = arr.size


    //Base Condition
    if (size == 0 || sum == 0) {
        print("Not available")
    }

    //Base Condition initilization
    for (i in tq.indices) {
        for (j in tq[i].indices) {
            if (i == 0 && j == 0) {
                tq[i][j] = 1
            } else {
                if (i == 0) {
                    tq[i][j] = 0
                }
                if (j == 0) {
                    tq[i][j] = 1
                }
            }
        }
    }

        // Implementing Choice Diagram

        for (i in tq.indices) {
            for (j in tq[i].indices) {

                if (i > 0 && j > 0) {
                    if (arr[i-1] > j) {
                        tq[i][j] = tq[i - 1][j]
                    } else {
                        tq[i][j] =  tq[i - 1][j] + tq[i - 1][j - arr[i - 1]]
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

    println("=> ${tq[arr.size][sum]} ")
    }
