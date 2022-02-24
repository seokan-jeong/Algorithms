import java.math.BigInteger

fun main() {
    // 11057. 오르막 수
    // 오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.
    // 예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.
    // 수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.

    val n = readLine()!!.toInt()
    val array = arrayListOf<ArrayList<BigInteger>>()

    array.add(arrayListOf())
    array.add(arrayListOf())
    for (i in 0..9) {
        array[1].add((10 - i).toBigInteger())
    }

    if (n <= 1) {
        print(array[1][0])
    } else {
        for (i in 2..n) {
            array.add(arrayListOf())
            for (j in 0..9) {
                array[i].add(0.toBigInteger())
                for (k in j..9) {
                    array[i][j] += array[i - 1][k]
                }
            }
        }
        println(array[n][0] % 10007.toBigInteger())
    }

    // Solution
    // 0 -> 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    // 1 -> 1, 2, 3, 4, 5, 6, 7, 8, 9
    // ...
    // 9 -> 9
    // 0만을 예시로 들자면 n=1일 경우 0 하나, n=2일 경우 0의 0, n=3일 경우 0의 0의 0까지 나오게 된다.
    // 그래서 n자리를 구할 경우 n-1자리 배열의 0~9까지의 모든 값을 더하면 된다.
}
