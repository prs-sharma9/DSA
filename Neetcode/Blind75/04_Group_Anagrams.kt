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

/*
* THE PROBLEM
* I'm given an array of strings and I need to group the ones that are anagrams of each other
* into their own sub-lists. Two strings are anagrams if they're made of exactly the same
* letters, just rearranged -- so "eat", "tea", and "ate" all belong together.
*
* MY THOUGHT PROCESS
* The first thing I need is a way to tell "these two strings are anagrams of each other"
* without comparing every string to every other string (that's what my first attempt did,
* and it was O(n^2) at best -- way too slow for large inputs).
*
* What I really want is some kind of "fingerprint" for a word -- something that's identical
* for every anagram of that word, but different for words that aren't anagrams. If I can
* compute that fingerprint, I can just bucket words by it and I'm done in one pass.
*
* The simplest fingerprint I can think of: sort the letters. "eat" -> "aet", "tea" -> "aet",
* "ate" -> "aet". Any anagram of "eat" will sort down to the exact same string. So I use that
* sorted string as a key into a HashMap, where each key maps to the list of original words
* that share it.
*
* WALKING THROUGH AN EXAMPLE
* Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
*   - "eat" sorts to "aet"  -> map: { "aet": ["eat"] }
*   - "tea" sorts to "aet"  -> map: { "aet": ["eat", "tea"] }
*   - "tan" sorts to "ant"  -> map: { "aet": [...], "ant": ["tan"] }
*   - "ate" sorts to "aet"  -> map: { "aet": ["eat", "tea", "ate"], "ant": ["tan"] }
*   - "nat" sorts to "ant"  -> map: { "aet": [...], "ant": ["tan", "nat"] }
*   - "bat" sorts to "abt"  -> map: { ..., "abt": ["bat"] }
* Reading out the map's values gives me: [["eat","tea","ate"], ["tan","nat"], ["bat"]]
*
* WHY THIS WORKS
* Sorting guarantees that anagrams -- and only anagrams -- collapse to the same key, so the
* HashMap does all the grouping work for me in a single pass over the input.
*
* COMPLEXITY
* Time: O(n * k log k), where n is the number of strings and k is the max string
* length -- sorting each string dominates the cost.
* Space: O(n * k) to store all the strings in the HashMap.
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


