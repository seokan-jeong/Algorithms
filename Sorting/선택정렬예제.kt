fun main() {
    // 선택 정렬(Selection Sort)
    var array = arrayListOf<Int>(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)

    for(i in 0 until array.size){
        var min_index = i   // 가장 작은 원소의 인덱스
        for(j in i + 1 until array.size){
            if(array[min_index] > array[j]){
                min_index = j
            }
        }
        array[i] = array[min_index].also { array[min_index] = array[i] }
    }

    print(array)
}
