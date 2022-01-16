fun main() {
    // Problem
    // 왕실의 나이트
    // 왕실 정원은 8 X 8 좌표 평면이다.
    // 나이트는 L자 형태로만 이동할 수 있으며 정원 밖으로는 나갈 수 없다.
    // 나이트는 특정한 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.
    //  1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
    //  2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
    // 8 X 8 좌표 평면 상에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 구하라.

    val input = readLine()!!
    val column = input[0].toInt() - 'a'.toInt() + 1
    val row = input[1].toString().toInt()

    val steps = mutableListOf<Pair<Int, Int>>(
        Pair(-2, -1),
        Pair(-1, -2),
        Pair(1, -2),
        Pair(2, -1),
        Pair(2, 1),
        Pair(1, 2),
        Pair(-1, 2),
        Pair(-2, 1)
    )

    var result = 0
    for(step in steps){
        val nextRow = row + step.first
        val nextColumn = column + step.second
        
        if(nextRow >= 1 && nextRow <= 8
            && nextColumn >= 1 && nextColumn <= 8){
            result += 1
        }
    }

    print(result)

    // Solution
    // 나이트를 이동시킬 수 있는 방향으로 다 이동시켜보며
    // 모든 케이스를 확인해본다.
}
