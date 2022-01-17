fun main() {
    // Problem
    // 1748. 수 이어 쓰기 1
    // 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
    // 1234567891011121314...
    // 이렇게 만들어진 새로운 수는 몇자리 수 일까?

    val n = readLine()!!.toInt()
    var pastNumber = 0
    var number = 9
    var multiParameter = 1
    var sum = 0

    while(true) {
        if(n > number){
            sum += (number - pastNumber) * multiParameter
            pastNumber = number
            number = (number + 1) * 10 - 1
            multiParameter++
        }else{
            sum += (n - pastNumber) * multiParameter
            break
        }
    }

    print(sum)

    // Solution
    // 직접 수를 만들어 수의 길이를 구한다.    --> 메모리 초과
    // 수를 직접 만들지 않고 수의 숫자 길이만 구하여 계속 더하여 전체 수의 길이를 구한다.    --> 메모리 초과
    // 수의 길이 별로 단계를 나눠서 구한다.
}
