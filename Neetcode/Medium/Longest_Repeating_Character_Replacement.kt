class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        if(s.length == 1) return 1
        if(k == s.length) return s.length
        var l = 0
        var r = 0
        var result = 0
        val countMap = hashMapOf<Char, Int>()
        while(r < s.length) {
            var freq = countMap.get(s[r]) ?: 0
            countMap.put(s[r++], freq+1)
            val replacementRequired = (r-l) - (countMap.values.maxOrNull() ?: 0)
            if(replacementRequired > k) {
                // invalid window. 
                // start moving left until the window is valid again
                while((r-l) - (countMap.values.maxOrNull() ?: 0) > k) {
                    var f = countMap.get(s[l]) ?: 0
                    if(f < 0) throw IllegalStateException()
                    countMap.put(s[l], f - 1)
                    l++
                }
            }
            if (r-l > result) result = r-l
        } 
        return result
    }
}

