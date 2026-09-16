// LINK: https://neetcode.io/problems/string-encode-and-decode/question?list=neetcode150

/*
* THE PROBLEM
* I need to encode a list of strings into a single string, and then be able to decode that single
* string back into the exact original list -- even if the strings themselves contain unusual
* characters.
*
* MY THOUGHT PROCESS
* The tricky part of this problem is picking a way to glue the strings together that I can
* reliably split apart again later. If I just joined strings with a plain delimiter like a comma,
* I'd be stuck if one of the original strings also contained a comma -- I wouldn't know if that
* comma was a separator or part of the data.
*
* My fix: instead of relying purely on a delimiter, I prefix every string with its own length.
* So encoding becomes: write the length of the string, then a delimiter character, then the
* string itself, and repeat for every string in the list. I picked the character 'Omega' as the
* delimiter since it's extremely unlikely to show up in normal input, but the length prefix is
* really what makes this bulletproof -- even if a string contained the delimiter, decoding still
* knows exactly how many characters to read because it already knows the length.
*
* Decoding just reverses the process: read characters until I hit the delimiter, treat everything
* read so far as the length, then read exactly that many characters as the next string, and
* repeat until I've consumed the whole encoded string.
*
* WALKING THROUGH AN EXAMPLE
* encode(["hi", "leetcode"])
*   - "hi" has length 2 -> write "2" + delimiter + "hi"
*   - "leetcode" has length 8 -> write "8" + delimiter + "leetcode"
*   - Final encoded string: "2[delim]hi8[delim]leetcode"
*
* decode("2[delim]hi8[delim]leetcode")
*   - Read "2", hit the delimiter -> length = 2 -> read the next 2 characters: "hi" -> add "hi"
*   - Read "8", hit the delimiter -> length = 8 -> read the next 8 characters: "leetcode" -> add it
*   - Final result: ["hi", "leetcode"]
*
* WHY THIS WORKS
* Because every string is preceded by its exact length, decoding never has to guess where one
* string ends and the next begins -- it just reads however many characters the length says to,
* regardless of what those characters actually are.
*
* COMPLEXITY
* Time: O(n) for both encode and decode, where n is the total number of characters across all
* strings.
* Space: O(n) for the encoded string / the decoded list.
*/

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

