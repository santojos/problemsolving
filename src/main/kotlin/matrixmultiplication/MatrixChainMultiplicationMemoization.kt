package matrixmultiplication


fun main(args: Array<String>) {

    //40 * 20
    //20 * 30
    var arr: Array<Int> = arrayOf(40, 20, 30, 10, 30)

    var i = 1
    var j = arr.size - 1
    var globalArr = Array(arr.size) { Array(arr.size) { -1 } }

    var ans = solveMemoize(i, j, arr, globalArr);

    print("Cost is $ans")
}

fun solveMemoize(i: Int, j: Int, arr: Array<Int>, globalArr: Array<Array<Int>>): Int {

    if (i == j) {
        return 0
    }

    if (globalArr.get(i).get(j) == -1) {

        var k = i;
        var minCost = Int.MAX_VALUE
        while (k < j) {

            var p1 = globalArr.get(i).get(k)
            var p2 = globalArr.get(k + 1).get(j)

            if (p1 == -1) {
                p1 = solve(i, k, arr)
                globalArr[i][k] = p1
            } else {
                print("p1 $i $k");
            }

            if (p2 == -1) {
                p2 = solve(k + 1, j, arr)
                globalArr[k + 1][j] = p2
            } else {
                print("p1 $k+1 $j");
            }
            var tempCost = p1 + p2 + arr[i - 1] * arr[k] * arr[j]

            if (tempCost < minCost) {
                minCost = tempCost
            }
            k++
        }

        globalArr[i][j] = minCost
        return minCost;
    } else {

        return globalArr[i][j]
    }
}