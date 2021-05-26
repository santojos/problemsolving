package matrixmultiplication


fun main(args : Array<String>) {

    //40 * 20
    //20 * 30
    var arr : Array<Int> = arrayOf(10, 20, 30)

    var i = 1
    var j = arr.size - 1

    var ans = solve(i ,j , arr);

    print("Cost is $ans")
}

fun solve(i: Int, j: Int, arr: Array<Int>): Int{

    if(i == j){
        return 0
    }

    var k = i;
    var minCost = Int.MAX_VALUE
    while(k < j  ) {

        var tempCost = solve(i,k, arr) + solve(k+1, j, arr) + arr[i-1] * arr[k] * arr[j]

        if(tempCost  < minCost){
            minCost = tempCost
        }
        k++
    }

    return minCost;
}