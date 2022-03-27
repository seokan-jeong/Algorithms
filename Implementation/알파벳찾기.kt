/* 10809. 알파벳 찾기
    알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
 */

fun main() {
    val s = readLine()!!
    val alphabet = arrayListOf<Int>()
    for (i in 0 until 26) {
        alphabet.add(-1)
    }

    var count = 0
    for (chr in s) {
        val index = chr.toInt() - 97
        if (alphabet[index] == -1) {
            alphabet[index] = count
        }
        count++
    }

    for (i in alphabet) {
        print("$i ")
    }
}
