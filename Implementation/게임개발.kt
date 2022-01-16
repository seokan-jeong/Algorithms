fun main() {
    // Problem
    // 게임 개발
    // 캐릭터가 있는 장소는 1 X 1 크기의 정사각형으로 이뤄진 N X M 크기의 직사각형이다.
    // 맵의 각 칸은 (A, B)로 나타낼 수 있고, A는 북쪽으로부터 떨어진 칸의 개수, B는 서쪽으로부터 떨어진 칸의 개수이다.
    // 캐릭터는 상하좌우로 움직일 수 있고, 바다로 되어 있는 공간에는 갈 수 없다.
    // 캐릭터의 움직임을 설정하기 위해 정해 놓은 매뉴얼은 이러하다.
    //  1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 갈 곳을 정한다.
    //  2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한 칸을 전진한다.
    //     왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향으로 회전만 수행하고 1단계로 돌아간다.
    //  3. 만약 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우에는, 바라보는 방향을 유치한 채로 한 칸 뒤로 가고 1단계로 돌아간다.
    //     단, 이 때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.
    // 매뉴얼에 따라 캐릭터를 이동 시킨 뒤에, 캐릭터가 방문한 칸의 수를 출력하라.

    val input1 = readLine()!!.split(" ").map { it.toInt() }
    val n = input1[0]
    val m = input1[1]

    var d = Array(n, { Array(m, { 0 }) })
    val input2 = readLine()!!.split(" ").map { it.toInt() }
    var x = input2[0]
    var y = input2[1]
    var direction = input2[2]

    var array = ArrayList<List<Int>>()
    for(i in 0 until n){
        val input3 = readLine()!!.split(" ").map { it.toInt() }
        array.add(input3)
    }
    var dx = arrayListOf(-1, 0, 1, 0)
    var dy = arrayListOf(0, 1, 0, -1)

    fun turnLeft(){
        direction -= 1
        if(direction == -1){
            direction = 3
        }
    }

    var count = 1
    var turnTime = 0

    while(true){
        turnLeft()  // 왼쪽으로 회전
        var nx = x + dx[direction]
        var ny = y + dy[direction]

        // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
        if(d[nx][ny] == 0 && array[nx][ny] == 0){
            d[nx][ny] = 1
            x = nx
            y = ny
            count++
            turnTime = 0
        }else if(turnTime == 4){    // 네 방향 모두 갈 수 없는 경우
            nx = x - dx[direction]
            ny = y - dy[direction]
            if(array[nx][ny] == 0){ // 뒤로 갈 수 있다면 이동하기
                x = nx
                y = ny
            }else{  // 뒤가 바다로 막혀있는 경우
                break
            }
            turnTime = 0
        }else{  // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
            turnTime++
        }
    }

    print(count)

    // Solution
    // 방향을 설정해서 이동하여 모든 방향을 차례대로 확인한다.
}
