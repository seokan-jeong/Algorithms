fun main() {
    val d = arrayListOf<BigInteger>()
    (0 until 100).map { d.add(0.toBigInteger()) }

    // 피보나치 함수를 재귀함수로 구현(탑다운 다이나믹 프로그래밍)
    fun fibo(x: Int): BigInteger {
        // 종료 조건(1 혹은 2일 때 1을 반환)
        if (x == 1 || x == 2) {
            return 1.toBigInteger()
        }
        // 이미 계산한 적 있는 문제라면 그대로 반환
        if (d[x] != 0.toBigInteger()) {
            return d[x]
        }
        // 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
        d[x] = fibo(x - 1) + fibo(x - 2)
        return d[x]
    }

    print(fibo(99))
}
