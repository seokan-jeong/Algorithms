fun main() {
    // 계수 정렬(Count Sort)
    var array = arrayListOf<Int>(7, 5, 9, 0, 3, 1, 6, 2, 4, 8, 0, 5, 2)

    var count = arrayListOf<Int>()
    for(i in 0..array.maxOrNull()!!){
        count.add(0)
    }

    for(i in 0 until array.size){
        count[array[i]] += 1    // 각 데이터에 해당하는 인덱스의 값 증가
    }

    for(i in 0 until count.size){
        for(j in 0 until count[i]){
            print("$i ")
        }
    }
}
