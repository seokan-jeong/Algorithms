fun main() {
    // 5052. 전화번호 목록
    // 전화번호 목록이 주어진다. 이때, 이 목록이 일관성이 있는지 없는지를 구하는 프로그램을 작성하시오.
    // 전화번호 목록이 일관성을 유지하려면, 한 번호가 다른 번호의 접두어인 경우가 없어야 한다.
    // 예를 들어, 전화번호 목록이 아래와 같은 경우를 생각해보자
    // 긴급전화: 911
    // 상근: 97625999
    // 선영: 91125426
    // 이 경우에 선영이에게 전화를 걸 수 있는 방법이 없다. 전화기를 들고 선영이 번호의 처음 세 자리를 누르는 순간 바로 긴급전화가 걸리기 때문이다. 따라서, 이 목록은 일관성이 없는 목록이다.

    val t = readLine()!!.toInt()
    val result = arrayListOf<String>()
    for (testCase in 0 until t) {
        val n = readLine()!!.toInt()
        val array = arrayListOf<String>()
        (0 until n).map { array.add(readLine()!!) }

        array.sort()
        var check = false
        for (i in 0 until n - 1) {
            if (array[i + 1].startsWith(array[i])) {
                check = true
                break
            }
        }
        if (check) {
            result.add("NO")
        } else {
            result.add("YES")
        }
    }

    for (i in result) {
        println(i)
    }

    // Solution
    // 처음에는 배열 전체에서 한 원소를 접두어로 포함하고 있는지 검색하였는데
    // 시간초과가 발생하여
    // 정렬된 문자열 배열임을 고려하여 바로 옆 원소가 그 전 원소를 접두어로 포함하는지만
    // 확인하였다.
}
