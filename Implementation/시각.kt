fun main() {
    // Problem
    // 시각
    // 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서
    // 3이 하나라도 포함되는 모든 경우의 수를 구하시오.
    // 예를 들어, 1을 입력했을 때 00시 13분 30초는 3이 하나로 포함되어 있으므로 세어야 하는 시각이다.

    val n = readLine()!!.toInt()
    var count = 0

    for(i in 0 .. n){
        for(j in 0 until 60){
            for(k in 0 until 60){
                if('3' in (i.toString() + j.toString() + k.toString())){
                    count++
                }
            }
        }
    }

    println(count)
    // Solution
    // 완전 탐색을 통해 1초 씩 늘려가며 3이 들어가어 있는지 확인한다.
}
