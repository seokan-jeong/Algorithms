fun main() {
    // Problem
    // 가로의 길이가 N, 세로의 길이가 2인 직사각형 형태의 얇은 바닥이 있다.
    // 세오칸은 이 얇은 바닥을 1 X 2의 덮개, 2 X 1의 덮개, 2 X 2의 덮개를 이용해 채우고자 한다.
    // 이 때 바닥을 채우는 모든 경우의 수를 구하라.
    val n = readLine()!!.toInt()

    val d = arrayListOf<Int>()
    (0..1000).map { d.add(0) }

    d[1] = 1
    d[2] = 3
    for (i in 3..n) {
        d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796
    }

    print(d[n].toString())

    // Solution
    // ai = ai-1 + 2 * ai-2
}
