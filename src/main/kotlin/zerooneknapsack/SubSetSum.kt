package zerooneknapsack

fun main(args: Array<String>) {

    var arr: Array<Int> = arrayOf(3, 34, 4, 12, 5, 2 )
    var sum: Int = 9
    println("Final: "+bool(arr, 5, sum))

}

fun bool(arr: Array<Int>, size: Int, sum: Int): Boolean {

    if(sum ==0 ){
        return  true
    }
    if (size == 0) {
        return false
    }

    println("size: $size | sum : $sum | arr ${arr[size-1]}")

    if (sum >= arr[size - 1]) {

        var res =  (bool(arr, size - 1, sum - arr[size - 1])
                ||
                bool(arr, size - 1, sum)
                )

        println ( "RES : $res")
        return  res

    } else {
        return bool(arr, size - 1, sum)
    }
}