package zerooneknapsack

/**
 * Problem Statement
 * https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbTFjVDZ0Z3BsbHB2N3gwWGxueG94aktxVUV2QXxBQ3Jtc0treU1haWJDenRXeWQzazExVHJVV2VhODZDbHh5QUxVN2Zpck9pcmhYOTY0VEZRRk9DN18xQmIwZG10bjVkSzVTWVBPbmFkMTJnRmpoc0plS2xlNXVUU05SN0dsVGJ0X1VTRWhfUEpDVFVYa2NoQzRKYw&q=https%3A%2F%2Fwww.geeksforgeeks.org%2Fpartition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum%2F
 */
// 10.33
// 11.07

fun main(args: Array<String>) {

    var arr: Array<Int> = arrayOf(1, 6, 11, 5)
    var output = 1
    var sum = arr.sum()

    //subset set
    // create bottom up metrics similar to subset sum
    var tq = Array(arr.size + 1) { Array(sum + 1) { -1 } }
    subSetSum(arr, 5, tq)

    // pick the last row, and try to minimize the sum
    // 1 + 6 + 11 + 5 ==> 23
    //Range is {0  23}
    // Min difference should lie in between 0  to 23 and ideally in midway
    var n = arr.size
    for (j in tq[n].indices.reversed()) {

        if (j <= sum / 2) {
            if (tq[n][j] == 0) {
                println("tq[$n][$j]} :  ${tq[n][j]} ")
                print("{ $j and ${sum.minus(j)} } ")
                break
            }
        }
    }
}

fun subSetSum(arr: Array<Int>, size: Int, tq: Array<Array<Int>>) {

    //Base condition
    if (size == 0) {
        return
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

    // Choice diagram
    for (i in tq.indices) {
        for (j in tq[i].indices) {

            if (i > 0 && j > 0) {

                if (arr[i - 1] <= j) {

                    //Not included
                    var inc = tq[i - 1][j - arr[i - 1]]
                    var notInc = tq[i - 1][j]

                    if (inc == 0 || notInc == 0) {
                        tq[i][j] = 0
                    } else {
                        tq[i][j] = 1
                    }

                } else {
                    tq[i][j] = tq[i - 1][j]
                }
            }
        }
    }
}

