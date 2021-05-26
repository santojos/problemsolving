package zerooneknapsack

var mem = Array(6) { Array(10) { -1 } }

fun main(args: Array<String>) {

    var arr: Array<Int> = arrayOf(3, 34, 4, 12, 5, 2)
    var sum: Int = 9
    println("Final: " + isSubsetSum(arr, 5, sum))

}

fun isSubsetSum(arr: Array<Int>, size: Int, sum: Int): Boolean {

    if (sum == 0) {
        return true
    }
    if (size == 0) {
        return false
    }

    var memVal = mem.get(size - 1).get(sum - 1)

    if (memVal != -1) {
        if (memVal == 0) {
            return true
        }
        return false
    }

    println("size: $size | sum : $sum | arr ${arr[size - 1]}")

    if (sum >= arr[size - 1]) {

        var val1 = (isSubsetSum(arr, size - 1, sum - arr[size - 1]) ||
                isSubsetSum(arr, size - 1, sum))
        var x = 1
        if (val1) {
            x = 0
        }
        mem[size - 1][sum] = x

        return val1

    } else {
        var val1 = isSubsetSum(arr, size - 1, sum)

        var x = 1
        if (val1) {
            x = 0
        }
        mem[size - 1][sum] = x
        return val1
    }
}