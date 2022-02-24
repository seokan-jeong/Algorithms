fun main() {
    // 9461. 파도반 수열
    // 삼각형이 나선 모양으로 놓여져 있다. 첫 삼각형은 정삼각형으로 변의 길이는 1이다.
    // 그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다. 나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.
    // 파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
    // N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.

    val t = readLine()!!.toInt()
    for (testCase in 0 until t) {
        val n = readLine()!!.toInt()
        val array = arrayListOf<Long>()
        (0..100).map { array.add(0.toLong()) }

        array[1] = 1.toLong()
        array[2] = 1.toLong()
        array[3] = 1.toLong()
        array[4] = 2.toLong()
        array[5] = 2.toLong()

        for(i in 6..n){
            array[i] = array[i - 1] + array[i - 5]
        }

        println(array[n])
    }

    // Solution
    // a1 + a5 = a6
    // a2 + a6 = a7
    // a3 + a7 = a8
    // a4 + a8 = a9
    // 점화식 : ai = ai-1 + ai-5
}
