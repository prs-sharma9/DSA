class Solution {
    fun minWindow(s: String, t: String): String {
        if(t.length > s.length) return ""
        if (t.length == 1 && s.contains(t[0])) return t
        val tmap = IntArray(123)            // frequency array for target string
        val wmap = IntArray(123)            // frequency array for window under consideration
        var need = 0                        // unique characters in target string
        var found = 0                       // unique characters found so far in window under consideration
        var resLen  = Int.MAX_VALUE
        var resl = -1
        var resr = -1
        var l = 0

        for(idx in 0 until t.length) {
            val c = t[idx].code
            if(tmap[c] == 0) need++
            tmap[c]++
        }

        for( r in 0 until s.length) {
            val c = s[r].code
            wmap[c]++
            if(tmap[c] > 0 && wmap[c] == tmap[c]) {
                found ++
            }
            
            while(found == need) {
                // we have found a possible solution,
                // start moving left pointer to find a better solution
                if(r-l+1 < resLen) {
                    resLen = r-l+1
                    resl = l
                    resr = r
                }
                val lc = s[l].code
                wmap[lc]--
                if(tmap[lc] > 0 && wmap[lc] < tmap[lc]) 
                {
                    found --
                }
                l++
            }
            
        }

        if(resLen == Int.MAX_VALUE) return ""
        return s.substring(resl..resr)
    }
}

