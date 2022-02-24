fun main() {
    // 3273. 두 수의 합
    // n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다.
    // ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다.
    // 자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.

    val n = readLine()!!.toInt()
    val array = arrayListOf<Int>()
    readLine()!!.split(' ').map { array.add(it.toInt()) }
    val x = readLine()!!.toInt()

    // 오름차순 정렬
    array.sort()

    var count = 0   // 개수 세기
    var start = 0
    var end = n - 1
    while (start < end) {
        val sum = array[start] + array[end]
        if (sum == x) {
            count++
        }

        if (sum <= x) {
            start++
        } else {
            end--
        }
    }

    // 아래와 같이 풀면 시간초과 남. (시간복잡도 O(N^2))
//    for (i in 0 until n) {
//        if (array[i] > x) {  // x보다 크면 어차피 다른 수와 더해도 의미 없기 때문에
//            break
//        }
//        for (j in (i + 1) until n) {
//            if (array[i] + array[j] > x) {   // x보다 크면 어차피 다른 수와 더해도 의미 없기 때문에
//                break
//            }
//            if (array[i] + array[j] == x) {
//                count++
//            }
//        }
//    }

    print(count)

    // Solution
    // 이중 반복문을 사용했더니 시간복잡도 O(N^2)으로 시간초과가 발생했다.
    // 그래서 반복문을 하나만 사용하여 수열 중 가장 작은 숫자와 가장 큰 숫자에 대한
    // 범위를 좁혀나가면서 계산하는 방법으로 해결했다.
}
