fun main() {
    // Problem
    // 백준 1789번. 수들의 합
    // 서로 다른 N개의 자연수의 합이 S이다.
    // S를 알 때, 자연수 N의 최대값은 얼마일까?

    val s = readLine().toString().toBigInteger()
    var sum = 0.toBigInteger()
    var n = 0.toBigInteger()

    while(s >= sum){
        n++
        sum += n
    }

    if(sum > s){
        n--
    }
    
    print(n)
    
    // Solution
    // 일단 1부터 차례대로 더하고
    // 마지막에 S를 넘겼다면
    // 넘긴 수를 더하지 않았던걸로 가정하고 N을 1 줄이면 됨.
}
