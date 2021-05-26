package matrixmultiplication


fun main(args: Array<String>) {

    var str = "aba"

    var i = 0
    var j = str.length -1

    var ans = solvePalindrome(str, i, j)

    print("ans is $ans")

}

fun solvePalindrome(str: String, i: Int, j: Int): Int {

    var k = i;

    if (isPalindrome(str, i, j)) {
        return 0
    } else {

        var minCost = Int.MAX_VALUE
        while (k < j) {

            var tempCost = solvePalindrome(str, i, k) + solvePalindrome(str, k + 1, j) + 1

            if (tempCost < minCost) {
                minCost = tempCost
            }
            k++
        }
        return minCost
    }
}


fun isPalindrome(str: String, ii: Int, jj: Int): Boolean {

    var i = ii
    var j = jj

    while (i < j) {

        if (str.get(i) != str.get(j)) {
            return false
        }
        i++
        j--
    }
    return true
}