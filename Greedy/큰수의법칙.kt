fun main() {
    // Problem
    // N개의 주어진 원소를 M번 더하여 가장 큰 수를 만들어내라.
    // 단, 같은 수를 K번 연속으로 사용할 수는 없다.

    // n, k, m 입력 받기
    val input1 = readLine()!!.split(' ').map{ it.toInt() }
    val n = input1[0]
    val m = input1[1]
    val k = input1[2]

    // data 입력 받기
    val data = readLine()!!.split(' ').toMutableList()
    data.sortDescending()   // data 배열 정렬

    var count = 0
    var sum = 0
    val first = data[0].toInt()
    val second = data[1].toInt()

    for(i in 0..m-1){
        if(count < k){
            sum += first
            count++
        }else{
            sum += second
            count = 0
        }
    }

    print(sum)

    // Solution
    // 가장 큰 수가 K번 연속되지만 않으면 되므로
    // K-1번씩 더하다가 1번씩 두 번째로 큰 수를 더해주면 됨.
}
