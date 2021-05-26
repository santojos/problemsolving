object EggDropProblemRecursive {
    @JvmStatic
    fun main(args: Array<String>) {

        val floor = 4
        val egg = 2
        val output = 8
        val minfloor = eggDrop(egg, floor)
        println("Min Floor are : $minfloor")
    }

    fun eggDrop(e: Int, f: Int): Int {

        println("$e  : $f ")
        //Base condition
        if (f == 0 || f == 1) {
            return f
        }
        if (e == 0) {
            return f
        }
        var k = 1
        var max = Int.MAX_VALUE
        while (k <= f) {
            //Two condition
            //a breaks :
            // b does not break
           // println("$e  : $k : $f ")
            val t = 1 + Math.max(eggDrop(e - 1, k - 1), eggDrop(e, f - k))
            max = Math.min(t, max)
            k += 1
        }
        return max
    }
}