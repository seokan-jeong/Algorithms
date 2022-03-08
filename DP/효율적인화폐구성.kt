import java.lang.Integer.min

fun main() {
    // Problem
    // N가지 종류의 화폐가 있다. 이 화폐들의 개수를 최소한으로 이용해서 그 가치의 합이 M원이 되도록 하려고 한다.
    // 이 때 각 화폐는 몇 개라도 사용할 수 있으며, 사용한 화폐의 구성은 같지만 순서만 다른 것은 같은 경우로 구분한다.

    val input = readLine()!!.split(' ').map { it.toInt() }
    val n = input[0]
    val m = input[1]

    val array = arrayListOf<Int>()
    for(i in 0 until n){
        array.add(readLine()!!.toInt())
    }

    var d = arrayListOf<Int>()
    (0..m).map { d.add(10001) }

    d[0] = 0
    for(i in 0 until n){
        for(j in array[i]..m){
            if(d[j - array[i]] != 10001){   // (i - k)원을 만드는 방법이 존재하는 경우
                d[j] = min(d[j], d[j - array[i]] + 1)
            }
        }
    }

    if(d[m] == 10001){
        print(-1)
    }else{
        print(d[m])
    }

    // Solution
    // 금액 i를 만들 수 있는 최소한의 화폐 개수를 ai, 화퍠의 단위를 k라고 했을 때
    // ai-k를 만드는 방법이 존재하는 경우, ai = min(ai, ai-k + 1)
    // ai=k를 만드는 방법이 존재하지 않는 경우, ai = 10,001
}
