// LINK: https://neetcode.io/problems/is-palindrome/question?list=neetcode150

class Solution {
    fun isPalindrome(s: String): Boolean {
        var start = 0
        val str = purge(s.lowercase())
        var end = str.length-1
        while(start<end) {
            if(str[start] == str[end]) {
                start++
                end--
            } else {
                return false
            }
        }
        return true
    }

    fun purge(s: String): String {
        val sb = StringBuilder()
        for(c in s) {
            if((c>='0' && c<='9') || (c>='a' && c<='z')) {
                sb.append(c)
            }
        }
        return sb.toString()
    }
}
