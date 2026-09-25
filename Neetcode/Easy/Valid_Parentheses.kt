class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayList<Char>()
        for(c in s) {
            when (c) {
                '(', '{', '[' -> {
                    stack.add(0, c)
                }
                ')' -> {
                    if(stack.isEmpty()) return false
                    val popElement = stack.get(0)
                    stack.removeAt(0)
                    if(popElement != '(') return false
                }
                '}' -> {
                    if(stack.isEmpty()) return false
                    val popElement = stack.get(0)
                    stack.removeAt(0)
                    if(popElement != '{') return false
                }
                ']' -> {
                    if(stack.isEmpty()) return false
                    val popElement = stack.get(0)
                    stack.removeAt(0)
                    if(popElement != '[') return false
                }
                else -> {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}

