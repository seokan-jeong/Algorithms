fun main() {
    // Problem
    // 500원, 100원, 50원, 10원짜리 동전 무한히 존재
    // 거슬러 줘야 할 돈이 n일 때 거슬러 줘야 할 동전의 최소 개수
    var n: Int = 1260
    var count: Int = 0
    var coinList = listOf<Int>(500, 100, 50, 10)

    for(coin in coinList){
        count += n / coin
        n %= coin
    }

    print(count)

    // Solution
    // 단위가 큰 동전부터 최대로 거슬러 주면서 차례대로 단위를 줄여감.
}
