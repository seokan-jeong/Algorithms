fun main() {
    // 선택 정렬(Selection Sort)
    var array = arrayListOf<Int>(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)

    fun quick_sort(array: ArrayList<Int>, start: Int, end: Int){
        if(start >= end){   // 원소가 1개인 경우 종료
            return
        }
        val pivot = start   // pivot은 첫 번째 원소
        var left = start + 1
        var right = end

        while(left <= right){
            // pivot보다 큰 데이터를 찾을 때까지 반복
            while(left <= end && array[left] <= array[pivot]){
                left += 1
            }
            // pivot보다 작은 데이터를 찾을 때까지 반복
            while(right > start && array[right] >= array[pivot]){
                right -= 1
            }
            if(left > right){   // 엇갈렸다면 작은 데이터와 pivot을 교체
                array[right] = array[pivot].also { array[pivot] = array[right] }
            }else{  // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
                array[left] = array[right].also { array[right] = array[left] }
            }
        }

        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        quick_sort(array, start, right - 1)
        quick_sort(array, right + 1, end)
    }

    quick_sort(array, 0, array.size - 1)

    print(array)
}
