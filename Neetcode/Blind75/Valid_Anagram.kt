class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length!=t.length) return false
        var freqArray = IntArray(26)
        var result = false;
        for(i in s.indices) {
            freqArray[s[i]-'a']++
            freqArray[t[i]-'a']--
        }
        return !freqArray.any { it > 0 }
    }
}
