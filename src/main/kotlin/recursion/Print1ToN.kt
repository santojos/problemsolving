package recursion


fun main(args: Array<String>) {

    solve(7)
}


fun solve(n: Int) {

    if(n==0){
        return
    }
    solve(n-1);

    println(n)
}