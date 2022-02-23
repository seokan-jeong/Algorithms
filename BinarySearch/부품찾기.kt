fun main() {
    // Problem
    // 세오칸의 전자 매장에는 부품이 N개 있다. 각 부품은 정수 형태의 고유한 번호가 있다.
    // 어느 날 손님이 M개 종류의 부품을 대량으로 구매하겠다며 당일 날 견적서를 요청했다.
    // 세오칸은 때를 놓치지 않고 손님이 문의한 부품 M개 종류를 모두 확인해서 견적서를 작성해야 한다.
    // 이 때 가게 안에 부품이 모두 있는지 확인하라.

    fun binary_search(array: ArrayList<Int>, target: Int, start_input: Int, end_input: Int): Int {
        var start = start_input
        var end = end_input

        while (start <= end) {
            val mid = (start + end) / 2
            // 찾은 경우 중간점 인덱스 반환
            if (array[mid] == target) {
                return mid
            } else if (array[mid] > target) {  // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
                end = mid - 1
            } else if (array[mid] < target) {  // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
                start = mid + 1
            }
        }
        return Int.MAX_VALUE
    }

    val n = readLine()!!.toInt()
    val array = arrayListOf<Int>()
    readLine()!!.split(' ').map { array.add(it.toInt()) }
    array.sort()    // 이진 탐색을 수행하기 위해 사전에 정렬

    val m = readLine()!!.toInt()
    val x = arrayListOf<Int>()
    readLine()!!.split(' ').map { x.add(it.toInt()) }

    // 손님이 확인 요청한 부품 번호를 하나씩 확인
    for (i in x) {
        // 해당 부품이 존재하는지 확인
        val result = binary_search(array, i, 0, n - 1)
        if (result != Int.MAX_VALUE) {
            print("yes ")
        } else {
            print("no ")
        }
    }

    // Solution
    // 매장에 있는 제품 중 손님이 제시한 제품이 있는지 이진탐색을 이용하여 탐색함.
}
