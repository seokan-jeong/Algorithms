fun main() {
    // Problem
    // 어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다.
    // 단, 두 번째 연산은 N이 K로 나누어 떨어질 때만 선택할 수 있다.
    // 1. N에서 1을 뺀다.
    // 2. N을 K로 나눈다.
    // N과 K가 주어질 때 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 최소 횟수는?

    val input = readLine()!!.split(' ').toMutableList()
    var n = input[0].toInt()
    val k = input[1].toInt()
    var count = 0

    while(true){
        if(n == 1){
            break
        }else{
            count++
        }

        if(n % k == 0){
            n /= k
        }else{
            n -= 1
        }
    }

    print(count)
    
    // Solution
    // N이 1이 되기 전까지 1번 과정(1을 뺀다)보다 2번 과정(K로 나눈다)이 무조건 이득이다.
    // K로 나눌 수 있는지 먼저 확인하고 불가능할시 1을 빼는 방향으로 간다.
}
