fun main() {
    // 삽입 정렬(Insertion Sort)
    var array = arrayListOf<Int>(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)

    for(i in 1 until array.size){
        for(j in i downTo(1) step(1)){
            if(array[j] < array[j - 1]){    // 한 칸씩 왼쪽으로 이동
                array[j] = array[j - 1].also {array[j - 1] = array[j]}
            }else{
                break
            }
        }
    }

    print(array)
}
