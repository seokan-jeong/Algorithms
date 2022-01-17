fun main() {
    // Problem
    // 14891. 톱니바퀴
    // 총 8개의 톱니를 가지고 있는 톱니바퀴 4개가 일렬로 놓아져있다.
    // 또, 톱니는 N극 또는 S극 중 하나를 나타내고 있다.
    // 톱니바퀴에는 번호가 매겨져 있는데, 가장 왼쪽 톱니바퀴가 1번, 그 오른쪽은 2번, 그 오른쪽은 3번, 가장 오른쪽 톱니바퀴는 4번이다.
    // 이때, 톱니바퀴를 총 k번 회전시키려고 한다. 톱니바퀴의 회전은 한 칸을 기준으로 하고, 회전은 시계 방향과 반시계 방향이 있다.
    // 톱니바퀴를 회전시키려면, 회전시킬 톱니바퀴와 회전시킬 방향을 결정해야한다.
    // 톱니바퀴가 회전할 때, 서로 맞닿은 극에 따라서 옆에 있는 톱니 바퀴를 회전시킬 수도 있고, 회전시키지 않을 수도 있다.
    // 톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다.
    // 톱니바퀴의 초기 상태와 톱니바퀴를 회전시킨 방법이 주어졌을 때, 최종 톱니바퀴의 상태를 구하라.

    var gear = mutableListOf<MutableList<Int>>()
    var check = arrayListOf(0, 0, 0, 0)

    fun inputGear(inputs: String): MutableList<Int> {
        val list = mutableListOf<Int>()
        for (input in inputs) {
            list.add(input.toString().toInt())
        }
        return list
    }

    gear.add(inputGear(readLine()!!))
    gear.add(inputGear(readLine()!!))
    gear.add(inputGear(readLine()!!))
    gear.add(inputGear(readLine()!!))

    fun simulateGear(gearNumber: Int, rotateDirection: Int) {
        check[gearNumber] = 1
        if (gearNumber != 0 &&
            check[gearNumber - 1] == 0 &&
            gear[gearNumber][6] != gear[gearNumber - 1][2]
        ) {
            simulateGear(gearNumber - 1, -rotateDirection)
        }
        if (gearNumber != 3 &&
            check[gearNumber + 1] == 0 &&
            gear[gearNumber][2] != gear[gearNumber + 1][6]
        ) {
            simulateGear(gearNumber + 1, -rotateDirection)
        }
        Collections.rotate(gear[gearNumber], rotateDirection)
        check[gearNumber] = 0
    }

    val rotateNumber = readLine()!!.toInt()

    for (rotate in 0 until rotateNumber) {
        val input = readLine()!!.split(" ").map { it.toInt() }
        val selectedGear = input[0]
        val rotateDirection = input[1]

        simulateGear(selectedGear - 1, rotateDirection)
    }

    var score = gear[0][0] * 1 + gear[1][0] * 2 + gear[2][0] * 4 + gear[3][0] * 8

    print(score)

    // Solution
    // 톱니바퀴 시물레이션을 직접 만들어간다는 생각으로 차근차근 구현했다.
    // 재귀를 통하여 양 옆 톱니바퀴를 확인하면서 회전시켰고
    // 회전하고 있는 톱니바퀴를 체크하여 회전이 끝난 후에는 다시 회전할 수 있도록 하였다.
}
