class Solution {

    fun encode(strs: List<String>): String {
        var builder = StringBuilder()
        val delimiter: Char = 'Ω'
        for (s in strs) {
            val len = s.length
            builder.append(len)
            .append(delimiter)
            .append(s)
        }
        return builder.toString()
    }

    fun decode(str: String): List<String> {
        val delimiter = 'Ω'
        val result: MutableList<String> = mutableListOf<String>()
        var idx = 0
        val builder = StringBuilder()
        var len: Int
        while(idx < str.length){
            val c = str[idx]
            if(c == delimiter) {
                len = builder.toString().toInt()
                idx++
                val word = str.substring(idx, idx+len)
                result.add(word)
                idx = idx+len
                builder.setLength(0)
            } else {
                builder.append(c)
                idx++
            }
        }
        
        return result
    }
}

