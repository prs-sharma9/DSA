class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.length == 0) return 0
        if(s.length == 1) return 1
        val charSet = mutableSetOf<Char>()
        var result = 0
        var start = 0
        var end = 1
        charSet.add(s[start])
        while(end < s.length) {
            if(!charSet.add(s[end])) {
                val len = end - start
                if (len > result) result = len
                while(s[start] != s[end]) {
                    charSet.remove(s[start])
                    start++
                }
                
                start++
                charSet.add(s[start])
            }
            end ++
        }
        if(end-start > result) result = end - start
        return result
    }
}

