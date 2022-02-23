fun main() {
    // 순차 탐색
    fun sequential_search(n: Int, target: String, array: ArrayList<String>): Int {
        for (i in 0 until n) {
            if (array[i] == target) {
                return i + 1
            }
        }
        return 0
    }

    print("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.")
    var input = readLine()!!.split(' ')
    val n = input[0].toInt()
    val target = input[1]

    print("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.")
    input = readLine()!!.split(' ')
    var array = arrayListOf<String>()
    for (i in input) {
        array.add(i)
    }

    print(sequential_search(n, target, array))
}
