fun main() {
    // Problem
    // 하나의 수열에는 다양한 수가 존재한다.
    // 이러한 수는 크기에 상관없이 나열되어 있다.
    // 이 수를 작은 수의 순서로 정렬해야한다.

    val n = readLine()!!.toInt()

    var array = arrayListOf<Int>()
    for (i in 0 until n) {
        array.add(readLine()!!.toInt())
    }

    array.sortDescending()

    for (i in array) {
        print("$i ")
    }

    // Solution
    // 기본적이 정렬
}
