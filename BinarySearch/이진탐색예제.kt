fun main() {
    // 이진 탐색
    fun binary_search(array: ArrayList<Int>, target: Int, start: Int, end: Int): Int {
        if (start > end) {
            return Int.MAX_VALUE
        }
        val mid = (start + end) / 2

        if (array[mid] == target) {
            return mid
        } else if (array[mid] > target) {
            return binary_search(array, target, start, mid - 1)
        } else {
            return binary_search(array, target, mid + 1, end)
        }
    }

    var input = readLine()!!.split(' ').map { it.toInt() }
    val n = input[0]
    val target = input[1]

    input = readLine()!!.split(' ').map { it.toInt() }
    val array = arrayListOf<Int>()
    for (i in input) {
        array.add(i)
    }

    var result = binary_search(array, target, 0, n - 1)
    if (result == Int.MAX_VALUE) {
        print("원소가 존재하지 않습니다.")
    } else {
        print(result + 1)
    }
}
