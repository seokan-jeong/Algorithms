fun main() {
    // Problem
    // 14503. 로봇 청소기
    // 로봇 청소기가 있는 장소는 N X M 크기의 직사각형으로 나타낼 수 있으며, 1 X 1 크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다.
    // 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북 중 하나이다.
    // 지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수이다.
    // 로봇 청소기는 다음과 같이 작동한다.
    //  1. 현재 위치를 청소한다.
    //  2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
    //      a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
    //      b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
    //      c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한채로 한 칸 후진을 하고 2번으로 돌아간다.
    //      d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.

    val input1 = readLine()!!.split(" ").map { it.toInt() }
    val n = input1[0]
    val m = input1[1]
    val input2 = readLine()!!.split(" ").map { it.toInt() }
    var r = input2[0]
    var c = input2[1]
    var d = input2[2]   // 0:북쪽, 1:동쪽, 2:남쪽, 3:서쪽

    var place = mutableListOf<MutableList<Int>>()
    for(i in 0 until n){
        val inputs = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
        place.add(inputs)
    }

    val dx = arrayListOf(0, 1, 0, -1)
    val dy = arrayListOf(-1, 0, 1, 0)

    var result = 0
    var searchDirection = 0

    while(true){
        place[r][c] = 2
        result++

        var loopCnt = 0
        while(true){
            when(d){
                0-> searchDirection = 3
                1-> searchDirection = 0
                2-> searchDirection = 1
                3-> searchDirection = 2
            }

            if(place[r + dy[searchDirection]][c + dx[searchDirection]] == 0){
                d = searchDirection
                r += dy[d]
                c += dx[d]
                break
            }else{
                loopCnt++
                d = searchDirection
            }

            if(loopCnt == 4){
                if(place[r - dy[d]][c - dx[d]] != 1){
                    r -= dy[d]
                    c -= dx[d]
                    loopCnt = 0
                }else{
                    print(result)
                    return
                }
            }
        }

    }

    // Solution
    // 문제가 어렵기보다는 조건이 많아서 시뮬레이션 돌리는 과정을 설계하는게
    // 조금 헷갈렸다.
    // 문제에서 주는대로 조건만 구현한 문제이다.
}
