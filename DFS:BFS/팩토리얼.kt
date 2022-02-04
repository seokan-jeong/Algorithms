fun main() {
    println("반복적으로 구현 : ${factorial_iterative(5)}")
    println("재귀적으로 구현 : ${factorial_recursive(5)}")
}

fun factorial_iterative(n: Int): Int {
    var result = 1

    for(i in 1..n){
        result *= i
    }
    return result
}

fun factorial_recursive(n: Int): Int {
    if(n <= 1)
        return 1
    return n * factorial_recursive(n - 1)
}
