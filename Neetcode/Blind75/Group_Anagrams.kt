/* 
* My solution: really really bad performance, cannot be used
*/
// class Solution {
//     fun groupAnagrams(strs: Array<String>): List<List<String>> {
//     var result: MutableList<MutableList<String>> = mutableListOf()
//     var anagramList: MutableList<MutableList<Word>> = mutableListOf()
//     strs.forEach { ipWord ->
//         val wordObj = Word(ipWord)
//         var flag = false
//         var idx = 0
//         for(i in 0 until anagramList.size) {
//             if(anagramList[i][0] == wordObj) {
//                 flag = true
//                 idx = i
//                 break
//             }
//         }
//         // println("flag: $flag: idx: $idx")
//         if(flag) {
//             anagramList[idx].add(wordObj)
//         } else {
//             anagramList.add(mutableListOf(Word(ipWord)))
//         }
//     }
//     anagramList.forEach { list ->
//         val resultList = mutableListOf<String>()
//         list.forEach { wordObj ->
//             resultList.add(wordObj.word)
//         }
//         result.add(resultList)
//     }

//     return result
// }
// }

// class Word {
//     private var len: Int = 0
//     var word: String = ""
//     private var chars = IntArray(26)
//     constructor(w: String) {
//         word = w
//         len = w.length
//         w.forEach { chars[it-'a']++ }
//     }

//     override fun equals(other: Any?): Boolean {
//         if (other !is Word ) return false
//         if (other.len != len ) return false
//         return this.chars.contentEquals(other.chars)
//     }
// }

/*
* A much better solution from website.
*/

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val hashMap = HashMap<String, MutableList<String>>()
        for (s in strs) {
            val key = s.toCharArray().sorted().joinToString()
            val list = hashMap.getOrPut(key) { mutableListOf<String>() }
            list.add(s)
        }

        val result = mutableListOf<List<String>>()
        for ( list in hashMap.values ) {
            result.add(list)
        }
        return result
    }
}


