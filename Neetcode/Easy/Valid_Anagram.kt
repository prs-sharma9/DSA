// LINK: https://neetcode.io/problems/is-anagram/question?list=neetcode150

/*
* THE PROBLEM
* I'm given two strings and I need to check whether one is an anagram of the other -- meaning
* they're made of exactly the same letters, just possibly in a different order.
*
* MY THOUGHT PROCESS
* If the two strings don't even have the same length, they can't possibly be anagrams, so that's
* an easy early exit.
*
* Beyond that, I need a way to compare "letter content" without caring about order. Since I know
* I'm only dealing with lowercase letters, I can use a fixed-size array of 26 counters -- one per
* letter of the alphabet. As I walk both strings at the same time, I increment the counter for
* each letter I see in `s`, and decrement the counter for each letter I see in `t`. If the two
* strings are truly anagrams, every increment from `s` should be perfectly cancelled out by a
* decrement from `t`, leaving every counter at zero.
*
* WALKING THROUGH AN EXAMPLE
* s = "anagram", t = "nagaram" (same length, so I proceed)
*   - Walking both strings together, every letter that shows up in `s` also shows up the same
*     number of times in `t`, so each +1 from `s` gets matched by a -1 from `t`.
*   - By the end, every slot in freqArray is back to 0, so none of them is greater than 0, and
*     I return true.
*
* A mismatch case, s = "rat", t = "car":
*   - freqArray ends up with leftover positive counts for 'r' and 't' (letters in `s` that never
*     got cancelled out by `t`), so `freqArray.any { it > 0 }` is true, and I return false.
*
* WHY THIS WORKS
* Because I already confirmed both strings are the same length, the counts in freqArray must sum
* to zero overall. That means if no counter is left positive, none can be left negative either --
* so checking only for positive leftovers is enough to confirm every letter matched up exactly.
*
* COMPLEXITY
* Time: O(n) -- one pass over both strings, where n is their length.
* Space: O(1) -- the frequency array is a fixed size of 26, regardless of input size.
*/

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
