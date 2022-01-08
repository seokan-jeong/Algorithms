fun main() {
    // Problem
    // N X N 크기의 정사각형 공간 위에서 Left, Right, Up, Down 명령대로 움직였을 때 최종 위치
    // 단, 공간을 벗어나는 움직임은 무시된다. (ex : (1, 1)의 위치에서 L 혹은 U를 만났을 때)


    val input1 = readLine()
    val input2 = readLine()!!.split(' ').toMutableList()

    val square = input1!!.toInt()
    var x = 1
    var y = 1

    for(i in input2){
        when(i){
            "L"->{
              if(x > 1){
                  x -= 1
              }
            }
            "R"->{
                if(x < square){
                    x += 1
                }
            }
            "U"->{
                if(y > 1){
                    y -= 1
                }
            }
            "D"->{
                if(y < square){
                    y += 1
                }
            }
        }
    }

    print("$y $x")


    // Solution
    // 입력 받은대로 명령을 수행하며 공간 밖으로 벗어나는 예외적인 케이스만 확인해주며
    // 좌표를 이동한다.
}
