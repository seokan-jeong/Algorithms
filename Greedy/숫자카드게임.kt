fun main() {
    // Problem
    // 숫자카드게임 : 여러 개의 숫자 카드 중에서 가장 높은 숫자가 쓰인 카드 한 장을 뽑는 게임
    // <게임 룰>
    // 1. 숫자가 쓰인 카드들이 N X M 형태로 놓여있다. 이 때 N은 행의 개수를 의미하며, M은 열의 개수를 의미한다.
    // 2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
    // 3. 그 다음 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야 한다.
    // 4. 따라서 처음에 카드를 골라낼 행을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여
    //    최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.

    val input1 = readLine()!!.split(' ').toMutableList()
    val column = input1[0].toInt()
    val row = input1[1].toInt()

    var array = Array<IntArray>(column, {IntArray(row)})

    for(i in 0..column - 1){
        val input2 = readLine()!!.split(' ').toMutableList()
        for(j in 0..row - 1){
            array[i][j] = input2[j].toInt()
        }
    }

    var min = 100
    var max = 1
    for(i in 0..column - 1){
        for(j in 0..row - 1){
            if(array[i][j] < min){
                min = array[i][j]
            }
        }
        if(max < min){
            max = min
        }
        min = 100
    }

    print(max)

    // Solution
    // 각 행에서 가장 작은 수를 찾아 모은 뒤,
    // 그 중 가장 큰 수를 고르면 됨.
    
    // Issues
    // Kotlin 배열 쓰기가 생각보다 편하지가 않다.
    // 코테용 언어는 C++이 손에 익은 것도 있고
    // 생각했던거보다 Kotlin이 막 편하지도 않다.
}
